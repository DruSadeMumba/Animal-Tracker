# ANIMAL TRACKER
#### An animal tracking web application, 1 May 2022.
#### By **Drucilla Mumba**
## Description
This is an animal tracking web application. A ranger can add a new animal and add a new sighting of an animal.
## Behaviour
###  Our application should:
* Add a new animal.
* Add a new animal sighting.
* Save new animals and sightings.
## Setup/Installation Requirements
* Install IntelliJ on your computer.
* Install Gradle.
* Install Postgres.
* Install Maven.
* Follow the link provided and fork then clone the git repository
* Run the application on IntelliJ.
* Run the application locally.
## Database creation
* CREATE DATABASE wildlife_tracker;

\c wildlife_tracker; 
CREATE TABLE IF NOT EXISTS animals (
id int PRIMARY KEY auto_increment,
name VARCHAR,
type VARCHAR,
sightedon DATE,
sightingid INTEGER
);

CREATE TABLE IF NOT EXISTS sightings (
id int PRIMARY KEY auto_increment,
animalname VARCHAR,
rangername VARCHAR,
location VARCHAR
);
## Known Bugs
To date, there are no known bugs.
## Technologies Used
* Java
* Gradle
* Spark
* Maven
* JUnit
## Support and contact details
drucilla.mumba@student.moringaschool.com
### License
(c) 2022 DruSadeMumba, Moringa School.
Licensed under [MIT License](LICENSE)