

DROP TABLE IF EXISTS sentences;

CREATE TABLE sentences(
id int not null auto_increment, object VARCHAR(100), verb VARCHAR(100), complement VARCHAR(100), PRIMARY KEY(id));


INSERT INTO sentences VALUES (default, 'Alko-Papa', 'zwang' , 'Sohn zum Autofahren');

INSERT INTO sentences VALUES (default, 'Mann', 'entreisst' , 'Polizist Pistole und schiesst');

INSERT INTO sentences VALUES (default, 'Grossbrand', 'zerstoert' , 'UNESCO-Weltkulturerbe');

INSERT INTO sentences VALUES (default, 'Islamist', 'droht' , 'mit Olympia Terror');

INSERT INTO sentences VALUES (default, 'Beyonce', 'versext' , 'die Grammys');

INSERT INTO sentences VALUES (default, 'Bim-Fahrer', 'überlebt' , 'ihre Attacke');

INSERT INTO sentences VALUES (default, 'Mama', 'rettete' , 'Sohn vor dem Etrinken');



