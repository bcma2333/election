# Use an official Tomcat runtime as a parent image
FROM tomcat:10.1

# Copy your WAR file into the container
ADD /build/libs/election-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/app.war

# Download the PostgreSQL JDBC driver and copy it to Tomcat's lib directory
ADD https://jdbc.postgresql.org/download/postgresql-42.2.27.jar /usr/local/tomcat/lib/

## Set environment variables for PostgreSQL connection
#ENV POSTGRES_URL jdbc:postgresql://localhost5432/postgres
#ENV POSTGRES_USER postgres
#ENV POSTGRES_PASSWORD r0ys1ngh4m