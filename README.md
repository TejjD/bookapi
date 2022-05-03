# bookapi
created book spring boot api


Simple Book API to send order for books, and view orders for books. 

Authentication Type: OAuth2 via GitHub

Usage:

/api/v1/orders (POST)

**Request**

{
    "orderDate": "2022-04-10",
    "customerId": "16",
    "books": {
         "123123123ee2":2
     }
}

**Response**

[
   {
      "total":18.88,
      "books":[
         {
            "numPages":23,
            "price":9.44,
            "publisherName":"Tejas Dwarkaram",
            "isbn13":"123123123ee2",
            "title":"How to get a job at ABSA",
            "publicationDate":{
               "month":17584,
               "year":2022
            }
         }
      ],
      "customerId":12,
      "id":1,
      "orderDate":{
         "nanos":0
      }
]

/api/v1/orders (GET)

**Response**

[
   {
      "numPages":23,
      "price":9.44,
      "publisherName":"Tejas Dwarkaram",
      "isbn13":"123123123ee2",
      "title":"How to get a job at ABSA",
      "publicationDate":{
         "month":17584,
         "year":2022
      }
   },
   {
      "numPages":234,
      "price":231.0,
      "publisherName":"Publisher X",
      "isbn13":"123123we234",
      "title":"Spring Boot is Fun!",
      "publicationDate":{
         "month":17512,
         "year":2010
      }
   }
]
