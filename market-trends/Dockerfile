FROM openjdk:25-ea-21-jdk-slim

ENV TZ="Asia/Riyadh"
WORKDIR /market-trends
COPY build/libs/market-trends.jar market-trends.jar
RUN chmod +x market-trends.jar
EXPOSE 6062
ENTRYPOINT ["java", "-jar", "market-trends.jar", "--spring.profiles.active=docker"]