# gradle

gradle是一个构建系统工具，可以很方便的进行系统的构建，它通过插件的方式进行构建，如果不能达到要求，也可以自己构建插件。
执行的时候会默认的加载build.gradle，

```java
```

## wrapper

它是对于gradle的一层包装，便于团队进行使用统一的版本构建，在开发过程中使用的都是这样的格式，而不是下载gradle的zip，wrapper在window下有一个批处理脚本，wrapper启动gradle进行一个检查，如果没有那么就从网址进行下载。

gradle提供了内置的wrapper帮助我们生成wrapper所需要的目录，在根目录输入gradle wrapper即可生成