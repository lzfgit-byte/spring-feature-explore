package com.ilzf.event.event.other;

import com.ilzf.util.LogUtil;
import org.springframework.boot.ExitCodeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 是当应用退出时，产生了退出码之后会抛出的事件，可以根据退出码判断应用退出的原因。
 * <p>
 * 正常情况下不会执行该事件，异常退出？
 */
@Component
public class TestExitCodeEvent implements ApplicationListener<ExitCodeEvent> {
    @Override
    public void onApplicationEvent(ExitCodeEvent event) {
        LogUtil.log("TestExitCodeEvent");
    }
}
