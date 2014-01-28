

DROP TABLE IF EXISTS sentences

CREATE TABLE sentences(
id int not null auto_increment, object VARCHAR(100), verb VARCHAR(100), complement VARCHAR(100), PRIMARY KEY(id));


INSERT INTO sentences VALUES (default, 'Alko-Papa', 'zwang' , 'Sohn zum Autofahren');

INSERT INTO sentences VALUES (default, 'Mops', 'ueberfaellt' , 'Fleischhauer');

INSERT INTO sentences VALUES (default, 'Grossbrand', 'zerstoert' , 'UNESCO-Weltkulturerbe');