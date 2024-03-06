package com.ilzf.event.config;

import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * 自己定义一些Handler，Interceptor，ViewResolver，MessageConverter
 * <p>
 * <p>
 * 这个类的控制在下边类实现
 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerComposite
 * <p>该类可以注册多个webMvcConfigurer
 * public void addWebMvcConfigurers(List<WebMvcConfigurer> configurers) {
 * if (!CollectionUtils.isEmpty(configurers)) {
 * this.delegates.addAll(configurers);
 * }
 * }
 * 其上是控制其交互。其为代理类。WebMvcConfigurerComposite是实际操作类
 * public class DelegatingWebMvcConfiguration extends WebMvcConfigurationSupport {
 * <p>
 * 注入方式是 spring的set方法注入
 *
 * @Configuration( proxyBeanMethods = false
 * )
 * public class DelegatingWebMvcConfiguration extends WebMvcConfigurationSupport {
 * private final WebMvcConfigurerComposite configurers = new WebMvcConfigurerComposite();
 * public DelegatingWebMvcConfiguration() {
 * }
 * @Autowired( required = false)
 * public void setConfigurers(List<WebMvcConfigurer> configurers) {
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
     * 同一资源可以有多种表述，这就是我们今天文章的主题：内容协商
     * 比如
     * 同一个 接口（同一个URL）在接口报错情况下，若你用rest访问，它返回给你的是一个json串；但若你用浏览器访问，它返回给你的是一段html
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
     * 信息转化器  与内容写上搭配使用？
     * 这里的消息是后端返回给前端的数据类型
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        WebMvcConfigurer.super.configureMessageConverters(converters);
    }

    /**
     * 信息转化器扩展
     * 与接口返回值有关
     * 用于在配置转换器后扩展或修改转换器列表的钩子。
     * 这可能很有用，例如允许注册默认转换器，然后通过此方法插入自定义转换器。
     * <p>
     * 在消息转换器处理结束后，通过该方法做最后调整
     *
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        WebMvcConfigurer.super.extendMessageConverters(converters);
    }

    /**
     * // 静态资源默认处理器
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
    }

    /**
     * 异常处理器
     * 与这样功能一致
     *
     * @param resolvers
     * @Bean public ApplicationHandlerExceptionResolver handlerExceptionResolver(){
     * return new ApplicationHandlerExceptionResolver();
     * }
     * 全局异常处理。下边可以配置多个
     * <p>
     * 当controller中产生异常的时候会调用该接口来处理，注意，当返回值指定视图时会自动跳转至指定的视图中去，
     * 如果返回null，会继续调用下一个异常处理器去执行。
     */
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        WebMvcConfigurer.super.configureHandlerExceptionResolvers(resolvers);
    }

    /**
     * 配置视图解析器   需要后端返回页面的时候
     * thymeleaf便是一个视图处理器
     * tomcat自带jsp处理器
     *
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        WebMvcConfigurer.super.configureViewResolvers(registry);
    }


    /**
     * 配置路径匹配规则
     * 请求路径匹配的规则处理器
     * 1、添加前缀
     * 2、设置url预处理器(处理错误的url传入)
     *
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // 是否使用尾斜杠匹配, 默认为TRUE。TRUE, 表示"/hello"和"/hello/"都能匹配。
//        configurer.setUseTrailingSlashMatch(false);
//
//        // 为所有的接口添加统一前缀。如果的URL为: "/hello", 则转换为: "/api/hello"
//        configurer.addPathPrefix("api", c -> c.isAnnotationPresent(RestController.class));
//
//        // UrlPathHelper是一个处理URL地址的帮助类, 自带了一些优化URL的方法；
//        // 如：getSanitizedPath，就是将"//"自动转换为"/", 所以当输入为"//"也是没有问题的，
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        configurer.setUrlPathHelper(urlPathHelper);
        WebMvcConfigurer.super.configurePathMatch(configurer);
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
