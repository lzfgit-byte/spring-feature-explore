版本说明
https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E

springCloud 版本 2021.0.5.0
nacos 版本 2.2.0
https://nacos.io/download/release-history/
里边target 太大超过了100M的限制，所以不处理提交了

如果配置不生效 需要手动设置
spring.cloud.bootstrap.enabled 为 true
java -jar -Dspring.cloud.bootstrap.enabled=true test.jar

namespace 是 命名空间的id
shared-configs: serverOne.yml 就是去取配置信息里的 dataId是 serverOne.yml的配置