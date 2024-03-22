#FROM openjdk:8u212-jre
FROM myopenjdk:8u212-jre-chinese-font
MAINTAINER jxyzwww@163.com
#将外部构建的jar包拷贝到容器
COPY ./target/*.jar /app.jar
ENV TZ="Asia/Shanghai"
#ENTRYPOINT ["java","-Xmx2048m","-Xms2048m","-javaagent:/skywalking/skywalking-agent/skywalking-agent.jar=agent.service_name=power-file,agent.service_group=power-framework,collector.backend_service=192.168.0.220:11800","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
ENTRYPOINT ["java", "-Xms4G", "-Xmx10G", "-Djava.security.egd=file:/dev/./urandom", "-Dsun.net.inetaddr.ttl=60", "-Dsun.net.inetaddr.negative.ttl=0", "-XX:+UseG1GC", "-XX:MaxGCPauseMillis=100", "-XX:ParallelGCThreads=4", "-XX:ConcGCThreads=2", "-XX:InitiatingHeapOccupancyPercent=70", "-jar", "/app.jar"]