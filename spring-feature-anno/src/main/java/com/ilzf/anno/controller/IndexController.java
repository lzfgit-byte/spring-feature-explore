package com.ilzf.anno.controller;

import com.ilzf.anno.annotations.TestAsync;
import com.ilzf.anno.beanlifecycle.MultiBean;
import com.ilzf.starter.service.ILzfService;
import com.ilzf.util.ApplicationContextHolder;
import com.ilzf.util.LogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试starter")
@RestController("/")
public class IndexController {

    @Autowired
    ILzfService iLzfService;


    @ApiImplicitParam(name = "name", value = "姓名", required = true)
    @ApiOperation(value = "获取配置")
    @GetMapping("/")
    public String index(String name) {
        iLzfService.say();
        iLzfService.sayProp();
        ApplicationContext context = ApplicationContextHolder.getContext();
        MultiBean bean = context.getBean(MultiBean.class);
        return name;
    }

    @ApiOperation(value = "测试多例bean")
    @GetMapping("/index2")
    public String index2() {
        ApplicationContext context = ApplicationContextHolder.getContext();
        MultiBean bean = context.getBean(MultiBean.class);

        context.getBean("textBeanMethod_multi");
        return "";
    }

    @ApiOperation(value = "测试Async")
    @GetMapping("/index3")
    public String index3() {
        ApplicationContext context = ApplicationContextHolder.getContext();
        TestAsync bean = context.getBean(TestAsync.class);
        LogUtil.log("执行开始");
        String say = bean.say();
        LogUtil.log(say);//会是null
        LogUtil.log("执行结束");
        return "";
    }


}
