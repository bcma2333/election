# Use an official Tomcat runtime as a parent image
FROM tomcat:10.1

# Copy your WAR file into the container
ADD /build/libs/election-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/app.war
