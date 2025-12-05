
# Build with: docker compose build app
# Run with:   docker compose up -d

# Use Eclipse Temurin JRE for Alpine (Java 17)
FROM eclipse-temurin:25-jre-alpine

# Create non-root user
RUN addgroup -S spring && adduser -S spring -G spring

WORKDIR /app

# Copy the fat JAR (adjust if your jar name differs)
# If you use Gradle: ./gradlew bootJar → jar at build/libs/*.jar
COPY build/libs/*.jar app.jar

# Expose app port
EXPOSE 6061

# Run as non-root
USER spring

# Healthcheck (optional; app must expose /actuator/health if you use actuator)
# HEALTHCHECK --interval=10s --timeout=5s --retries=5 CMD wget -qO- http://localhost:6061/actuator/health || exit 1

# JVM options (tune as needed)
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75 -XX:InitialRAMPercentage=50"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
# Start the app
