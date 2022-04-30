
DROP SCHEMA BEIBE CASCADE;
CREATE SCHEMA BEIBE;

USE BEIBE;

CREATE TABLE tipo (id INT PRIMARY KEY, nome VARCHAR(100));

INSERT INTO tipo VALUES (1, 'Cliente'), (2, 'Funcionario'), (3, 'Gerente');

CREATE TABLE Usuario (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100),
	cpf VARCHAR(11) UNIQUE,
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
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100)
);

CREATE TABLE Produto (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100),
	categoria BIGINT,
	descricao VARCHAR(100),
	peso float,
	FOREIGN KEY (categoria) REFERENCES CategoriaProduto(id)
);

CREATE TABLE TipoAtendimento(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100)
);

CREATE TABLE Atendimento(
	CreateDate DATE,
	Cliente BIGINT,
	Situacao VARCHAR(50),
	Produto BIGINT,
	TipoAtendimento BIGINT,
	Descricao VARCHAR(255),
	Solucao VARCHAR(255),
	FOREIGN KEY (TipoAtendimento) REFERENCES TipoAtendimento(id),
	FOREIGN KEY (Produto) REFERENCES Produto(id),
	FOREIGN KEY (Cliente) REFERENCES Usuario(id)
);

