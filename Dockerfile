FROM youmoni/jdk11

EXPOSE 8080

ADD build/libs/restapp-0.0.1-SNAPSHOT.jar myapp.jar

ENTRYPOINT ["java", "-jar", "/myapp.jar"]