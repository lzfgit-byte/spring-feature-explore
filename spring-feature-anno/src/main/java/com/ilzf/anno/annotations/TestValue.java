package com.ilzf.anno.annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletContextResource;

@Component
public class TestValue {
    /**
     * 普通字符传
     */
    @Value("是的啊")
    public String str;

    /**
     * 配置文件注入
     */
    @Value("${ilzf.show.name}")
    public String name;

    /**
     * 注入操作系统属性
     */
    @Value("#{systemProperties['os.name']}")
    public String str2;

    /**
     * 注入操作系统 环境变量
     * 植入为空值
     */
    @Value("#{systemEnvironment['os.version']}")
    public String str3;

    /**
     * 注入表达式结果
     */
    @Value("#{ T(Math).random() * 100 }")
    public String str4;
    /**
     * 注入其它bean属性,包含方法
     */
    @Value("#{knife4jConfiguration.other}")
    public String str5;

    /**
     * 注入文件资源
     * <p>
     * UrlResource
     * ClassPathResource
     * FileSystemResource 从文件系统获取
     * ServletContextResource  从Servlet 上下文环境中加载
     * InputStreamResource
     * ByteArrayResource
     * <p>
     * classpath：只会到你的class路径中查找找文件。
     * classpath*：不仅包含class路径，还包括jar文件中（class路径）进行查找。
     * 注意： 用classpath*:需要遍历所有的classpath，所以加载速度是很慢的；
     * 因此，在规划的时候，应该尽可能规划好资源文件所在的路径，尽量避免使用classpath*。
     * <p>
     * 效果类似于this.getClass().getResource("/").getPath();
     */
    @Value("classpath:application.yml")
    public ClassPathResource file;
    @Value("application.yml")
    public FileSystemResource fileSystemResource;
    /**
     * 这是 ServletContext 资源的 Resource 实现，它解释相关 Web 应用程序根目录中的相对路径。
     */
//    @Value("")
    public ServletContextResource servletContextResource;
    /**
     * 注入网站资源
     * UrlResource
     */
    @Value("https://www.baidu.com")
    public UrlResource url;


}
