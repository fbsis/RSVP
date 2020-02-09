mvn clean package
docker build -t fbsis/rsvp .
docker push fbsis/rsvp:latest