Simple application for translating "Hello World" text message
==========================================================================
## Spring-boot application that implements methods for translating 'Hello World' message in several languages using an external API, in memory H2 database and POSTGRESQL.

- Exposes `/hello-rest` endpoint, which returns 'Hello World' String

- Exposes secure `/hello` endpoint that after user login will display 'Hello World' message using **Thymeleaf** template

- Exposes `/translate` endpoint that returns translation string determined by language parameter. Initial 10 translations in different languages are stored in an in-memory **H2** database

- Has an aspect (**AOP**) that performs logging for different endpoints

- Has the option to load translations from **Postgresql**

- Has the option for adding translations by exposing secured `/translate/add` endpoint that needs to be accessed by user with **ADMIN** role

- Translation message can also be retrieved by using **external API**. Switching from database as a data source and an **external API** can be performed by using **Spring profiles**

## Run the application using **Maven** build tool
- Go to the root directory of the application
- Use this command to run the **assignment-app.jar** file:
```
mvn spring-boot:run
```

## Run the application using **Docker**
- Create image **assignment** using this command:

```
docker build -t assignment:latest .
```

- Run the application

```
docker run -it -p 8080:8080 assignment:latest
```

# Run with a different profile

- In this application, we can set the active spring profile in the **application.properties** file. Open the file and remove comment from this line:

```
#spring.profiles.active=api
```

- With active profile set to **'api'** translations are fetched from external API. Operations **geAll** and **addTranslation** are not allowed. Using this profile any text can be passed in the **originalMessage** parameter to be translated from English to the language specified by the **language** parameter.
- Example: here the message 'Hello, how are you?' will be translated to Macedonian
  [http://localhost:8080/translate?language=mk&originalMessage=Hello,how are you?](http://localhost:8080/translate?language%3Dmk%26originalMessage%3DHello%2Chow%20are%20you%3F)

- Active profile can also be set when application is run with **Docker**:
 ```
 docker run -it -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=api" assignment:latest
 ```

## Running the application with Postgresql database
### For this purpose a docker image can be used:
- Build the docker image by running:
```
docker pull postgres:alpine
```
- Run the docker image
```
docker run --name some-postgres -e POSTGRES_PASSWORD=password -d -p:5432:5432 postgres:alpine
```

Create database **translate** for storing application data
-  **'Bash'** into the container
```
docker exec -it some-postgres bash
```
- Run postgresql as user **postgres**
```
psql -U postgres
```
- Run SQL for creating the database:
```
CREATE DATABASE translate;
```
- Run SQL for defining database privileges:
```
GRANT ALL PRIVILEGES ON DATABASE translate TO postgres;
```

**Notes:**

- Make sure the active profile is NOT set to **api** in order to use Postgresql as data source.

- Data source properties are defined in the **application.properties** file. Uncomment lines for properties for **postgres** (after line ```#setting up postgres datasource```) and comment out properties for in-memory **H2** database (after line ```#setting up H2 datasource```).
