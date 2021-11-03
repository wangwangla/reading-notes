第三章比较详细的说了EGL的创建过程，在使用的过程中如果去使用呢。
- 先和窗口进行通信
- 得到句柄，然后进行初始化
- 自己遍历所有的属性选择，或者是让系统自己选择
- 使用属性创建窗口
- 创建GL上下文 
- 使用当前上下文
- 进行绘制
- 更新交换区

## 和窗口进行通信
```c
EGL10 egl10 = (EGL10) EGLContext.getEGL();
//获取表面
EGLDisplay eglDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
```     

##进行初始化
```java
//初始化  成功打开之后就进行一个初始化
egl10.eglInitialize(eglDisplay, new int[2]);
```
## 自己选择属性
```java
EGLConfig[] configs = new EGLConfig[1];
//要EGL选择匹配的EGLConfigs  自己指定 属性  返回configs
egl10.eglChooseConfig(eglDisplay,
          new int[]{EGL10.EGL_DEPTH_SIZE, 16, EGL10.EGL_NONE},
           configs,
            1,
            new int[1]);
```

## 创建窗口
```java
EGLConfig eglEGLConfig = configs[0];
//创建屏幕渲染窗口
EGLSurface eglSurface = egl10.eglCreateWindowSurface(eglDisplay, eglEGLConfig,
EGLGLSurfaceView.this.getHolder(), null);
```
## 创建渲染上下文
```java
//创建渲染上下文
EGLContext eglContext = egl10.eglCreateContext(eglDisplay, eglEGLConfig, EGL10.EGL_NO_CONTEXT, null);
```
## 使用当前
```java  
egl10.eglMakeCurrent(eglDisplay, eglSurface, eglSurface, eglContext);
mGL10 = (GL10) eglContext.getGL();
```

## 绘制 
```java
while (isKeyFlag()) {
    onDrawFrame(mGL10);
//交换缓存区
     egl10.eglSwapBuffers(eglDisplay, eglSurface);
}
stop(egl10, eglDisplay, eglSurface, eglContext);
```

