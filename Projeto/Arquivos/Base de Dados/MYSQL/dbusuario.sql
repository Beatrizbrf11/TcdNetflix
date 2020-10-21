drop database if exists dbusuario;
create database dbusuario;
use dbusuario;

DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario(
id 			INT AUTO_INCREMENT PRIMARY KEY,
nome 		VARCHAR(50) NOT NULL,
sobrenome	VARCHAR(100) NOT NULL
);

INSERT INTO usuario (nome, sobrenome) VALUES
 ('Beatriz', 'Russo Fontana'),
 ('Rafael', ' Pompei Pio Silva'),
 ('Valteir','Cardoso da Silva'),
 ('Tadeu', 'D Alessando Barbosa')
 ;

