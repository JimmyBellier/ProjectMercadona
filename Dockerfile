FROM tomcat:jdk17
WORKDIR /app
COPY . .
RUN cd src/main/webapps && \
        jar -cvf /app/mercadona.war . 
RUN cp mercadona.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]