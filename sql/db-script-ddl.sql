DROP SCHEMA BEIBE CASCADE;
CREATE SCHEMA BEIBE;

USE BEIBE;

CREATE TABLE tipo (id INT PRIMARY KEY, nome VARCHAR(100));

INSERT INTO tipo VALUES (1, 'Cliente'), (2, 'Funcionario'), (3, 'Gerente');


CREATE TABLE endereco
(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	rua VARCHAR(100),
	numero BIGINT,
	complemento VARCHAR(100),
	bairro VARCHAR(100),
	cep VARCHAR(8),
	cidade VARCHAR(100),
	estado VARCHAR(100)
);

CREATE TABLE usuario (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100),
	cpf VARCHAR(11) UNIQUE,
	email VARCHAR(100) UNIQUE,
	telefone VARCHAR(9),
	senha VARCHAR(255),
	tipo INT,
	endereco BIGINT,
	FOREIGN KEY (tipo) REFERENCES tipo(id),
	FOREIGN KEY (endereco ) REFERENCES endereco (id)


);