##  销毁
```java
private void stop(EGL10 egl10, EGLDisplay eglDisplay, EGLSurface eglSurface, EGLContext eglContext) {
            egl10.eglMakeCurrent(eglDisplay, EGL10.EGL_NO_SURFACE,         
     EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
    egl10.eglDestroyContext(eglDisplay, eglContext);
    egl10.eglDestroySurface(eglDisplay, eglSurface);
    mGL10 = null;
}
```
这个仅仅是创建了EGL,然后清了一下屏幕，并没有其它操作。
完整代码：
```java
public class EGLSurfaceViewDemo extends SurfaceView implements SurfaceHolder.Callback {
    private GL10 mGL10;
    public EGLSurfaceViewDemo(Context context) {
        super(context);
        //注册回调接口
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //开启线程
        startGLThreads();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // 关闭
        stopGLThreads();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
    }

    private void onDrawFrame(GL10 gl) {
        gl.glClearColor(1, 0, 0, 1.0f);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }


    private EGL_GLThread mEGL_GLThread;
    public void startGLThreads() {
        mEGL_GLThread = new EGL_GLThread();
        mEGL_GLThread.drawFlag(true);        //线程标志位为true
        mEGL_GLThread.start();
    }

    public void stopGLThreads() {
        mEGL_GLThread.drawFlag(false);
        mEGL_GLThread = null;
    }

    //刷帧线程
    private class EGL_GLThread extends Thread {
        private boolean keyFlag = false;
        @Override
        public void run() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglDisplay, new int[2]);
            EGLConfig[] configs = new EGLConfig[1];
            egl10.eglChooseConfig(eglDisplay,
                    new int[]{EGL10.EGL_DEPTH_SIZE, 16, EGL10.EGL_NONE},
                    configs,
                    1,
                    new int[1]);
            EGLConfig eglEGLConfig = configs[0];
            EGLSurface eglSurface = egl10.eglCreateWindowSurface(eglDisplay, eglEGLConfig,
                    EGLSurfaceViewDemo.this.getHolder(), null);
            EGLContext eglContext = egl10.eglCreateContext(eglDisplay, eglEGLConfig,
                    EGL10.EGL_NO_CONTEXT, null);
            egl10.eglMakeCurrent(eglDisplay, eglSurface, eglSurface, eglContext);
            mGL10 = (GL10) eglContext.getGL();
            //绘制是一直执行的
            while (isDrawing()) {
                onDrawFrame(mGL10);
                egl10.eglSwapBuffers(eglDisplay, eglSurface);
            }
            stop(egl10, eglDisplay, eglSurface, eglContext);
        }

        private void stop(EGL10 egl10, EGLDisplay eglDisplay, EGLSurface eglSurface, EGLContext eglContext) {
            egl10.eglMakeCurrent(eglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE,
                    EGL10.EGL_NO_CONTEXT);
            egl10.eglDestroyContext(eglDisplay, eglContext);
            egl10.eglDestroySurface(eglDisplay, eglSurface);
            mGL10 = null;
        }

        public void drawFlag(boolean keyFlag) {
            this.keyFlag = keyFlag;
        }

        public boolean isDrawing() {
            return keyFlag;
        }
    }
}
```
## 使用它绘制一个三角形
代码稍作整理：
```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <SurfaceView
        android:id="@+id/surface_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</LinearLayout>
```
创建一个EGLRender,它是一个线程。
```java
public class EGLRenderer extends HandlerThread {
    private EGLConfig eglConfig = null;
    private EGLDisplay eglDisplay = EGL14.EGL_NO_DISPLAY;
    private EGLContext eglContext = EGL14.EGL_NO_CONTEXT;

    private int program;
    private int vPosition;
    private int uColor;
    private SurfaceHolder surfaceHolder;
    public EGLRenderer(SurfaceHolder surfaceHolder) {
        super("EGLRenderer");
        this.surfaceHolder = surfaceHolder;
    }
    private void onCreate() {
        eglDisplay = EGL14.eglGetDisplay(EGL14.EGL_DEFAULT_DISPLAY);
        int[] version = new int[2];
        if (!EGL14.eglInitialize(eglDisplay, version, 0, version, 1)) {
            throw new RuntimeException("EGL error " + EGL14.eglGetError());
        }
        int[] configAttribs = {
                EGL14.EGL_BUFFER_SIZE, 32,
                EGL14.EGL_ALPHA_SIZE, 8,
                EGL14.EGL_BLUE_SIZE, 8,
                EGL14.EGL_GREEN_SIZE, 8,
                EGL14.EGL_RED_SIZE, 8,
                EGL14.EGL_RENDERABLE_TYPE, //renderable
                EGL14.EGL_OPENGL_ES2_BIT,
                EGL14.EGL_SURFACE_TYPE,
                EGL14.EGL_WINDOW_BIT,
                EGL14.EGL_NONE
        };
        int[] numConfigs = new int[1];
        EGLConfig[] configs = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(eglDisplay,
                configAttribs,
                0,
                configs,
                0,
                configs.length,
                numConfigs,
                0)) {
            throw new RuntimeException("EGL error " + EGL14.eglGetError());
        }
        eglConfig = configs[0];
        int[] contextAttribs = {
                EGL14.EGL_CONTEXT_CLIENT_VERSION, 2,
                EGL14.EGL_NONE
        };
        eglContext = EGL14.eglCreateContext(eglDisplay, eglConfig, EGL14.EGL_NO_CONTEXT, contextAttribs, 0);
        if (eglContext == EGL14.EGL_NO_CONTEXT) {
            throw new RuntimeException("EGL error " + EGL14.eglGetError());
        }
    }
    private void onDestroy() {
        EGL14.eglDestroyContext(eglDisplay, eglContext);
        eglContext = EGL14.EGL_NO_CONTEXT;
        eglDisplay = EGL14.EGL_NO_DISPLAY;
    }

    @Override
    public synchronized void start() {
        super.start();
        new Handler(getLooper()).post(new Runnable() {
            @Override
            public void run() {
                onCreate();
                surfaceCreated(surfaceHolder);
                while (true){
                    if(isDraw) {
                        onFrame();
                    }
                }
            }
        });
    }

    public void onRelease() {
        new Handler(getLooper()).post(new Runnable() {
            @Override
            public void run() {
                onDestroy();
                quit();
            }
        });
    }

    private int loadShader(int shaderType, String sourceCode) {
        int shader = GLES20.glCreateShader(shaderType);
        if (shader != 0) {
            GLES20.glShaderSource(shader, sourceCode);
            GLES20.glCompileShader(shader);
            int[] compiled = new int[1];
            GLES20.glGetShaderiv(shader, GLES20.GL_COMPILE_STATUS, compiled, 0);
            if (compiled[0] == 0) {
                Log.e("ES20_ERROR", "Could not compile shader " + shaderType + ":");
                Log.e("ES20_ERROR", GLES20.glGetShaderInfoLog(shader));
                GLES20.glDeleteShader(shader);
                shader = 0;
            }
        }
        return shader;
    }
    EGLSurface eglSurface;
    private static final String verticesShader
            = "attribute vec2 vPosition;            \n"
            + "void main(){                         \n"
            + "   gl_Position = vec4(vPosition,0,1);\n"
            + "}";

    private static final String fragmentShader
            = "precision mediump float;         \n"   
            + "uniform vec4 uColor;             \n"   
            + "void main(){                     \n"
            + "   gl_FragColor = uColor;        \n" 
            + "}";
    private FloatBuffer getVertices() {
        float vertices[] = {
                0.0f, 0.5f,
                -0.5f, -0.5f,
                0.5f, -0.5f,
        };
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder()); 
        FloatBuffer vertexBuf = vbb.asFloatBuffer(); 
        vertexBuf.put(vertices);
        vertexBuf.position(0);  
        return vertexBuf;
    }
    private int createProgram(String vertexSource, String fragmentSource) {
        int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vertexSource);
        if (vertexShader == 0) {
            return 0;
        }
        int pixelShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentSource);
        if (pixelShader == 0) {
            return 0;
        }
        int program = GLES20.glCreateProgram();
        return program;
    }

    private boolean isDraw = false;
    public void surfaceCreated(SurfaceHolder surface){
        final int[] surfaceAttribs = { EGL14.EGL_NONE };
        eglSurface = EGL14.eglCreateWindowSurface(eglDisplay, eglConfig, surface, surfaceAttribs, 0);
        EGL14.eglMakeCurrent(eglDisplay, eglSurface, eglSurface, eglContext);
        program = createProgram(verticesShader, fragmentShader);
        vPosition = GLES20.glGetAttribLocation(program, "vPosition");
        uColor = GLES20.glGetUniformLocation(program, "uColor");
        GLES20.glViewport(0,0,400,400);
        GLES20.glClearColor(1.0f, 0, 0, 1.0f);
        isDraw = true;
    }

    private void onFrame() {
        System.out.println("绘制");
        FloatBuffer vertices = getVertices();
GLES20.glClear(GLES20.GL_DEPTH_BUFFER_BIT | GLES20.GL_COLOR_BUFFER_BIT);
        GLES20.glUseProgram(program);
        GLES20.glVertexAttribPointer(vPosition, 2, GLES20.GL_FLOAT, false, 0, vertices);
        GLES20.glEnableVertexAttribArray(vPosition);
        GLES20.glUniform4f(uColor, 0.0f, 1.0f, 0.0f, 1.0f);
GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, 3);
        EGL14.eglSwapBuffers(eglDisplay, eglSurface);
        EGL14.eglDestroySurface(eglDisplay, eglSurface);
    }
}
```


Activity代码
```java
 setContentView(R.layout.activity_egl);
        SurfaceView surfaceView = findViewById(R.id.surface_view);
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                mGLRenderer = new EGLRenderer(surfaceHolder);
                mGLRenderer.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
             
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
```





