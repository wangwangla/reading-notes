# gradle

gradle是一个构建系统系统工具，他的DSL基于Groovy实现， 可以很方便的进行系统的构建，它通过插件的方式进行构建，如果不能达到要求，也可以自己构建插件。
执行的时候会默认的加载build.gradle，

```java
```

## wrapper

它是对于gradle的一层包装，便于团队进行使用统一的版本构建，在开发过程中使用的都是这样的格式，而不是下载gradle的zip，wrapper在window下有一个批处理脚本，wrapper启动gradle进行一个检查，如果没有那么就从网址进行下载。

gradle提供了内置的wrapper帮助我们生成wrapper所需要的目录，在根目录输入gradle wrapper即可生成

- distributionBase:下载的Gradle压缩包解压后存储的目录


**补充：**all和bin的区别是，all包含了文档/示例等

```gradle
#Wed Jul 17 12:35:56 CST 2019
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
distributionUrl=https\://services.gradle.org/distributions/gradle-4.6-bin.zip
=
```

这样可以构建任务，但是我们也可自己定义任务来达到指定版本的目的

```gradle
task wrapper(type:Wrapper){
    gradleVersion = '2.4'
}
```

## 日志

他们的日志也会分级别，我们只需要根据情况显示不同的级别即可。

- 日志级别
    - ERROR     
    - QUIET     重要
    - WARNING   警告
    - LIFECYCLE 进度
    - INFO      信息
    - DEBUG     调试

- 如何显示
    - gradle -e tasks
    - gradle -q tasks

### 输出堆栈信息

- 输出关键的堆栈信息 -s 
- 输出所有的堆栈信息 -S

**自己使用日志信息**

方式一：

println "日志信息"

方式二：

logger.quiet('xxx');


## Gradle命令行

**帮助：**

```gradle
./gradlew -?
./gradlew -h
```

**查看所有的任务：**

```gradle
:Tasks
```

**Gradle help任务**
