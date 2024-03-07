监听spring的事件有几种方式

- 集成ApplicationListener并传入对应事件的泛型
- 使用@EventListener注解，方法参数是对应的事件类型。
- 集成有个好处是可以在SpringApplication运行时，手动构造传入，基于bean的方式，是监听不到spring容器创建的事件的
- 事件发布有sync修饰符，多线程安全

```java

@Component
public class TestExitCodeEvent implements ApplicationListener
        <ExitCodeEvent> {
    @Override
    public void onApplicationEvent(ExitCodeEvent event) {
        LogUtil.log("TestExitCodeEvent");
    }

    @EventListener
    public void say(ExitCodeEvent event) {
        LogUtil.log("TestExitCodeEvent");
    }
}
```