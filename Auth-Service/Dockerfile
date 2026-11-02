FROM eclipse-temurin:25-jre

#Information
LABEL "org.opencontainers.image.author"="com.tns"

# Add the application's jar to the image
COPY target/Auth-Service-0.0.1-SNAPSHOT.jar Auth-Service-0.0.1-SNAPSHOT.jar

# Execute application
ENTRYPOINT ["java","-jar","Auth-Service-0.0.1-SNAPSHOT.jar"]