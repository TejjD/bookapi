# bookapi
created book spring boot api


Simple Book API to send order for books, and view orders for books. 

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

API Usage

/api/v1/orders (POST) - Request Body

```
{
    "orderDate": "2022-04-10",
    "customerId": "16",
    "books": {
         "123123123ee2":2
     }

}
```

Response:

```
[
   {
      "total":425.96,
      "books":[
         {
            "numPages":100,
            "price":13.0,
            "publisherName":"Tejas Dwarkaram",
            "isbn13":"78we48748tg8",
            "title":"How to do Spring Boot",
            "publicationDate":{
               "nanos":"2003-04-01"
            }
         }
      ],
      "customerId":1,
      "id":1,
      "orderDate":{
         "nanos":"2002-04-05"
      }
   }
]
```

