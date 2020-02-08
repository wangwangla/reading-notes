# Gradle构建脚本基础

## 什么是setting文件

在Gradle中，定义一个设置文件。用于初始化以及工程树的配置。这个文件简单点就是设置本项目一共有多少个子项目。
```java
include "core", "desktop", "android",'gdx'
```

## 什么是build文件

它是默认的入口文件，每个项目都只有一个Build文件，获取到所有的儿子，配置儿子的仓库，这样的jar可以从仓库下载.可配置仓库。

## 任务基础

```java
依赖
task ex(dependsOn : ProName){

}
```

## 自定义属性

```java
ext.age = 18
ext{
    phone = 1323
    address= 22
}
```