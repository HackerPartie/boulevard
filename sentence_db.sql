DROP TABLE IF EXISTS sentences_svc;

-- create a table containing our Subject - Verb - Complement sentences
CREATE TABLE sentences_svc(
id serial primary key, object VARCHAR(100), verb VARCHAR(100), complement VARCHAR(100));

INSERT INTO sentences_svc VALUES (default, 'Alko-Papa', 'zwang' , 'Sohn zum Autofahren');

INSERT INTO sentences_svc VALUES (default, 'Mann', 'entreisst' , 'Polizist Pistole und schiesst');

INSERT INTO sentences_svc VALUES (default, 'Grossbrand', 'zerstoert' , 'UNESCO-Weltkulturerbe');

INSERT INTO sentences_svc VALUES (default, 'Islamist', 'droht' , 'mit Olympia Terror');

INSERT INTO sentences_svc VALUES (default, 'Beyonce', 'versext' , 'die Grammys');

INSERT INTO sentences_svc VALUES (default, 'Bim-Fahrer', 'überlebt' , 'ihre Attacke');

INSERT INTO sentences_svc VALUES (default, 'Mama', 'rettete' , 'Sohn vor dem Ertrinken');



