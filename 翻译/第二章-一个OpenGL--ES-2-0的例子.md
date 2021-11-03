为了介绍OpenGL  ES 2.0的基本概念，我们从一个简单的例子开始。在本章中，我们展示了创建一个绘制单个三角形的OpenGL ES  2.0程序需要什么。我们将要编写的程序只是一个绘制几何图形的OpenGL ES 2.0应用程序的最基本的例子。本章涵盖了许多概念:
- 使用EGL创建屏幕渲染表面。（这可以在GLSurfaceView中看到相关操作）
- 加载顶点和片段着色器 （open gl es部分）
- 创建程序对象，附加顶点和片段着色器，以及链接程序对象
- 设置视口
- 清除颜色缓冲区
- 渲染一个简单的图元
- 使颜色缓冲区的内容在EGL窗口表面可见。（EGL部分）

*总结：使用一个案例来说明opengles显示一个图形需要那些东西，以及罗列出创建的具体步骤。*

事实证明，在我们开始用OpenGL  ES  2.0绘制三角形之前，需要相当多的步骤。本章将介绍这些步骤的基础知识。在本书的后面，我们将详细介绍这些步骤，并进一步记录应用编程接口。我们在这里的目的是让你运行你的第一个简单的例子，这样你就可以知道用OpenGL  ES 2.0创建一个应用程序需要什么。

*补充：*使用android的GLSurfaceView就不需要出现这里的EGL部分，它已经帮助我们实现了，在书本中的案例里面会有EGL的创建过程，然后创建出opengles上下文，进行绘制操作，最后将缓存区中的像素刷新出去。

简单说一下EGL,它是opengl和屏幕之间的一个中间层。open gl 是跨平台的，所以需要一个中间层（我个人是这么认为的），下一章会有一章来说明和EGL的操作步骤。

### 你好三角形

让我们看看我们的Hello  Triangle示例程序的完整源代码，它在示例2-1中列出。对于那些熟悉固定函数桌面OpenGL的读者来说，你可能会认为这只是为了画一个简单的三角形而编写的大量代码。对于那些不熟悉桌面OpenGL的人来说，你可能也会认为这是一大堆代码，只是为了画一个三角形！请记住，OpenGL  ES  2.0是完全基于着色器的，这意味着如果没有加载和绑定适当的着色器，您就不能绘制任何几何图形。这意味着渲染所需的设置代码比使用固定函数处理的桌面多。
```java
Example 2-1 Hello Triangle Example 
#include "esUtil.h"
typedef struct
{
   // Handle to a program object
   GLuint programObject;
} UserData;
///
// Create a shader object, load the shader source, and
// compile the shader.
//
GLuint LoadShader(const char *shaderSrc, GLenum type)
{
   GLuint shader;
   GLint compiled;
   
   // Create the shader object
   shader = glCreateShader(type);
   if(shader == 0)
      return 0;
   // Load the shader source
   glShaderSource(shader, 1, &shaderSrc, NULL);
   
   // Compile the shader
   glCompileShader(shader);
   // Check the compile status
   glGetShaderiv(shader, GL_COMPILE_STATUS, &compiled);
   if(!compiled) 
   {
      GLint infoLen = 0;
      glGetShaderiv(shader, GL_INFO_LOG_LENGTH, &infoLen);
      
      if(infoLen > 1)
      {
         char* infoLog = malloc(sizeof(char) * infoLen);
         glGetShaderInfoLog(shader, infoLen, NULL, infoLog);
         esLogMessage("Error compiling shader:\n%s\n", infoLog);
         free(infoLog);
      }
      glDeleteShader(shader);
      return 0;
   }
   return shader;
}
///
// Initialize the shader and program object
//
int Init(ESContext *esContext)
{
   UserData *userData = esContext->userData;
   GLbyte vShaderStr[] =  
      "attribute vec4 vPosition;   \n"
      "void main()                 \n"
      "{                           \n"
      "   gl_Position = vPosition; \n"
      "}                           \n";
   
   GLbyte fShaderStr[] =  
      "precision mediump float;                   \n"
      "void main()                                \n"
      "{                                          \n"
      "  gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0); \n"
      "}                                          \n";
   GLuint vertexShader;
   GLuint fragmentShader;
   GLuint programObject;
   GLint linked;
   // Load the vertex/fragment shaders
   vertexShader = LoadShader(GL_VERTEX_SHADER, vShaderStr);
   fragmentShader = LoadShader(GL_FRAGMENT_SHADER, fShaderStr);
   // Create the program object
   programObject = glCreateProgram();
   if(programObject == 0)
      return 0;
   glAttachShader(programObject, vertexShader);
   glAttachShader(programObject, fragmentShader);
   // Bind vPosition to attribute 0   
   glBindAttribLocation(programObject, 0, "vPosition");
   // Link the program
   glLinkProgram(programObject);
   // Check the link status
   glGetProgramiv(programObject, GL_LINK_STATUS, &linked);
   if(!linked) 
   {
      GLint infoLen = 0;
      glGetProgramiv(programObject, GL_INFO_LOG_LENGTH, &infoLen);
      
      if(infoLen > 1)
      {
         char* infoLog = malloc(sizeof(char) * infoLen);
         glGetProgramInfoLog(programObject, infoLen, NULL, infoLog);
         esLogMessage("Error linking program:\n%s\n", infoLog);
         
         free(infoLog);
      }
      glDeleteProgram(programObject);
      return FALSE;
   }
   // Store the program object
   userData->programObject = programObject;
   glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
   return TRUE;
}
///
// Draw a triangle using the shader pair created in Init()
//
void Draw(ESContext *esContext)
{
   UserData *userData = esContext->userData;
   GLfloat vVertices[] = {0.0f,  0.5f, 0.0f, 
                          -0.5f, -0.5f, 0.0f,
                          0.5f, -0.5f,  0.0f};
      
   // Set the viewport
   glViewport(0, 0, esContext->width, esContext->height);
   
   // Clear the color buffer
   glClear(GL_COLOR_BUFFER_BIT);
   // Use the program object
   glUseProgram(userData->programObject);
   // Load the vertex data
   glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 0, vVertices);
   glEnableVertexAttribArray(0);
   glDrawArrays(GL_TRIANGLES, 0, 3);
   eglSwapBuffers(esContext->eglDisplay, esContext->eglSurface);
}
int main(int argc, char *argv[])
{
   ESContext esContext;
   UserData  userData;
   esInitialize(&esContext);
   esContext.userData = &userData;
   esCreateWindow(&esContext, "Hello Triangle", 320, 240,
                  ES_WINDOW_RGB);
   
   if(!Init(&esContext))
      return 0;
   esRegisterDrawFunc(&esContext, Draw);
   
   esMainLoop(&esContext);
}
Building and Running the Examples 25
```

