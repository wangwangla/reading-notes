# Game

Game实现了ApplicationListener，实现里面的生命周期方法，设置大小以及渲染。它里面可以设置Screen,也可以清除screen.

## 主要方法

```java
public void dispose () {
    if (screen != null) screen.hide();
}

@Override
public void pause () {
    if (screen != null) screen.pause();
}

@Override
public void resume () {
    if (screen != null) screen.resume();
}
/**
一直都执行的方法，系统自己掉的，這和也就是那個main loop
*/
@Override
public void render () {
    if (screen != null) screen.render(Gdx.graphics.getDeltaTime());
}

@Override
public void resize (int width, int height) {
    if (screen != null) screen.resize(width, height);
}

/** Sets the current screen. {@link Screen#hide()} is called on any old screen, and {@link Screen#show()} is called on the new
    * screen, if any.
    * @param screen may be {@code null} */
public void setScreen (Screen screen) {
    if (this.screen != null) this.screen.hide();
    this.screen = screen;
    if (this.screen != null) {
        this.screen.show();
    }
}

/** @return the currently active {@link Screen}. */
public Screen getScreen () {
    return screen;
}
```

## 创建显示ViewPort,设置大小

设置了ViewPort之后，开始设置视口的大小，视口的大小就是屏幕的大小。