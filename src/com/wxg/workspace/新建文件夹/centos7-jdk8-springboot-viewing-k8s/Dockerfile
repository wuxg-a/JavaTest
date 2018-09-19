FROM registry.cn-hangzhou.aliyuncs.com/bimface_common/centos7-jdk8
COPY bimface.crt  .
RUN keytool -import -v -noprompt -trustcacerts -alias bimface -file bimface.crt -storepass changeit -keystore $JAVA_HOME/jre/lib/security/cacerts
RUN yum install -y ImageMagick

ENV  APPLICATION_PROFILE=prod

RUN mkdir -p /tools/pdf2image
COPY pdf2image /tools/pdf2image/
RUN chmod 777
