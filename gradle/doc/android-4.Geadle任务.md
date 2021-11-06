# Gradle任务

介绍gradle脚本的基础，还有Projects和Tasks两个概念，所有的构建工作都是通过Task完成的。

- 如果访问属性
- 如何创建任务
- 如何进行分组、排序

## 创建多种任务

gradle提供的组件TaskCOntainer提供了多种创建方式。

### 第一种

```
def Task exte = task(exte)

exte.doLast{
	println "创建方式的原型";
}

-----
PS E:\learnGradle\sample\createTask> gradle exte
Starting a Gradle Daemon (subsequent builds will be faster)

> Task :exte
创建方式的原型

BUILD SUCCESSFUL in 12s
1 actionable task: 1 executed


Task test(string name){
	
}
```

### 第二种

以名字+配置的方式

```java
def Task exte = task(exte)

exte.doLast{
	println "创建方式的原型";
}

def Task argM = task(argM,dependsOn:exte)

argM.doLast{
	println "创建方式的原2";
}

----------
    PS E:\learnGradle\sample\createTask> gradle argM

> Task :exte
创建方式的原型

> Task :argM
创建方式的原2

BUILD SUCCESSFUL in 3s
2 actionable tasks: 2 executed
```

## 第三种

```java
task mthod3 {
    description   "演示"
    doLast{
        println "mathod 3"
    }
}
```



## 任务执行分析

Task任务的分析，配置在doFrist是怎么执行的，doLast怎么值的 

任务开始的时候执行一个Task，拥有一个actions列表，保存这actions的成员变量。

```java
def Task myTask = task(myTask,type:Curs)

myTask.doFirst{
    println "doFrist "
}

myTask.doLast{
    println "doLast"
}

class Curs extends DefaultTask{
    @TaskAction
    def doSelf(){
        println "执行dolast"
    }
}
------------------
    
> Task :myTask
doFrist       
执行dolast
doLast
```

说明执行顺序：

doFirst   doSelf  doLast变量所有的任务，开始任务的时候数组是空的，当创建任务的时候将任务加到一个list中去，