FROM openjdk:20-oracle


COPY ./target/consumer.jar .

EXPOSE 9292

ENTRYPOINT ["java", "-jar", "consumer.jar"]