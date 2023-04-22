CREATE TABLE Categorias (
    codigo smallint PRIMARY KEY NOT NULL, /*Botei NOT NULL aqui para evitar erros!*/
    nome VARCHAR(50) DEFAULT 'Sem nome.',
    descricao VARCHAR(100) DEFAULT 'Sem descrição.'
);

CREATE TABLE Produtos (
    codigo INT PRIMARY KEY NOT NULL,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(100) DEFAULT 'Sem descrição.',
    quantidade INT DEFAULT 0,
    data_fabricacao DATE DEFAULT NULL,
    valor_unit DECIMAL(10,2) DEFAULT 0,
    fk_categoria smallint NOT NULL,
    FOREIGN KEY (fk_categoria)
        REFERENCES Categorias (codigo)
        ON DELETE RESTRICT
);

CREATE TABLE Clientes (
    codigo INT PRIMARY KEY NOT NULL,
    nome_completo VARCHAR(80) NOT NULL,
    nome_usuario VARCHAR(25) UNIQUE NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    data_nascimento DATE,
    endereco VARCHAR(120)
);

CREATE TABLE Pedidos (
    codigo INT PRIMARY KEY NOT NULL,
	fk_produto INT,
    FOREIGN KEY (fk_produto)
        REFERENCES Produtos (codigo)
        ON DELETE RESTRICT,
    pedido_data DATE DEFAULT '00-00-00',
    quantidade INT DEFAULT 1,
    fk_cliente INT,
    FOREIGN KEY (fk_cliente)
        REFERENCES Clientes (codigo)
        ON DELETE RESTRICT
);

CREATE TABLE Funcionarios (
    codigo INT PRIMARY KEY NOT NULL,
    nome VARCHAR(50) DEFAULT 'Sem nome.',
    cpf VARCHAR(14) UNIQUE NOT NULL
);