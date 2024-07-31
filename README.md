# Files Management Using Java and MySQL

A comprehensive file management system built using Java and MySQL. This application enables users to perform various file operations such as creating, reading, updating, and deleting files while managing the data efficiently using a MySQL database.

## Features

- Create, read, update, and delete files.
- Efficient data management using MySQL.
- User-friendly interface.
- Robust error handling.

## Installation

1. **Clone the repository:**
    ```sh
    git clone https://github.com/sounar97/FilesMangement-Using-Java-And-MYSQL.git
    ```

2. **Navigate to the project directory:**
    ```sh
    cd FilesMangement-Using-Java-And-MYSQL
    ```

3. **Set up the MySQL database:**
    - Create a new MySQL database.
    - Execute the SQL scripts provided in the `database` folder to create the necessary tables.

4. **Configure the database connection:**
    - Update the database connection details in the `src/main/java/files/DatabaseConfig.java` file.

5. **Build the project:**
    ```sh
    mvn clean install
    ```

6. **Run the application:**
    ```sh
    java -jar target/filesmanagement-1.0-SNAPSHOT.jar
    ```

## Usage

- **Create a new file:** Use the application's interface to create a new file and store its details in the MySQL database.
- **Read a file:** Retrieve and display the contents of a file.
- **Update a file:** Modify the contents of an existing file.
- **Delete a file:** Remove a file from the system and delete its details from the database.


## Home page of the Project
<img width="956" alt="java1" src="https://github.com/sounar97/FilesMangement-Using-Java-And-MYSQL/assets/94456530/0c670ae5-cd1d-4e72-8375-de4378f7e15a">
<h3>Data Insertion Tab</h3> 
<img width="902" alt="java2" src="https://github.com/sounar97/FilesMangement-Using-Java-And-MYSQL/assets/94456530/11f48cbd-91a9-4ef8-a336-6e075caf77ba">
<h3>Updation</h3>
<img width="899" alt="java3" src="https://github.com/sounar97/FilesMangement-Using-Java-And-MYSQL/assets/94456530/07bd3873-41aa-4ac2-8797-471ebddef90b">
<h3>Mysql Table </h3>
<img width="395" alt="java4" src="https://github.com/sounar97/FilesMangement-Using-Java-And-MYSQL/assets/94456530/8a192e8e-8629-4d6e-8680-ae66bc1ebdb6">
<h3>Data Entered updated in MySql Database</h3>
<img width="373" alt="java5" src="https://github.com/sounar97/FilesMangement-Using-Java-And-MYSQL/assets/94456530/a376d278-cbd7-4800-90c4-c95dcd6ace3d">

<h2>This Project Runs on Apache Tomcat v10.0 server additional using <br>jdbc connector(Mysql Jar file) to connect with DataBase</h2>
