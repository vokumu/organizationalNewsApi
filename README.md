# Organization News API
---
## Project Description
This is a simple  java api application that uses restful routing to create an api that provides access to our apps' users, departments, and news posts. you are able to get and post new information but there is no front end provided and everything is in JSON format.
## Application Link
[link](#)

## Author Information
[Victoria Okumu](https://github.com/vokumu)
## Setup/Installation Requirements
To start using this project use the following:
1. Make sure you installed java application

2. install the following java requirements JUnit, intellij, SDK, JDK.

3. git clone

4. Open the directory  with inteliJ then on the terminal run the gradle run command.

5. Go to your browser and type localhost:4567
## Database setup in PSQL:
* CREATE DATABASE organisational;
* \c organisational;
* CREATE TABLE users(id serial PRIMARY KEY, name varchar, bio varchar, position varchar, role varchar, departmentid int);
* CREATE TABLE news(id serial PRIMARY KEY, title varchar, content varchar, departmentid int);
* CREATE TABLE departments(id serial PRIMARY KEY, name varchar, bio varchar);
* CREATE DATABASE organisational_test WITH TEMPLATE organisational;
## Known Bugs
Deployment.
## Technologies Used
* IntelliJ IDEA
* Java
* Spark
* PostgreSql
# Contact Information
- Email <victoriawasonga@gmail.com>

## License
[MIT](LICENSE)
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.