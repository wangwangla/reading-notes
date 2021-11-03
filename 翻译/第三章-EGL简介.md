之前提到EGL是渲染平面和opengles之间第一层，它负责联系渲染平面和管理open gl es上下文。
EGL提供如下功能：
- 与本地窗口系统进行通信
- 查询可用的绘制曲面并且得到它的配置信息
- 创建绘制表面
- 在opengles和其他渲染 api之间进行同步渲染
- 管理渲染资源

如何我们需要绘制就是要opengles，如果我们要显示处理就需要调用硬件 ，那就是有egl.

## 与本地窗口通信

EGL作为一个中间层，就需要管理窗口硬件以及opengl上下文，首先与的与硬件通信。每个窗口的语义不同，并且是跨平台的，在EGL封装了一个类EGLDisplay。它使用
```c
display = eglGetDisplay(EGL_DEFAULT_DISPLAY);
```
与显示器连接，返回一个有效的句柄，为了可以在跨平台上使用，所以使用了一个EGL_DEFAULT_DIAPLAY的令牌。

##  错误检查

返回为false，那么就是查询失败了，可以使用eglGetError查询错误，不过这个错误是查询错误，不会自己返回，有利有弊吧。

## 初始化EGL

一旦打开连接，就需要进行初始化，可以使用
```c
eglInitialize(EGLDisplay display,EGLint *maja,EGLint *minor)
```
初始化一个EGL的内部数据结构，并返回主次版本

##  确定可用的表面配置
初始化结束之后需要确定那个渲染表面是可以使用的
- 查询所有的，自己选择
- 指定要求，让EGL帮我们选择一个

一般情况下使用第二种，最终的结果就是返回一个EGLConfig，它包含特定界面的特征信息。
查询方式
```c
eglGetConfig(display,config,maxReturnConfigs,numConfigs)
```

那么这个什么时候调用呢？？

- 如果配置为null的时候，numConfig设置为EGLCOnfigs的数量
- 或者，也许更有用的是，您可以分配一个未初始化的EGLConfig值数组，并将这些值作为Configs参数传递给eglGetConfigs。将maxReturnConfigs设置为您分配的数组的大小，这也将指定将返回的最大配置数。当调用完成时，numConfigs将被更新为配置中已修改的条目数。然后，您可以开始处理返回列表，查询配置的特征，以确定哪一个最符合我们的需求。

## 查询配置属性
我们现在描述EGL与一个EGLConfig关联的值，以及如何检索这些值。要查询与EGLConfig关联的特定属性，请使用eglGetConfigAttrb(display,config,attribute,value)
它将返回关联的EGLConfig的特定属性的值。这使您可以完全控制最终创建渲染表面时选择的配置。然而，看看表3.1，考虑到选项的数量，你可能会有些害怕。EGL提供了另一个例程，eglChooseConfig，它允许您指定对您的应用程序来说什么是重要的，并将返回与您的请求最匹配的配置。

## 让EGL选择配置
如果是自己选择，可以使用
eglChooseChofig(display,attributeList,config,maxReturnConfigs,numConfigs)
您需要提供一个属性列表，以及对您的应用程序的正确操作很重要的所有属性的相关首选值。例如，如果您需要一个支持五位红色和蓝色、六位绿色(常见的“RGB  565”格式)、深度缓冲区和支持OpenGL ES 2.0的渲染表面的EGLConfig，您可以声明示例3-2中所示的数组。

