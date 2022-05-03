
DROP SCHEMA BEIBE CASCADE;
CREATE SCHEMA BEIBE;

USE BEIBE;

CREATE TABLE tipo (id INT PRIMARY KEY, nome VARCHAR(100));

INSERT INTO tipo VALUES (1, 'Cliente'), (2, 'Funcionario'), (3, 'Gerente');

CREATE TABLE Usuario (
	cpf VARCHAR(11) PRIMARY KEY,
	nome VARCHAR(100),
	email VARCHAR(100) UNIQUE,
	telefone VARCHAR(9),
	senha VARCHAR(255),
	tipo INT,
	rua VARCHAR(100),
	numero BIGINT,
	complemento VARCHAR(100),
	bairro VARCHAR(100),
	cep VARCHAR(8),
	cidade VARCHAR(100),
	estado VARCHAR(100),
	FOREIGN KEY (tipo) REFERENCES tipo(id)
);

CREATE TABLE CategoriaProduto (
	nome VARCHAR(100) PRIMARY KEY
);

CREATE TABLE Produto (
	nome VARCHAR(100) PRIMARY KEY,
	categoria VARCHAR(100),
	descricao VARCHAR(100),
	peso float,
	FOREIGN KEY (categoria) REFERENCES CategoriaProduto(nome)
);

CREATE TABLE TipoAtendimento(
	nome VARCHAR(100) PRIMARY KEY
);

CREATE TABLE Atendimento( 
	id BIGINT AUTO_INCREMENT PRIMARY KEY, 
	CreateDate TIMESTAMP,
	Cliente VARCHAR(11),
	Situacao VARCHAR(50),
	Produto VARCHAR(100),
	TipoAtendimento VARCHAR(100),
	Descricao VARCHAR(255),
	Solucao VARCHAR(255),
	FOREIGN KEY (TipoAtendimento) REFERENCES TipoAtendimento(nome),
	FOREIGN KEY (Produto) REFERENCES Produto(nome),
	FOREIGN KEY (Cliente) REFERENCES Usuario(cpf)
);

INSERT INTO TipoAtendimento VALUES ('Reclamacao'),('Sugestao');

