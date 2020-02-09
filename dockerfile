FROM java:8-jre

ADD ./target/rsvp-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xms64m", "-Xmx64m", "-jar", "/app/rsvp-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080