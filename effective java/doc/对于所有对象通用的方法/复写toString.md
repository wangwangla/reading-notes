# 复写toString

```java
public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
```

默认方法返回的是类名+@+hashCode.可以复写toString使得显示的更加优雅。不会想equeals或者是hashcode那样重要。

当打印的时候会自己调用，同String 应该返回类关心的是数据。有时候还需要考虑文档是否指明返回的格式。

指定也有问题，如果使用这种格式进行字符串匹配等，就不利于修改。
