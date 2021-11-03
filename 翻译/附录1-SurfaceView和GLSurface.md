因为所有的案例通过java实现，所以需要了解一下surfaceView和GLSurfaceView,他们作为绘制的载体，我们绘制的东西需要绘制到它们上面，
## GLSurfaceView和SurfaceView的区别
- GLSurfaceView管理了EGL的相关创建部分，不需要自己创建，并且使用的时候只需要调用三个声明周期函数。SurfaceView使用的时候需要自己创建EGL相关的内容。
- GLSurfaceView不需要自己创建线程，SurfaceView需要自己创建绘制线程。
GLSurfaceView是SurfaceView的一个封装，它的功能比SurfaceView强大。

## 使用SurfaceView实现出简易的GLSurfaceView

- 我们使用SurfaceView来实现一个简易的GLSurfaceView,所以继承SurfaceView。
```c
public class EGLGLSurfaceView extends SurfaceView implements SurfaceHolder.Callback 
```
- 实现接口，需要一下几个方法
```java
 @Override
    public void surfaceCreated(SurfaceHolder holder) {
        
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
```
我们在创建方法执行的时候创建绘制线程。
```java
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        startGLThreads();
    }
```

基本就那么多，下来主要是线程中需要做什么？
- 创建一个EGL（会有一章专门来讲解）
```java
 EGL10 egl10 = (EGL10) EGLContext.getEGL();
 //获取表面   得到默认的表面
 EGLDisplay eglDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
//初始化 
egl10.eglInitialize(eglDisplay, new int[2]);
EGLConfig[] configs = new EGLConfig[1];
//匹配的EGLConfigs
egl10.eglChooseConfig(eglDisplay,
                    new int[]{EGL10.EGL_DEPTH_SIZE, 16, EGL10.EGL_NONE},
                    configs,
                    1,
                    new int[1]);
EGLConfig eglEGLConfig = configs[0];
//创建渲染窗口
EGLSurface eglSurface = egl10.eglCreateWindowSurface(eglDisplay, eglEGLConfig, EGLGLSurfaceView.this.getHolder(), null);
//创建渲染上下文
EGLContext eglContext = egl10.eglCreateContext(eglDisplay, eglEGLConfig, EGL10.EGL_NO_CONTEXT, null);
//使得一个上下文成为当前   绘制前需要到一个操作
egl10.eglMakeCurrent(eglDisplay, eglSurface, eglSurface, eglContext);
mGL10 = (GL10) eglContext.getGL()；
// 刷帧
while (isKeyFlag()) {
      gl.glClearColor(1, 0,0, 1.0f);
gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
//交换 缓存区
       egl10.eglSwapBuffers(eglDisplay, eglSurface);
}
```
在surfaceDestroyed调用
```java
       egl10.eglMakeCurrent(eglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE,
                    EGL10.EGL_NO_CONTEXT);
            egl10.eglDestroyContext(eglDisplay, eglContext);
            egl10.eglDestroySurface(eglDisplay, eglSurface);
            mGL10 = null;
```
- 创建open gl es相关的，在是一个循环来绘制图形。
```java
gl.glClearColor(1, 0,0, 1.0f);
gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
```

将整个屏幕变为红色。
上面就是基本SurfaceView封装成为GLSurfaceView最核心的操作.

## GLSurfaceView绘制
只需要书写opengl代码就可以了，其它操作已经被封装掉了。
做出与上面相同的操作只需要执行先的一些代码
```java

public class xxx extends GLSurfaceView implements GLSurfaceView.Renderer {
    public xxx(Context context) {
        super(context);
    }

    public xxx(Context context, AttributeSet attrs) {
        super(context, attrs);
        setRenderer(this);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClearColor(1, 0,0, 1.0f);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }
}
```

## GLSurfaceView的刷新
它是通过两层while循环，内层循环进行等待，外层循环进行循环绘制。系统会16ms(60帧)发送一次消息，执行一次绘制，在GLSurfaceView执行绘制之前会将所有的任务都处理完，才执行一次绘制操作。
有特殊的：刷新帧率如果不是60帧的，就会在更短的间隔内执行一次。
