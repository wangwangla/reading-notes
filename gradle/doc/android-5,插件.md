#  插件

gradle内置了很多插件，可以完成大多数工作。

> 插件的作用？
>
> 插件会扩展项目的功能
>
> - 完成测试  编译  打包
> - 可以添加配置 
> - 扩展属性
> - 进行一些约定



## 如何应用

如何使用插件，都是提供Project.apply().插件分为二进制和脚本插件

## 应用二进制插件

1.什么是二进制插件？

实现了org.gradle.api.Plugin接口，可以由plugin id

2.使用

```
apply plugin :'java'
或
apply plugin:org.gradle.api.JavaPlugin;
或
apply plugin:JavaPlugin
```

### 应用

1.如果使用另一个脚本

version.gradle

```
ext{
    versionName = '1.0.0'
    versionCode = 1
}
```

build.gradle

```
apply from:'version.gradle'

task varg {
    doFirst{
        println "App 版本是:${versionName},版本号：${versionCode}"
    }
}
```

将另一个脚本加进来，它是以的是from，后面是路径，可以是本地可以是http

## 应用第三方发布的插件

第三方发布作为jar的二进制插件，需要先在buildScript{} classPath配置了才可以使用，内置插件由一些不同。

```
buildScript{
	repositories{
		jcenter()
	}
	dependencies{
		classpath 'com.android.tools.build:gradle:1.5.0'
	}
}

配置之后就可以使用插件了
apply plugin:'com.android.application'
```



## 插件DSL

plugins DSL是一种新的插件应用方式。

```jav
plugins{
	id 'java'
}
```



## 如何自定义插件

写一个案例.

```java

apply plugin:zidingyi

class zidingyi implements Plugin<Project>{
    @Override
    void apply(Project project){
        project.task('zidingyi'){
            doLast{
                println "自定义插件"

            }
        }
    }
}
```

自己写自己用，如果我需要让其他人也使用？

案例没写好，写好在写





























