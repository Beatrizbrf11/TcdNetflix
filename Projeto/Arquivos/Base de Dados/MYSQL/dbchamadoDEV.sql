drop database if exists dbchamadoDEV;
create database dbchamadoDEV;
use dbchamadoDEV;

DROP TABLE IF EXISTS chamado;
CREATE TABLE chamado(
id 					INT AUTO_INCREMENT PRIMARY KEY,
id_usuario 			INT NOT NULL,
titulo 				VARCHAR(100),
descricao 			VARCHAR(500) NOT NULL,
status_chamado		INT NOT NULL
);