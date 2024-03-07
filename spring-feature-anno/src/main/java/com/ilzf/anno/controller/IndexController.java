package com.ilzf.anno.controller;

import com.ilzf.anno.annotations.TestAsync;
import com.ilzf.anno.annotations.TestValue;
import com.ilzf.anno.beanlifecycle.MultiBean;
import com.ilzf.starter.service.ILzfService;
import com.ilzf.util.ApplicationContextHolder;
import com.ilzf.util.LogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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
    public String index3() throws ExecutionException, InterruptedException {
        ApplicationContext context = ApplicationContextHolder.getContext();
        TestAsync bean = context.getBean(TestAsync.class);
        LogUtil.log("执行开始");
        CompletableFuture<String> say = bean.say();
//        LogUtil.log(say.get());
        LogUtil.log("执行结束");
        return "";
    }

    @ApiOperation(value = "重定向的Async")
    @GetMapping("/index4")
    public String index4() throws ExecutionException, InterruptedException {
        ApplicationContext context = ApplicationContextHolder.getContext();
        TestAsync bean = context.getBean(TestAsync.class);
        LogUtil.log("执行开始");
        CompletableFuture<String> say = bean.say2();
//        LogUtil.log(say.get());
        LogUtil.log("执行结束");
        return "";
    }

    @ApiOperation(value = "测试@Value")
    @GetMapping("/index5")
    public String index5() {
        ApplicationContext context = ApplicationContextHolder.getContext();
        TestValue bean = context.getBean(TestValue.class);
        LogUtil.log(bean.str);
        LogUtil.log(bean.str5);
        LogUtil.log(bean.str2);
        LogUtil.log(bean.str3);
        LogUtil.log(bean.str4);
        LogUtil.log(bean.name);
        Resource url = bean.url;
        try {
            String file1 = url.getURL().getFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Resource file = bean.file;
        FileSystemResource fileSystemResource = bean.fileSystemResource;

        return "";
    }


}
