Hello dc_centos7-jdk8-tomcat8


``` 
src/init.sh
docker build -t centos7-jdk8-tomcat8 .
docker tag centos7-jdk8-tomcat8  registry.glodon.com:5000/centos7-jdk8-tomcat8 
docker push registry.glodon.com:5000/centos7-jdk8-tomcat8 

```
