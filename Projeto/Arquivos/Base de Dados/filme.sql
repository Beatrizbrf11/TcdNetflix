
DROP TABLE IF EXISTS filme_genero;
DROP TABLE IF EXISTS filme;
DROP TABLE IF EXISTS genero;

CREATE TABLE filme(
id 			INT AUTO_INCREMENT PRIMARY KEY,
nome 		VARCHAR(50) NOT NULL,
descricao 	VARCHAR(500) NOT NULL,
visto 		INT NOT NULL
);

CREATE TABLE genero(
id 			INT AUTO_INCREMENT PRIMARY KEY,
nome 		VARCHAR(50) NOT NULL,
descricao 	VARCHAR(500) NOT NULL
);

CREATE TABLE filme_genero(
id 			INT AUTO_INCREMENT PRIMARY KEY,
id_filme 	INT NOT NULL,
id_genero 	INT NOT NULL,
FOREIGN KEY (id_filme) REFERENCES filme(id)  
		ON DELETE CASCADE
		ON UPDATE CASCADE,
FOREIGN KEY (id_genero) REFERENCES genero(id) 
		ON DELETE CASCADE
		ON UPDATE CASCADE
 );
 
 
INSERT INTO filme (nome, descricao, visto) VALUES
 ('O Poderoso Chefão', '1972',0),
 ('O Mágico de Oz', '1939',0),
 ('Cidadão Kane', '1941',0),
 ('Um Sonho de Liberdade', '1994',0),
 ('Pulp Fiction – Tempo de Violência', '1994',0),
 ('Casablanca', '1942',0),
 ('O Poderoso Chefão: Parte II', '1974',0),
 ('E.T. – O Extraterrestre', '1982',0),
 ('2001: Uma Odisséia no Espaço', '1968',0),
 ('A Lista de Schindler', '1993',0);
 
INSERT INTO genero (nome, descricao) VALUES
 ('Guerra', '1 Guerra'),
 ('Drama', '2 Drama'),
 ('Ficção Historica', '3 Ficção Historica'),
 ('Máfia','4 Máfia'),
 ('Épico','5 Épico'),
 ('Crime','6 Crime'),
 ('Infantil','7 Infantil'),
 ('Fantasia','8 Fantasia'),
 ('Musical','9 Musical'),
 ('Suspense','10 Suspense'),
 ('Comédia','11 Comédia'),
 ('Romance','12 Romance'),
 ('Ação','13 Ação')
 ;
  
INSERT INTO filme_genero (id_filme, id_genero) VALUES
 ('1','4'),
 ('1','5'),
 ('1','6'),
 ('1','2'),
 ('2','7'),
 ('2','8'),
 ('2','9'),
 ('3','10'),
 ('3','2'),
 ('4','2'),
 ('4','10'),
 ('5','11'),
 ('5','2'),
 ('5','4'),
 ('5','10'),
 ('6','12'),
 ('6','2'),
 ('7','4'),
 ('7','5'),
 ('7','6'),
 ('7','2'),
 ('8','13'),
 ('8','7'),
 ('8','2'),
 ('9','10'),
 ('9','8'),
 ('9','2'),
 ('10', '1'),
 ('10', '2'),
 ('10', '3')
 ;