这个代码绘制一个三角形。
![image-20210316222537508.png](https://upload-images.jianshu.io/upload_images/17108963-512fe2ddeb568e88.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 使用Opengles框架

主函数做的第一件事是声明一个ESContext并初始化它，
```c
ESContext esContext;
UserData  userData;
esInitialize(&esContext);
esContext.userData = &userData
```
ESContext被传递到所有的ES框架实用程序函数中，并包含了ES框架所需的关于程序的所有必要信息。传递上下文的原因是示例程序和ES代码框架不需要使用任何全局数据。

主函数的其余部分负责创建窗口、初始化draw回调函数以及进入主循环:
```java
esCreateWindow(&esContext, "Hello Triangle", 320, 240,
               ES_WINDOW_RGB);//创建窗口的大小
if(!Init(&esContext))
   return 0;
esRegisterDrawFunc(&esContext, Draw);
   
esMainLoop(&esContext);
```
## openGLES部分

### 创建顶点着色器和片段着色器
必须创建出正确的片元和片段着色器才可以绘制出图形。第一个任务就是创建出并加载。
```c
GLbyte vShaderStr[] =  
   "attribute vec4 vPosition;   \n"
   "void main()                 \n"
   "{                           \n"
   "   gl_Position = vPosition; \n"
   "};                          \n";
```
很简单的几行，输入一个属性，这个就是后面将要传递进来的顶点坐标，将顶点坐标给内置变量gl_Position。

*复习一下：*
* 顶点着色器的输入：属性、uniform、sample等，这个使用到了属性。

### 片段着色器
```c
GLbyte fShaderStr[] =  
   "precision mediump float;                   \n"
   "void main()                                \n"
   "{                                          \n"
   "  gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0); \n"
   "}     
```
这个也比较简单，第一句，设置精度是float（第一章说过这个是在opengles上才有的，opengl并没有）。
gl_FragColor是一个内置变量，这个值就是显示到屏幕的值（这么说也不准确，需要经过一系列的测试之后才显示，可能会带有其他操作，比如抛弃、混合等）

## 编译和加载着色器
下一步就是加载编译着色器，对其进行错误检查无误之后就可以附着到程序上了。
让我们看看LoadShader函数是如何工作的。着色器对象首先使用glCreateShader创建，它创建指定类型的新着色器对象。
```c
GLuint LoadShader(GLenum type, const char *shaderSrc)
{
   GLuint shader;
   GLint compiled;
   
   // Create the shader object
   shader = glCreateShader(type);//传入type，片段和片元
   if(shader == 0)
   return 0;
}
```
着色器源代码本身使用glShaderSource加载到着色器对象中。然后使用glCompileShader函数编译着色器。
```c
// Load the shader source
   glShaderSource(shader, 1, &shaderSrc, NULL);
   
   // Compile the shader
   glCompileShader(shader);
```
检查错误
```c
// Check the compile status
   glGetShaderiv(shader, GL_COMPILE_STATUS, &compiled);
   if(!compiled) 
   {
      GLint infoLen = 0;
      glGetShaderiv(shader, GL_INFO_LOG_LENGTH, &infoLen);
      
      if(infoLen > 1)
            {
         char* infoLog = malloc(sizeof(char) * infoLen);
         glGetShaderInfoLog(shader, infoLen, NULL, infoLog);
         esLogMessage("Error compiling shader:\n%s\n", infoLog);
         
         free(infoLog);
      }
      glDeleteShader(shader);
      return 0;
   }
   return shader;
}
```

## 创建程序对象并链接着色器

应用程序为顶点和片段着色器创建了着色器对象，它就需要创建一个程序对象。从概念上讲，程序对象可以被认为是最终的链接程序。一旦每个着色器被编译成一个着色器对象，它们必须在绘制前附加到一个程序对象并链接在一起。
```c
// Create the program object
programObject = glCreateProgram();
if(programObject == 0)
   return 0;
glAttachShader(programObject, vertexShader);
glAttachShader(programObject, fragmentShader);
```
连接成功之后就可以获取属性位置，给属性设置值了。
这里也说另一个方法，设置顶点着色器的位置
```c
glBindAttribLocation(programObject, 0, "vPosition");
```

连接程序，并检查错误
```c
// Link the program
glLinkProgram(programObject);
// Check the link status
glGetProgramiv(programObject, GL_LINK_STATUS, &linked);
if(!linked) 
{
   GLint infoLen = 0;
   glGetProgramiv(programObject, GL_INFO_LOG_LENGTH, &infoLen);
      
   if(infoLen > 1)
   {
      char* infoLog = malloc(sizeof(char) * infoLen);
      glGetProgramInfoLog(programObject, infoLen, NULL, infoLog);
      esLogMessage("Error linking program:\n%s\n", infoLog);
         
      free(infoLog);
   }
   glDeleteProgram(programObject);
   return FALSE;
}
// Store the program object
userData->programObject = programObject;
```
一切准备就绪，就可以使用程序了  。
```c
// Use the program object
glUseProgram(userData->programObject);
```
## 设置视口并清除颜色缓冲区

现在我们已经用EGL创建了一个渲染表面，并初始化和加载了着色器，我们准备好实际绘制一些东西了。绘图回调函数绘制框架。我们在Draw中执行的第一个命令是glViewport，它通知OpenGL  ES将要绘制的2D渲染表面的原点、宽度和高度。在OpenGL ES中，视口定义了2D矩形，所有OpenGL ES渲染操作最终都将在该矩形中显示。
```c
glViewport(0, 0, esContext->width, esContext->height);
```
这个在起始位置0，0，就是这屏幕在左上角，后面两个参数是显示在宽高。这个书本上在案例是显示出创建处理屏幕的尺寸。
设置好屏幕之后，下一步就是清除屏幕。屏幕清除的有颜色缓存区， 深度缓存区等。使用掩码的方式写入。
```c
// Clear the color buffer
glClear(GL_COLOR_BUFFER_BIT);
```

## 加载几何图形的顶点
```c
GLfloat vVertices[] = {0.0f,  0.5f, 0.0f, 
                       -0.5f, -0.5f, 0.0f,
                       0.5f, -0.5f, 0.0f};
…
// Load the vertex data
glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 0, vVertices);
glEnableVertexAttribArray(0);
glDrawArrays(GL_TRIANGLES, 0, 3);
```
创建出顶点，然后获取顶点的位置，并且设置使能，最后进行一次绘制。顶点就是告诉图元，我们绘制的是一个什么图形，这个图形是什么样的，使用哪些顶点。

*回顾一下：*
顶点之后的操作，图元装配，裁剪，剔除。裁剪主要裁剪的是否在视锥体内部，剔除是根据设置的顶点的正方向还是反方向绘制。然后进行栅格化，栅格化就是将图元变为一个二维数组的形式，并且也会计算差值。

## 显示后台缓冲区
屏幕上可见的帧缓冲区由像素数据的二维数组表示。我们可以考虑在屏幕上显示图像的一种可能的方法是在我们绘制时简单地更新可见帧缓冲区中的像素数据。然而，直接更新可显示缓冲区上的像素有一个严重的问题。也就是说，在典型的显示系统中，物理屏幕从帧缓冲存储器以固定的速率更新。如果一种是直接绘制到框架缓冲区中，用户可以看到工件作为显示的框架缓冲区的部分更新，为了解决这个问题，使用了一种称为双缓冲的系统。在这个方案中，有两个缓冲区:前缓冲区和后缓冲区。所有渲染都发生在后台缓冲区，该缓冲区位于屏幕不可见的内存区域。**所有渲染完成后，该缓冲区将与前缓冲区(或可见缓冲区)进行“交换”。然后，前缓冲区成为下一帧的后缓冲区。**
使用这种技术，我们不显示一个可见的表面，**直到一个帧的所有渲染完成**。在OpenGL  ES应用程序中，这一切都是通过EGL控制的。这是通过一个名为eglSwapBuffers的EGL函数实现的:
```c
eglSwapBuffers(esContext->eglDisplay, esContext->eglSurface);
```
交换缓冲区之后，我们终于在屏幕上看到了我们的三角形！

*总结：*这章相对比较简单，通过一个完整的案例，来绘制一个三角形，这个绘制包含了所有的绘制所必须得步骤。

- 准备顶点
- 准备片元和片段着色器
- 加载编译
- 创建程序
- 附着程序
- 使用程序
- 获取输入参数的位置
- 设置值
- 绘制

上面都是绘制open gl 相关的，还需要绘制屏幕的表面，使用EGL得到屏幕信息，创建绘制表面。  最后将两个缓存区交换。

## Java的实现
[案例代码的框架](https://www.jianshu.com/p/91679e3c8c3c),使用android绘制一个三角形。
- BaseGameScreen
```java
public abstract class BaseGameScreen {
    protected float color[];
    protected float triangleCoords[];
    protected String fragmentShaderCode;
    protected String vertexShaderCode;
    protected FloatBuffer vertexBuffer;
    protected FloatBuffer colorBuffer;
    protected int mProgram ;
    private Resources mRes;

    public BaseGameScreen(){}

    public BaseGameScreen(Resources resources){
        this.mRes = resources;
    }

    public int loadShader(int type, String shaderCode){
        //根据type创建顶点着色器或者片元着色器
        int shader = GLES20.glCreateShader(type);
        //将资源加入到着色器中，并编译
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        int []arr = new int[1];
        GLES20.glGetShaderiv(shader,GLES20.GL_COMPILE_STATUS,arr,0);
        int i = arr[0];
        if (i == 0){
            //失败了
            int [] length = new int[1];
            GLES20.glGetShaderiv(shader,GLES20.GL_INFO_LOG_LENGTH,length,0);
            if (length[0]>0){
                String s = GLES20.glGetShaderInfoLog(shader);
                System.out.println(s);
            }
        }

        return shader;
    }

    public abstract void render();

    public void create(){
        ByteBuffer bb = ByteBuffer.allocateDirect(
                triangleCoords.length * 4);
        bb.order(ByteOrder.nativeOrder());
        vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.put(triangleCoords);
        vertexBuffer.position(0);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(color.length*4);
        byteBuffer.order(ByteOrder.nativeOrder());
        colorBuffer = byteBuffer.asFloatBuffer();
        colorBuffer.put(color);
        colorBuffer.position(0);

        int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER,vertexShaderCode);
        int fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER,fragmentShaderCode);
        mProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(mProgram,vertexShader);
        GLES20.glAttachShader(mProgram,fragmentShader);
        GLES20.glLinkProgram(mProgram);
        int lin[] = new int[1];
        GLES20.glGetProgramiv(mProgram,GLES20.GL_LINK_STATUS,lin,0);
        if (lin[0] == 0){
            String s = GLES20.glGetProgramInfoLog(mProgram);
            System.out.println(s);
        }
        GLES20.glDeleteShader(1);
    }

    public abstract void surfaceChange(int width,int height);

    public abstract void dispose();

    public void resume() {

    }

    public void pause() {
    }

//    protected final void createProgramByAssetsFile(String vertex,String fragment){
////        createProgram(uRes(mRes,vertex),uRes(mRes,fragment));
////        String s = uRes(mRes, vertex);
//    }

    public String uRes(String path){
        if (mRes == null) System.out.println("八嘎!");
        StringBuilder result=new StringBuilder();
        try{
            InputStream is=mRes.getAssets().open(path);
            int ch;
            byte[] buffer=new byte[1024];
            while (-1!=(ch=is.read(buffer))){
                result.append(new String(buffer,0,ch));
            }
        }catch (Exception e){
            return null;
        }
        return result.toString().replaceAll("\\r\\n","\n");
    }

//    protected final void createProgram(String vertex,String fragment){
//        mProgram= uCreateGlProgram(vertex,fragment);
//        mHPosition= GLES20.glGetAttribLocation(mProgram, "vPosition");
//        mHCoord=GLES20.glGetAttribLocation(mProgram,"vCoord");
//        mHMatrix=GLES20.glGetUniformLocation(mProgram,"vMatrix");
//        mHTexture=GLES20.glGetUniformLocation(mProgram,"vTexture");
//    }
}

```
- 三角形
```java
public class Triangle extends BaseGameScreen {
    private final String vertexShaderCode =
            "attribute vec4 vPosition;" +
                    "void main() {" +
                    "  gl_Position = vPosition;" +
                    "}";

    private final String fragmentShaderCode =
            "precision mediump float;" +
                    "uniform vec4 vColor;" +
                    "void main() {" +
                    "  gl_FragColor = vColor;" +
                    "}";

    static final int COORDS_PER_VERTEX = 3;
    private FloatBuffer vertexBuffer;
    static float triangleCoords[] = {
            0.5f,  0.5f, 0.0f, // top
            -0.5f, -0.5f, 0.0f, // bottom left
            0.5f, -0.5f, 0.0f  // bottom right
    };
    private int mProgram ;
    //顶点个数
    private final int vertexCount = triangleCoords.length / COORDS_PER_VERTEX;
    //顶点之间的偏移量
    private final int vertexStride = COORDS_PER_VERTEX * 4; // 每个顶点四个字节
    //设置颜色，依次为红绿蓝和透明通道
    float color[] = { 1.0f, 1.0f, 1.0f, 1.0f };
    private int mPositionHandle;
    private int mColorHandle;
    float d = 0.01F;
    public Triangle(){

    }

    public void create(){
        ByteBuffer bb = ByteBuffer.allocateDirect(
                triangleCoords.length * 4);
        bb.order(ByteOrder.nativeOrder());
        vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.put(triangleCoords);
        vertexBuffer.position(0);

        int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER,vertexShaderCode);
        int fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER,fragmentShaderCode);
        mProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(mProgram,vertexShader);
        GLES20.glAttachShader(mProgram,fragmentShader);
        GLES20.glLinkProgram(mProgram);
        //程序加入到环境里面
        GLES20.glUseProgram(mProgram);
//        检查是否有效
        GLES20.glValidateProgram(mProgram);
        //得到活跃的unifor
        int arr[] = new int[1];
        int arr1[] = new int[1];
        int arr2[] = new int[1];
        int arr3[] = new int[1];
        byte arr4[] = new byte[10];
        GLES20.glGetProgramiv(mProgram,GLES20.GL_ACTIVE_UNIFORMS,arr,0);
    
        mPositionHandle = GLES20.glGetAttribLocation(mProgram, "vPosition");
        mColorHandle = GLES20.glGetUniformLocation(mProgram, "vColor");
    }

    @Override
    public void surfaceChange(int width, int height) {
        GLES20.glViewport(0,0,width,height);
    }

    @Override
    public void dispose() {

    }


    @Override
    public void render() {
        //获取位置句柄   属性句柄

        GLES20.glEnableVertexAttribArray(mPositionHandle);
        //准备三角形的坐标数据
        GLES20.glVertexAttribPointer(
                mPositionHandle,
                COORDS_PER_VERTEX,
                GLES20.GL_FLOAT,
                false,
                vertexStride,
                vertexBuffer);
        //获取片元着色器的vColor成员的句柄
        //设置绘制三角形的颜色
        GLES20.glUniform4fv(mColorHandle, 1, color, 0);
        //绘制三角形
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexCount);
        //禁止顶点数组的句柄
        GLES20.glDisableVertexAttribArray(mPositionHandle);
    }
}
```



