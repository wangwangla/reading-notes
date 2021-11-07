# gradle构建脚本基础

目标：

- 了解gradle
- 什么是setting,有什么用
- 什么是build,由什么用、

## setting文件

用来指定由多少个模块的，如果不指定路径，那么即使 同级目录

```java
rootProjecct.name = "项目名称"  //不同于文件夹名称
include ':moudle1',':moudle2'
include ':moudle3'
projecct(':moudle3').projectDir = new File(rootDir,'chapter01/moudle03')
```

## build文件

每个项目都由一个build文件，它是project的入口，可以对其进行配置，比如插件、依赖、仓库、构建参数等。

> 什么是闭包？

## 

## projects以及tasks

gradle中可以由多个project，也可以自己创建project用于生成jar，或者war，或者直接的上传。项目分为一个一个的模块，然后将一个个模块 组成构建位一个Gradle构建；

一个project中可以由多个任务，他是一个操作，一个原子操作，比如打jar，复制文件等。



## 任务依赖

```
task hello{
    doLast{
        println 'method01'
    }
}

task main(dependsOn:hello){
    doLast{
        println 'main'
    }
}

task d2 {
    dependsOn hello

}
```

脚本的执行是顺序执行的，每一个任务都是project的一个属性。

### 自定义属性

project和Task都允许用户添加额外的自定义属性，要添加额外属性，需要使用ext属性可以完成。

```java
//自定义属性

ext.age = 18;

task readPro{
    //必须得双引号
    println "age is ${age}"
}
```

案例2：

使用java插件配置sourceSets

```java
//自定义属性
apply plugin:"java"
ext.age = 18;

task readPro{
    //必须得双引号
    println "age is ${age}"
}

sourceSets.all{
    ext.re = null;
}

sourceSets{
    main{
        re = 'main'
    }
}

task show{
    sourceSets.each{
        println "${it.name},,,${it.re}"
    }
}
```

## 脚本及就是代码，代码及就是脚本

虽然写的是脚本，但是都是代码，脚本可以定义class 内部类  导入包  定义方法  常量   接口等

> 不过我体会不到它的含义