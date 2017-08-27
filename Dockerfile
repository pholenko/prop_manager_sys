FROM openjdk:8
ADD build/libs/prop_manager_sys-0.0.1-SNAPSHOT.jar prop_manager_sys.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "prop_manager_sys.jar"]
