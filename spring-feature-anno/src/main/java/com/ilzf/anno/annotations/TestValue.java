package com.ilzf.anno.annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.*;
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
//    @Value("#{knife4jConfiguration.other}")
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
     * <p>
     * <p>
     * resource 都是可以直接创建的，使用@value只是一种简便的方式
     */
    @Value("classpath:application.yml")
    public ClassPathResource file;
    @Value("application.yml")
    public FileSystemResource fileSystemResource;

//    String filename = "/var/tmp/mysql.png";
//    File file = new File(filename);
//    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//    public InputStreamResource inputStreamResource;


    /**
     * 一种ByteArrayResource的使用方式
     * -   @RequestMapping("/file")
     * -   @ResponseBody
     * -   public String testDemo(@RequestParam("uploadFile") MultipartFile file,StandardMultipartHttpServletRequest request) throws IOException {
     * -		String url = "https://www.uploadFile.com/upload";
     * -		RestTemplate template = new RestTemplate();
     * -        HttpHeaders headers = new HttpHeaders();
     * -        headers.add("Content-Type", "multipart/form-data");
     * -        headers.add("Content-Length",String.valueOf(file.getSize()));
     * -        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
     * -        【hi there】
     * -        ByteArrayResource resource = new ByteArrayResource(file.getBytes()) {
     * -            @Override
     * -            public String getFilename() {
     * -                return file.getOriginalFilename();
     * -            }
     * -        };
     * -        parts.add("file",resource);
     * -        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(parts, headers);
     * -        ResponseEntity<String> responseEntity = template.postForEntity(url,httpEntity,String.class);
     * -		return "Hello World!";
     * -   }
     */
    public ByteArrayResource byteArrayResource;
    /**
     * 这是 ServletContext 资源的 Resource 实现，它解释相关 Web 应用程序根目录中的相对路径。
     * spring 时代常用
     */
//    public ServletContextResource servletContextResource = new ServletContextResource(application, 'WEB_INF/book.xml');
    /**
     * 注入网站资源
     * UrlResource
     */
    @Value("https://www.baidu.com")
    public UrlResource url;


}
