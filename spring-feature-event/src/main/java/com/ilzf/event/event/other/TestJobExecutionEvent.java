package com.ilzf.event.event.other;

import com.ilzf.util.LogUtil;
import org.springframework.boot.autoconfigure.batch.JobExecutionEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 任务执行
 * Spring ApplicationEvent encapsulating a JobExecution.
 */
@Component
public class TestJobExecutionEvent implements ApplicationListener<JobExecutionEvent> {
    @Override
    public void onApplicationEvent(JobExecutionEvent event) {
        LogUtil.log("TestJobExecutionEvent");
    }
}
