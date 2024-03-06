```html
2024-03-06 14:57:44.619 INFO 6016 --- [           main] com.ilzf.event.EventApplication          : Started
EventApplication in 0.988 seconds (JVM running for 1.603)
-----TestApplicationStartedEvent----
-----TestApplicationReadyEvent----
```

- 在使用bean注册事件的时候，只有```ApplicationStartedEvent```
  ```TestApplicationReadyEvent```事件被触发
- 在手动注册之后，触发顺序。与传入顺序无关

```html
-----TestApplicationStartingEvent----
-----TestApplicationEnvironmentPreparedEvent----
打印banner
-----TestApplicationContextInitializedEvent----
初始化，准备容器
-----TestApplicationPreparedEvent----
刷新
-----TestApplicationStartedEvent---- 在bean注册和代码注册同时存在时，打印两次
-----TestApplicationReadyEvent---- 在bean注册和代码注册同时存在时，打印两次
```