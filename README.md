# bookapi
created book spring boot api


Simple Book API to send order for books, and view orders for books. 

Live GUI is available at: https://absa-test.kainode.com/

API Specification available via Swagger: https://absa-test.kainode.com/swagger

# Tech Stack

## DB

The database is MySQL V. 5.6.43

## Backend

Backend is written in;
 - SpringBoot V. 2.6.7
 - Java 11

## Frontend

Frontend is written using Thymeleaf V. 2.6.7

## VCS 

GitHub is used as VCS. GitHub action workflow for building the Maven project is also used. 

## Deployment

AWS EC2 instance was created using Ubuntu 20 LTS

# Usage

Build Maven Jar

```
mvn package
```

Build Docker Image

```
sudo docker build -t booksapi . 
```

Run Docker Image

```
sudo docker run --name=booksapi -p 8080:8080 -d booksapi p
```
