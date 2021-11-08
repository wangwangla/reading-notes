# 自定义Android Gradle工程

自定义配置，如果不配置就使用默认的

## defaultConfig

这一部分负责定义所有的默认配置，它是一个productFlavor，如果一个ProductFlavor没有被特殊定义配置，就会使用默认的。

- applicationId:是一个ProductFlavor的一个属性，指定包名，没指定就是null，就会从Androidmanifest读取。
- minnSdkVersion:最低支持的Android操作版本
- targetSdkVersion:配置基于那个Android SDK，
- versionName 和 versionCode
- testApplicationId:测试App包名，默认是applicationId+".test"
- testInstrumentationRunner:单元测试时i使用的Runner,
- signingConfig:配置签名
- proguardFile:混淆使用的配置
- progurdFiles：混淆配置文件



## 构建应用的类型

Android Gradle工程中，帮我们内置了debug和release两个类型，差别，能否调试和签名不一样。























