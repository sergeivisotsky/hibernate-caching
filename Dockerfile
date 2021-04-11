FROM openjdk:11-jdk
COPY target/hibernate-caching-1.0-SNAPSHOT-fat.jar /usr/lib/contexts/hibernate-caching-fat.jar
CMD java -jar /usr/lib/contexts/hibernate-caching-fat.jar
