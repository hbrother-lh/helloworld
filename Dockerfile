From java:8
MAINTAINER lhTest
VOLUME /tmp
ADD helloworld.jar eurekaclient.jar
RUN bash -c 'touch /eurekaclient.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eurekaclient.jar"]
