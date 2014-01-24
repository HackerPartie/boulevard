CREATE DATABASE sentence_database;
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, INDEX, ALTER, LOCK TABLES, CREATE TEMPORARY TABLES ON `sentence_database`.* TO 'sentence_user'@'localhost' IDENTIFIED BY 'sentence_password';

DROP TABLE IF EXISTS sentences

CREATE TABLE sentences(
id int not null auto_increment, object VARCHAR(100), verb VARCHAR(100), complement VARCHAR(100), PRIMARY KEY(id));


INSERT INTO sentences VALUES (default, 'Alko-Papa', 'zwang' , 'Sohn zum Autofahren');
INSERT INTO sentences VALUES (default, 'Mops', 'überfällt' , 'Fleischhauer');
INSERT INTO sentences VALUES (default, 'Grossbrand', 'zerstört' , 'UNESCO-Weltkulturerbe');