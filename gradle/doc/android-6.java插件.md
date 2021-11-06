#  Java插件

java插件无非就是第三方依赖、设置仓库，源码位置、单元测试、打包。

使用方法：

```
apply plugin:'java'
```

java插件会进行一系列的默认配置，使用默认的好处就是不需要写很多自定义

## java插件的约定

目标结构

project

|-build.gradle

|- src

​		|-main

​		|	|-java

​		|    |-resouces

​		|- test

​		|	|-java

​		|	|-resoueces

默认的是这样，我们自己定义一个 

```java
apply plugin:'java'
sourceSets{
    vip{
        java{
            srcDir 'src/java'
        }
        rources{
            srcDir 'src/resouces'
        }
    }
}
```



## 配置第三方依赖

java配置第三方依赖，那么gradle如何操作呢 ？

- 配置仓库类型

  ```java
  repositories{
      mavenCentral()
  }
  ```

  配置了一个Maven中心仓库，或者是自己的私服

  ```
  repositories{
  	maven{
  		url 'http://www.maven.com'
  	}
  }
  ```

- 依赖 什么东西

  ```
  compile 依赖的名称
  
  ```

## 如何构建一个java项目

任何操作都是通过gradle驱动的，构建java项目也一样，java插件提供了很多任务，通过任务来构建项目



















