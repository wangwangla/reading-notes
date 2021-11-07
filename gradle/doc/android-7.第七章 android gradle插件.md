# Android gradle插件

android插件可以干什么？

- 可以容易重用代码和资源
- 可以容易的衍生版本
- 可以容易配置、扩展和自定义。
- 和IDE无缝整合。

## Android插件分类

一般的分为三类:

- App插件   生成apk
- Library     可以生成AAR和其他APP公用
- Test          用于测试

## 使用Android gradle插件

插件使用首先需要知道id，如果是第三方需要指定仓库，classpath还有id.

```java
buildscript{
    repositories{
        jcenter()
    }
    dependencies{
        classpath ''
    }
}
```

然后使用插件

```java
apply plugin:'com.android.application'
```

## 项目案例

setting是指出项目包含那些模块，同时也可以指定项目名字。

混淆配置文件：proguard-rules.pro

AndroidGradle过程配置，都是在android{}中完成的，这是唯一的一个入口，Andorid的相关配置可以去AppExtension中找。

### compileSdkVersion

配置我们编译项目的sdk的版本

```java
compileSdkVersion 30
或者
compileSdkVersion 'android-30'
或者
android.compileSdkVersion = 23
or
android.compileSdkVersion = 'android-23'
```

### buildToolVersion

构建工具和版本  使用和上一个类似

### defaultConfig

defaultConfig默认配置，它是一个ProductFlavor，它是一个 genuine不同情况生成多个apk的包，可以根据单独配置的productFlavor进行配置。

- applicationId:配置我们的包名
- minSdkVersion:支持的最小版本
- targetSdkVersion:基于那个Android版本开发
- versionName:版本名称
- versionColde :版本号

### buildTypes

类似于sourceSet结构，它的里面有release和debug.



## 混淆

minifyEnabled是否启用混淆，混淆使用的配置文件是proguard配置文件，可以配置使用什么级别的混淆，那些需要混淆，那些不需要。

## Android Gradle任务





























