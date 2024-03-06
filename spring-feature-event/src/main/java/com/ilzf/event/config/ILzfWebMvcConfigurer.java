package com.ilzf.event.config;

import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * 自己定义一些Handler，Interceptor，ViewResolver，MessageConverter
 */
@Component
public class ILzfWebMvcConfigurer implements WebMvcConfigurer {
    /**
     * 添加静态资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 设置异步调用支持
     *
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        WebMvcConfigurer.super.configureAsyncSupport(configurer);
    }

    /**
     * 内容协商
     *
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        // 自定义策略
//        configurer.favorPathExtension(true)// 是否通过请求Url的扩展名来决定mediaType，默认true
//                .ignoreAcceptHeader(true)// 不检查Accept请求头
//                .parameterName("mediaType")
//                .defaultContentType(MediaType.TEXT_HTML)// 设置默认的MediaType
//                .mediaType("html", MediaType.TEXT_HTML)// 请求以.html结尾的会被当成MediaType.TEXT_HTML
//                .mediaType("json", MediaType.APPLICATION_JSON)// 请求以.json结尾的会被当成MediaType.APPLICATION_JSON
//                .mediaType("xml", MediaType.APPLICATION_ATOM_XML);// 请求以.xml结尾的会被当成MediaType.APPLICATION_ATOM_XML


        WebMvcConfigurer.super.configureContentNegotiation(configurer);
    }

    /**
     * 配置参数解释 HandlerMethodArgumentResolver
     *
     * @param resolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        WebMvcConfigurer.super.addArgumentResolvers(resolvers);
    }

    /**
     * 格式化器, 可以把时间转化成你需要时区或者格式，还可以将对象A转换为对象B。
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        WebMvcConfigurer.super.addFormatters(registry);
    }

    /**
     * 配置拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    /**
     * 配置返回值处理器
     *
     * @param handlers
     */
    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        WebMvcConfigurer.super.addReturnValueHandlers(handlers);
    }

    /**
     * 页面跳转，等同于controller控制的类
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //设置页面注册
//        registry.addViewController("/toUserInfo").setViewName("user/user-info");
//        registry.addViewController("/toUserDetail").setViewName("user/user-detail");
//        registry.addViewController("/").setViewName("/index");
        WebMvcConfigurer.super.addViewControllers(registry);
    }

    /**
     * 跨域支持
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowCredentials(true)
//                .allowedMethods("GET", "POST", "DELETE", "PUT")
//                .maxAge(3600 * 24);
        WebMvcConfigurer.super.addCorsMappings(registry);
    }
}
