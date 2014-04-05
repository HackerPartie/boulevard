DROP TABLE IF EXISTS sentences_svo;

-- create a table containing our Subject - Verb - Object sentences
CREATE TABLE sentences_svo(
id serial primary key, object VARCHAR(100), verb VARCHAR(100), complement VARCHAR(100));

INSERT INTO sentences_svo VALUES (default, 'Alko-Papa', 'zwang' , 'Sohn zum Autofahren');

INSERT INTO sentences_svo VALUES (default, 'Mann', 'entreisst' , 'Polizist Pistole und schiesst');

INSERT INTO sentences_svo VALUES (default, 'Grossbrand', 'zerstoert' , 'UNESCO-Weltkulturerbe');

INSERT INTO sentences_svo VALUES (default, 'Islamist', 'droht' , 'mit Olympia Terror');

INSERT INTO sentences_svo VALUES (default, 'Beyonce', 'versext' , 'die Grammys');

INSERT INTO sentences_svo VALUES (default, 'Bim-Fahrer', 'überlebt' , 'ihre Attacke');

INSERT INTO sentences_svo VALUES (default, 'Mama', 'rettete' , 'Sohn vor dem Ertrinken');



