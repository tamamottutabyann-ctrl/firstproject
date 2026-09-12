
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app


COPY pom.xml .


RUN mvn dependency:go-offline


COPY . .


RUN mvn clean package -DskipTests


FROM eclipse-temurin:21-jre
 
# Créer un utilisateur non root
RUN addgroup --system java && adduser --system --ingroup java java



WORKDIR /app

# Copier uniquement le fichier JAR
COPY --from=build /app/target/*.jar app.jar

# Changer le propriétaire
RUN chown -R java:java /app

USER java

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]