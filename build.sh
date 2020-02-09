mvn clean package -DskipTests
docker build -t fbsis/rsvp .
docker push fbsis/rsvp:latest