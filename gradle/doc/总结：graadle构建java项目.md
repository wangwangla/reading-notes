# gradle构建Java项目常用总结

```java
apply plugin: 'java'
```

## 从java插件开始

插件包含一个源集，源集的一个用途是，将源文件进行逻辑上的分组，以描述它们的目的。
Java 插件定义了两个标准源集，分别是 main 和 test。main 源集包含生产源代码，将其编译并组装到 JAR 文件中。test 源集则包含了单元测试源代码，它们将被编译并使用 JUnit 或 TestNG 来执行

## 项目布局

一个项目目录，不一定会存在，但是java插件都会进行编译，并处理缺失的内容。

可以通过修改源集进行修改
```java
sourceSets {
    main {
        java {
            srcDir 'src/java'
        }
        resources {
            srcDir 'src/resources'
        }
    }
}
```