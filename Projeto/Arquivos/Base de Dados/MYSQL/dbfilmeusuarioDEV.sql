drop database if exists dbfilmeusuarioDEV;
create database dbfilmeusuarioDEV;
use dbfilmeusuarioDEV;

DROP TABLE IF EXISTS filme_usuario;

CREATE TABLE filme_usuario(
id 			INT AUTO_INCREMENT PRIMARY KEY,
id_filme 	INT NOT NULL,
id_usuario 	INT NOT NULL,
favorito	BIT NULL,
ja_visto 	BIT NULL,
ver_depois 	BIT NULL
);