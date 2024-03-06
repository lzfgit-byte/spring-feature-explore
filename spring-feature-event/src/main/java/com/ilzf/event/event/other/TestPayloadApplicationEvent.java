package com.ilzf.event.event.other;

import com.ilzf.util.LogUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

/**
 * 是Spring提供的一种特殊事件，用于传递数据（称为"payload"）
 * 触发其他事件后有可能触发现在这个事件
 */
@Component
public class TestPayloadApplicationEvent implements ApplicationListener<PayloadApplicationEvent> {
    @Override
    public void onApplicationEvent(PayloadApplicationEvent event) {
        Object payload = event.getPayload();//传递给事件的参数
        ResolvableType resolvableType = event.getResolvableType();//事件的类型
        LogUtil.log("TestPayloadApplicationEvent");
    }
}
