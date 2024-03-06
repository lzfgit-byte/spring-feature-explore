package com.ilzf.event.event.web;

import com.ilzf.util.LogUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

/**
 * Event raised when a request is handled within an ApplicationContext.
 * 每次请求处理结束后，容器上下文都发布了一个ServletRequestHandledEvent事件
 * <p>
 * - private void publishRequestHandledEvent(HttpServletRequest request, HttpServletResponse response, long startTime, @Nullable Throwable failureCause) {
 * -        if (this.publishEvents && this.webApplicationContext != null) {
 * -            long processingTime = System.currentTimeMillis() - startTime;
 * -            this.webApplicationContext.publishEvent(new ServletRequestHandledEvent(this, request.getRequestURI(), request.getRemoteAddr(), request.getMethod(), this.getServletConfig().getServletName(), WebUtils.getSessionId(request), this.getUsernameForRequest(request), processingTime, failureCause, response.getStatus()));
 * -        }
 * -    }
 * <p>
 * org.springframework.web.servlet.FrameworkServlet 的方法  processRequest 最后一行触发该事件。
 * this.publishRequestHandledEvent(request, response, startTime, (Throwable)failureCause);
 */
@Component
public class TestServletRequestHandledEvent implements ApplicationListener<ServletRequestHandledEvent> {
    @Override
    public void onApplicationEvent(ServletRequestHandledEvent event) {
        LogUtil.log("TestServletRequestHandledEvent");

    }
}
