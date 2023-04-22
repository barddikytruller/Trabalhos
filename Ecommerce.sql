CREATE TABLE Categorias (
    codigo smallint PRIMARY KEY,
    nome VARCHAR(50),
    descricao VARCHAR(100)
);

CREATE TABLE Produtos (
    codigo INT PRIMARY KEY,
    nome VARCHAR(50),
    descricao VARCHAR(100),
    quantidade INT,
    data_fabricacao DATE,
    valor_unit DECIMAL(10,2),
    fk_categoria smallint,
    FOREIGN KEY (fk_categoria)
        REFERENCES Categorias (codigo)
        ON DELETE RESTRICT
);

CREATE TABLE Clientes (
    codigo INT PRIMARY KEY,
    nome_completo VARCHAR(80),
    nome_usuario VARCHAR(25),
    email VARCHAR(50) UNIQUE,
    cpf VARCHAR(14) UNIQUE,
    data_nascimento DATE,
    endereco VARCHAR(120)
);

CREATE TABLE Pedidos (
    codigo INT PRIMARY KEY,
	fk_produto INT,
    FOREIGN KEY (fk_produto)
        REFERENCES Produtos (codigo)
        ON DELETE RESTRICT,
    pedido_data DATE,
    quantidade INT,
    fk_cliente INT,
    FOREIGN KEY (fk_cliente)
        REFERENCES Clientes (codigo)
        ON DELETE RESTRICT
);

CREATE TABLE Funcionarios (
    codigo INT PRIMARY KEY,
    nome VARCHAR(50),
    cpf VARCHAR(11) UNIQUE
);