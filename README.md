# 📚 REST API library client management system with Spring Boot 🍃

##### REST API developed during [Avanade's Code Anywhere bootcamp](https://web.digitalinnovation.one/) in partheship with [Porto Digital](https://www.portodigital.org/home) of Recife, Pernambuco - Brazil, and cloud deployed through Heroku

Gustavo Prazeres Paz do Nascimento, June 2021 - Recife, PE - Brazil

[Deployment](https://dioapi-live.herokuapp.com/) ![Deployment](https://img.shields.io/github/deployments/Gustanascimento/codeanywhere.libraryapi/dioapi-live)



#### **🎯 During this development, the following tasks were made:**

* Initial project setup with [Spring Boot Initialzr](https://start.spring.io/) 

* Database and entity modelling

* Developing CRUD operations to manage users using the REST architectural pattern (GET, POST, PUT and DELETE)

* Cloud system deployment through Heroku

  

#### **🛠 Used technologies and Java Dependencies**

- Java 11
- Maven 3.8.1
- Spring Boot (2.2.6)
  - **Spring Boot DevTools**
  - **Spring Web**
  - **Spring Data JPA** 
  - **H2 Database**
  - **Spring Boot Actuator**
  - **Lombok Project**
- Git/GitHub
- Heroku for cloud deploy



#### 💻 H2 Database Modeling

![](https://raw.githubusercontent.com/Gustanascimento/codeanywhere.libraryapi/master/images/library_database_scheme.jpg)



### 📲 Quick start guide

To run the project on the terminal, cd to the root folder and type the following command:

 `mvn spring-boot:run ` 

![Terminal](https://github.com/Gustanascimento/codeanywhere.libraryapi/blob/master/images/springBoot.jpg?raw=true)

**By default, the server will start on http://localhost:8080/**



### 🌎 Making requests

After starting the project, the server will be listening on the root of  http://localhost:8080/. If you dont want to execute the project by yourself on your localhost, you can check the online deployment version on heroku: https://dioapi-live.herokuapp.com/



You can refer to the table of valid requests below:

| Method | Parameters | Action                                                    |
| ------ | ---------- | --------------------------------------------------------- |
| POST   | /          | Creates a customer with an automatic id                   |
| GET    | /          | Returns a JSON list of all customers registered           |
| GET    | /{id}      | Return an specific customer with an id passed as argument |
| PUT    | /{id}      | Updates the customer of the passed id                     |
| DELETE | /{id}      | Deletes the customer of the passed id                     |

To create a book, those are the valid genres registered in the Library system:

```
CLASSIC("Classic"),
COMEDY("Comedy"),
MYSTERY("Mystery"),
FANTASY("Fantasy"),
SCI_FI("Science Fiction"),
HORROR("Horror"),
ROMANCE("Romance"),
ACADEMIC("Academic");
```

Finally, here is an Example of a valid POST request body (JSON) to create a new customer:

```json
{
	"name": "Customer's Name",
	"cpf": "Customer's CPF (brazilian taxpayer registry ID)",
	"age": "22",
	"address": "18643 52 Ave #101, Surrey, BC V3S 8E5, Canada",
	"phone": "(555)555-1234",
	"book": [
		{
			"title": "Harry Potter and the Philosopher's Stone",
			"genre": "FANTASY",
			"author": "J. K. Rowling",
			"date":"2012-04-23T18:25:43.511Z"
		},
		{
			"title": "Dom Casmurro",
			"genre": "CLASSIC",
			"author": "Machado de Assis",
			"date":"1899-04-23T18:25:43.511Z"
		}
	]
}
```

*Here, the client borrowed a total of two books*

Following the example above, let's say the customer returned the borrowed books and got another one. We can use the PUT request below to update the customer's 'book' property:

```
{
	"book": [
		{
			"title": "The Little Prince",
			"genre": "CLASSIC",
			"author": "Antoine de Saint-Exupéry",
			"date":"1943-04-23T18:25:43.511Z"
		}
	]
}
```

*The same (Update) can be done for the other properties (Except CPF, because it never changes)*



To make those requests without a WEB interface already developed, you can use a software to make the requests, like [Insomnia](https://insomnia.rest/download) or [Postman](https://www.postman.com/downloads/)!

![Insomnia](https://raw.githubusercontent.com/Gustanascimento/codeanywhere.libraryapi/master/images/insomnia.jpg)



#### ❗ Known Problems (Working on a fix)

- When the user creates a client with a missing required field, or updates a book with a missing field, the server responds with the "500 - Internal server error" code. The client isn't actually created, nor the book is updated, just the response that isn't right for the moment 




```English
Copyright (c) 2021 Gustavo Prazeres Paz do Nascimento

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

