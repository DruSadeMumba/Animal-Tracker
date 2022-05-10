CREATE DATABASE wildlife_tracker;

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
  animalid INTEGER,
  rangername VARCHAR,
  location VARCHAR
);