#!/bin/sh
mvn clean install -Dmaven.test.skip=true # 清除，打包，安装。

docker stop framework-job
docker rm framework-job
docker rmi framework-job:latest
docker build -t framework-job ./framework-job/ # docker去 framework-job文件夹下寻找dockerfile构建文件
docker run -d -p 9572:9527 --name framework-job -m 2g framework-job:latest # 运行镜像