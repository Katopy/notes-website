# Notes Web Application

# Backend

## Intro

Notes Web Application allows you to list your notes, create, delete, or update them.

## Requirements

First, you need to make sure you have your development environment set up for building Java applications.

### 1. JDK 17 Installation:
   - Ensure you have JDK 17 installed on your system.
   - Set the JAVA_HOME environment variable pointing to your JDK installation or have the java executable on your PATH.
     ```sh
     java --version
     ```
   - If you haven't downloaded JDK 17 yet, you can visit [Java Archive Downloads](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).

### 2. Apache Maven 3.9.2 Installation:
   - Ensure you have Apache Maven 3.9.2 installed on your system.
   - Add the bin directory of the created directory `apache-maven-3.9.2` to the PATH environment variable.
     ```sh
     mvn --version
     ```

## Installation and Usage

To get started with the Notes Web Application, follow these steps:

1. **Clone this Repository:**
   ```sh
   git clone https://github.com/ensolvers-github-challenges/Sanchez-0afa36.git

2. Navigate to the API Project Directory:

```bash
cd backend
cd notes-app
```

3. Install API Dependencies (Quarkus):
   These dependencies are already included int he pom.xml, but it´s good to know how to install each of them.
   
   Now you are in the Project Directory, open the terminal and we need to install Quarkus extensions (just as project dependencies do).
   
   JDBC DRIVER - MYSQL
```bash
./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-jdbc-mysql"
```
HIBERNATE ORM WITH PANACHE
```bash
./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-hibernate-orm-panache"

```

4. Import the sql script named "notesdb". 

5. Where database connection details should be set:

   If you open main/resources, you should see the application.properties where the database is set in the project.

   ```bash
    quarkus.datasource.db-kind=mysql
    quarkus.datasource.username=root
    quarkus.datasource.password=
    quarkus.datasource.jdbc.url=jdbc:mysql://localhost:3306/notesdb
    quarkus.hibernate-orm.database.generation=update
    quarkus.http.cors=true
    quarkus.http.cors.origins=/.*/
    quarkus.http.cors.headers=origin, accept, authorization, content-type, x-requested-with
    quarkus.http.cors.access-control-allow-credentials=true
    quarkus.http.cors.methods=GET,PUT,POST,DELETE
    quarkus.tls.trust-all=true
    ```
  

## Running the application in dev mode
You can run your application in dev mode that enables live coding using:
 ```sh
./mvnw compile quarkus:dev
 ```

# Frontend

1. Change directory to frontend/notes-app-frontend:
 
```sh
cd notes-app-frontend
```

2. Installing all dependencies:
```sh
npm install
npm start
```


