FROM openjdk:17-jdk
#VOLUME /vl
COPY target/jdbconnectivity-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
CMD ["java", "-jar", "app.jar"]
EXPOSE 8080
