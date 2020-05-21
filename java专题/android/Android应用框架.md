# Android应用框架

Activity组成一个应用程序的页面，在一个进程或多个进程中。

Activity分为两种：
 
- 根Activity:以快捷图标的方式显示在应用程序的启动中，启动代表一个应用程序的启动 

- 子Activity：通过主Activity挥着其他子Activity启动，可能是一个进程可能是多个进程，取决于配置或者是启动参数。

显示和隐式：显示和隐式相比，隐式会更加减少依赖。

## 组件实例

设置一个进程中还是多个进程中，可以在配置文件中设置。

```xml
android:process = 
```

默认启动是根Activity

## 启动过程

根Activity代表一个Android应用程序，在一个新的进程中启动起来。

在 Android系统中，所以的组件都存在一个堆栈中，后面的位于前面启动的顶部，用户操作，需要一系列的组件交互，组件在系统的activity堆栈中用一个任务来描述。

Launcher启动根Activity，所以根Activity在Launcher的上部。Launcher通过ActvityManagerService来启动。三个进程通过binder进行通信。

发现不存在当前的应用程序，就会创建一个应用程序，在启动组件。

launcher---> ActivityMangerService ----> launcher   ----> ActivityMService ----> create process ---> AMS ---> 启动根activity  


点击icon  --->  startActivitySafely启动根Activity(启动信息在intent)


**补充：**

- 系统启动时，会启动package管理packageManagerService，来安装应用程序。

pms会对androidManifest.xml进行解析。启动之后就会启动一个launcher组件，然后查询根activity的组件,为每一个activit创建一个图标，并将信息链接起来。