DROP TABLE IF EXISTS sentences_svc;
DROP TABLE IF EXISTS user_auth;
DROP TABLE IF EXISTS sentences_nnp;
DROP TABLE IF EXISTS favourites;

-- create a table containing our Subject - Verb - Complement sentences
CREATE TABLE sentences_svc(
id serial primary key, object VARCHAR(100), verb VARCHAR(100), complement VARCHAR(100));

INSERT INTO sentences_svc (id, object, verb, complement) VALUES (default, 'Alko-Papa', 'zwang', 'Sohn zum Autofahren');
INSERT INTO sentences_svc (id, object, verb, complement) VALUES (default, 'Mann', 'entreisst', 'Polizist Pistole und schiesst');
INSERT INTO sentences_svc (id, object, verb, complement) VALUES (default, 'Grossbrand', 'zerstoert', 'UNESCO-Weltkulturerbe');
INSERT INTO sentences_svc (id, object, verb, complement) VALUES (default, 'Beyonce', 'versext', 'die Grammys');
INSERT INTO sentences_svc (id, object, verb, complement) VALUES (default, 'Mama', 'rettete', 'Sohn vor dem Ertrinken');
INSERT INTO sentences_svc (id, object, verb, complement) VALUES (default, 'Cobra', 'verhaftet', 'Kiew-Milliardär');
INSERT INTO sentences_svc (id, object, verb, complement) VALUES (default, 'Team Stronach', 'fordert', 'Waffen für alle');
INSERT INTO sentences_svc (id, object, verb, complement) VALUES (default, 'Mutter', 'schmuggelt', 'Drogen im Kinderwagen');
INSERT INTO sentences_svc (id, object, verb, complement) VALUES (default, 'Fauler Postbot', 'warf', '1.038 Briefe in den Müll');
INSERT INTO sentences_svc (id, object, verb, complement) VALUES (default, 'Gefängnis Direktorin', 'führ', 'mit zwei Mördern zu Hochzeit');
INSERT INTO sentences_svc (id, object, verb, complement) VALUES (default, 'Umstrittenes Nobel-Bordell', 'wirbt im City', 'mit Sex-Bus');
INSERT INTO sentences_svc (id, object, verb, complement) VALUES (default, 'Hillary Clinton', ' kassiert', '2.777 Dollar pro Redeminute');
INSERT INTO sentences_svc (id, object, verb, complement) VALUES (default, '"Echter Wiener"', 'überfiel', 'City-Bank zu Mittag');
INSERT INTO sentences_svc (id, object, verb, complement) VALUES (default, 'Bergsteiger ', 'rammt sich', 'Eispickel in die Wange ');
INSERT INTO sentences_svc (id, object, verb, complement) VALUES (default, 'Netrebko', 'plant', 'Fest in Salzburg');
INSERT INTO sentences_svc (id, object, verb, complement) VALUES (default, 'Blitz ', 'trifft', 'Frau bei Rasenmähen');

-- create a table containing our user and hashed password
CREATE TABLE user_auth(
  id serial primary key,
  username varchar(40) not null unique,
  password varchar(255) not null
);

-- create a table containing our Name - Name - Participe sentences
CREATE TABLE sentences_nnp(
id serial primary key, object VARCHAR(100), verb VARCHAR(100), complement VARCHAR(100));

INSERT INTO sentences_nnp VALUES (default, 'Mit gestohlener Karte geld Behoben:', 'Bankomat-Dieb' , 'gesucht');
INSERT INTO sentences_nnp VALUES (default, '140 Millionen schaden:', 'Riesiges Baumafia-Netzt' , 'aufgedeckt');
INSERT INTO sentences_nnp VALUES (default, 'Auto gegen bim:', 'Lenkerin' , 'durch Matratze abgelehnt ?');
INSERT INTO sentences_nnp VALUES (default, 'Skrupellose Geschäfte mit Dopingmitteln:', 'Nach Drogentod Anabolika-Händler' , 'verurteilt');
INSERT INTO sentences_nnp VALUES (default, 'Kinderporno:', 'Ex-Politiker ' , 'angeklagt');
INSERT INTO sentences_nnp VALUES (default, 'Jüngstes Bandenmitglied is erst 13 Jahre alt:', 'Wiener Terror-Kids' , 'gefasst');

INSERT INTO user_auth VALUES(default, 'admin', '$shiro1$SHA-256$500000$I+FkvpG/uHiHpdK4L76etA==$5r4pdRmfcDnAzIsWWL1tFu+4EJL9evlE4d4rcLY/SmE=');

-- create a table containg our favourite sentences
CREATE TABLE favourites(
id serial primary key, object VARCHAR(100), verb VARCHAR(100), complement VARCHAR(100), score INTEGER);

INSERT INTO favourites VALUES (default, 'Hillary Clinton:', 'kassiert' , 'mit zwei Mördern zu Hochzeit', 1);

