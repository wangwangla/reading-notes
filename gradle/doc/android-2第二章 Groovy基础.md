# Gradle构建脚本基础

## 补充Groovy

Groovy是基于java虚拟机的一种动态语言，它和Java十分相似，兼容java。我们后面的build就是一个Groovy脚本，兼容java，所有可以直接的使用java代码在里面。

### 字符串

定义字符串

```java
def str1 = 'xxx'
//获取类型
str1.getClass().name

//String类型，无论是单引号还是双引号都可以
```

### 集合

- list 

```java
def numList = [1,2,3,4];
println numList.getClass().name

//访问元素
numList[1]
numList[-1]    访问倒数第1
numList[-2]    访问倒数第2
numList[1..3]  访问2到4


//更加方便的
numList.each{
    println it
}
```

- Map

Map和list很像

```java
def map1 = ['width':1024,'height':32]
map1.getClass().name

//访问 
map1['width']
map1.height

map1.eachP{
    p "key : ${it.key},Value : ${it.value}"
}
```

### 方法

groovy和java方法的不同

1.括号是可以省略的 

```java
//java
mathod(par1,par2)
//groovy
mathod par1,par2


//完整案例
task method {
    mathod(1,2)
    mathod 1,2
}

def mathod(int a,int b){
    println a + b
}

//return 是可以不写的
def method(){
    a
}
```

- 代码是可以做为参数传递的

```java
代码块  一段被花括号包围的代码（闭包），这里允许作为参数传递的

numList.each({
        println it
    }
)

numList.each{
        println it
    }

```

## javaBean

现在的组件/插件都是基于bean的
- java我们必须书写set/get

```java
task testbean{
    Person p = new Person()
    println "名字：${p.name}"
}

但是如果加上一个get方法，如果没有设置set也是不可以
```

## 闭包

闭包是一个重要特性，闭包就是一个代码块。
想闭包传递参数

## 什么是setting文件

在Gradle中，定义一个设置文件。用于初始化以及工程树的配置。这个文件简单点就是设置本项目一共有多少个子项目。
```java
include "core", "desktop", "android",'gdx'
```

## 什么是build文件

它是默认的入口文件，每个项目都只有一个Build文件，获取到所有的儿子，配置儿子的仓库，这样的jar可以从仓库下载.可配置仓库。

我们给子项目统一配置

```java
subprojects{
    都需要使用插件
    apply plugin : 'java'
    repositories{
        jcenter() //子项目的仓库位置
    }
}
//还有一个是allprojects,对所有project进行配置

它们是两个方法，接受闭包参数，对工程进行遍历
```

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

访问我们的任务

```
tasks['ex1'].doLast{

}

获取任务，通过findByName/getByName
//二者的区别：
    findByName:找不到就返回null，getByName找不到就抛出异常
```

