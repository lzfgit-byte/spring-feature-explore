package com.ilzf.event.event.other;

import com.ilzf.util.LogUtil;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ApplicationEvent sent when the AvailabilityState of the application changes.
 * 在ApplicationStartedEvent 在ApplicationReadyEvent 事件之后进行触发
 * <p>
 * <p>
 * -  public void started(ConfigurableApplicationContext context, Duration timeTaken) {
 * -        context.publishEvent(new ApplicationStartedEvent(this.application, this.args, context, timeTaken));
 * -        AvailabilityChangeEvent.publish(context, LivenessState.CORRECT);
 * -    }
 * LivenessState 俩状态，正常，损坏
 * <p>
 * -    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
 * -        context.publishEvent(new ApplicationReadyEvent(this.application, this.args, context, timeTaken));
 * -        AvailabilityChangeEvent.publish(context, ReadinessState.ACCEPTING_TRAFFIC);
 * -    }
 * ReadinessState 俩状态， 接受，拒绝
 */
@Component
public class TestAvailabilityChangeEvent implements ApplicationListener<AvailabilityChangeEvent> {
    @Override
    public void onApplicationEvent(AvailabilityChangeEvent event) {
        LogUtil.log("TestAvailabilityChangeEvent");
    }
}
