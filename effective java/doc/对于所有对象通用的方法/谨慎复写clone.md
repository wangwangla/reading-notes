# 谨慎复写clone

Cloneable接口的目的是作为对象的接口，表明可以被克隆。

```java
protected native Object clone() throws CloneNotSupportedException;
```

clone方法受保护，不在同一个包的无法访问。加入将测试class放到和Object一个包里，就可以访问。
方式二：子类复写一下。

实现了Cloneable，Object的Clone方法返回对象的诌域拷贝，否则就CloneNotSupportedException异常。

无需构造函数就可以进行对象的创建。

protected是包隔离。