![image-20210329225947821.png](https://upload-images.jianshu.io/upload_images/17108963-4ae3dc4e9a890e21.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![image-20210329230009224.png](https://upload-images.jianshu.io/upload_images/17108963-4c7320fde12d45d7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 指定EGL属性

```java
EGLint attribList[] = 
{
   EGL_RENDERABLE_TYPE, EGL_OPENGL_ES2_BIT,
   EGL_RED_SIZE, 5,
   EGL_GREEN_SIZE, 6,
   EGL_BLUE_SIZE, 5,
   EGL_DEPTH_SIZE, 1,
   EGL_NONE
};
```
对于没有指定的值就会使用默认值，如果通过eglChooseConfig成功返回，将 返回一组符合条件的EGLConfigs，

## 创建屏幕渲染区：EGL窗口

我们有了渲染的EGLConfig就可以创建窗口了，一般使用：
```java
EGLSurface eglCreateWindowSurface(display,config,window,attribute)
```
使用它连接带到本地显示器，以及我们在上一步中获得的EGLConfig。

## 创建屏幕外的渲染区域

使用opengles渲染到外表面窗口上，还需要渲染到不可见的外表面


**这个先不管了，等说到opengles的framebuffer在回来看这个**

## 创建渲染上下文

它是opengles的内部数据结构，包含了所有的状态，比如：片段片元着色器以及顶点数据数组等。使用
```java
EGLContext eglCreateContext(display,config,eglcontext,attribute)
```
当创建成功到时候，返回一个上下文句柄。

## 使用环境上下文成为当前
一个程序 可以创建多个环境上下文，我们需要将上下文与我们的渲染表面相关联，使用：
```java
EGLBoolean eglmakeCurrent(display,draw,read,context)
```
## 完成的案例
```c
EGLBoolean initializeWindow(EGLNativeWindow nativeWindow)
{
   const EGLint  configAttribs[] = 
   {
      EGL_RENDER_TYPE, EGL_WINDOW_BIT,
      EGL_RED_SIZE, 8,
      EGL_GREEN_SIZE, 8,
      EGL_BLUE_SIZE, 8,
       EGL_DEPTH_SIZE, 24,
      EGL_NONE
   };
   
   const EGLint  contextAttribs[] = 
   {
      EGL_CONTEXT_CLIENT_VERSION, 2,
      EGL_NONE
   };
   EGLDisplay dpy;
   dpy = eglGetNativeDispay(EGL_DEFAULT_DISPLAY);
   if(dpy == EGL_NO_DISPLAY) 
   {
      return EGL_FALSE;
   }
   EGLint major, minor;
   if(!eglInitialize(dpy, &major, &minor)) 
   {
      return EGL_FALSE;
   }
   EGLConfig  config;
   EGLint  numConfigs;
   if(!eglChooseConfig(dpy, configAttribs, &config, 1, 
      &numConfigs)) {
         return EGL_FALSE;
   }
   EGLSurface window;
   window = eglCreateWindowSurface(dpy, config, nativeWindow, NULL);
   if(window == EGL_NO_SURFACE) 
   {
      return EGL_FALSE;
   }
   EGLContext context;
   context = eglCreateContext(dpy, config, EGL_NO_CONTEXT,
                              contextAttribs);
   if(context == EGL_NO_CONTEXT) 
   {
      return EGL_FALSE;
   }
    if(!eglMakeCurrent(dpy, window, window, context)) 
   {
      return EGL_FALSE;
   }
   return EGL_TRUE;
}
```

## 同步渲染
如果需要将多个图形应用编程接口的渲染协调到一个窗口中的情况。例如，您可能会发现使用OpenVG或本机窗口系统的字体渲染更容易比OpenGL  ES 2.0更适合在窗口中绘制字符的功能。在这种情况下，您需要让您的应用程序允许各种库呈现到共享窗口中。EGL有几个功能可以帮助您完成同步任务。
- 如果您的应用程序只使用OpenGL  ES 2.0进行渲染，那么您可以通过简单地调用glFinish来保证所有的渲染都已经发生
- 如果您使用多个Khronos  API进行渲染(如OpenVG)，并且在切换到窗口系统本机渲染API之前，您可能不知道使用了哪个API，您可以调用以下内容。EGLWaitClient（）

它的操作类似于glFinish的操作，但是不管当前运行的是哪个Khronos  API，它都可以工作。
同样，如果您需要保证完成本机窗口系统呈现，请调用eglWaitNative。
