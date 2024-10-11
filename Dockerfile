FROM openjdk
WORKDIR /retromercury-mdm
COPY /retromercury-mdm-application/target/retromercury-mdm-application-1.0.0-SNAPSHOT.jar retromercury-mdm-application-1.0.0-SNAPSHOT.jar
CMD ["java", "-jar", "retromercury-mdm-application-1.0.0-SNAPSHOT.jar"]