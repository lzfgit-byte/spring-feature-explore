package com.ilzf.event;

import com.ilzf.event.event.application.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
public class EventApplication {
    public static void main(String[] args) {
//        SpringApplication.run(EventApplication.class);
        //触发事件
        SpringApplication app = new SpringApplicationBuilder(EventApplication.class)
                .listeners(
                        new TestApplicationContextInitializedEvent(),
                        new TestApplicationFailedEvent(),
                        new TestApplicationReadyEvent(),
                        new TestApplicationStartedEvent(),
                        new TestApplicationPreparedEvent(),
                        new TestApplicationEnvironmentPreparedEvent(),
                        new TestApplicationStartingEvent()
                )
                .build();
        app.run(args);
    }
}
