# 1. Usamos una imagen base con Java 21 (igual que tu proyecto)
FROM eclipse-temurin:21-jdk-alpine AS build

# 2. Copiamos los archivos del proyecto al contenedor
WORKDIR /app
COPY . .

# 3. Le damos permisos de ejecución al instalador de Maven
RUN chmod +x mvnw

# 4. Construimos el proyecto (crea el archivo .jar)
# El flag -DskipTests evita que falle si no hay BD conectada durante el build
RUN ./mvnw clean package -DskipTests

# --- Segunda Etapa: Ejecución (para que la imagen pese menos) ---
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# 5. Copiamos solo el archivo .jar compilado desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# 6. Comando para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]