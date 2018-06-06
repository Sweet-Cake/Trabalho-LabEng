CREATE DATABASE eletrotec;
use eletrotec;

CREATE TABLE IF NOT EXISTS utensilio(
	id INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(30),
    quant INT,
    preco_uni DECIMAL(7,2),
    PRIMARY KEY (id)
);
select * from produto;

CREATE TABLE IF NOT EXISTS produto(
	id INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50),
    marca VARCHAR(50),
    preco_uni DECIMAL(7,2),
    tipo VARCHAR(20),
    polegada INT,
    PRIMARY KEY (id)
);

create table pedido(
	id INT NOT NULL auto_increment,
    estado VARCHAR(20),
    cpf VARCHAR(20),
    id_produto INT,
    qtd_produto INT,
    precop DECIMAL(7,2),
    id_utensilio INT,
    qtd_utensilio INT,
    precou DECIMAL(7,2),
    precoFinal 	DECIMAL(7,2),
    foreign key(cpf) REFERENCES cliente(cpf),
     foreign key(id_produto) REFERENCES produto(id),
      foreign key(id_utensilio) REFERENCES utensilio(id),
      primary key(id,cpf)
);
create table pedidos(
	id INT NOT NULL auto_increment,
    estado VARCHAR(20),
    cpf VARCHAR(20),
    precoFinal 	DECIMAL(7,2),
    foreign key(cpf) REFERENCES cliente(cpf),
      primary key(id)
);

create table produtopedido(
	id_pedido INT,
    id_produto INT,
    qtd_produto INT,
    precop DECIMAL(7,2),
    foreign key(id_pedido) REFERENCES pedidos(id),
     foreign key(id_produto) REFERENCES produto(id),
      primary key(id_pedido,id_produto)
);

create table utensiliopedido(
	id_pedido INT,
    id_utensilio INT,
    qtd_utensilio INT,
    precou DECIMAL(7,2),
    foreign key(id_pedido) REFERENCES pedidos(id),
     foreign key(id_utensilio) REFERENCES utensilio(id),
      primary key(id_pedido,id_utensilio)
);


	INSERT INTO pedidos (id ,estado,cpf, precoFinal ) VALUES (1, 'Solicitado', '49444747840', 280)
	INSERT INTO produtopedido (id_pedido ,id_produto,qtd_produto, precop ) VALUES (1, 1, 2, 490)
	INSERT INTO utensiliopedido (id_pedido ,id_utensilio,qtd_utensilio, precou ) VALUES (1, 1, 2, 400)
	
	select * from produtopedido where id_pedido = 1 union all select * from utensiliopedido where id_pedido = 1;
	

CREATE TABLE cliente(
	nome VARCHAR(100),
    cpf VARCHAR(20),
    telefone VARCHAR(12), 
    celular VARCHAR(12),
    logradouro VARCHAR(50), 
    numero INT, 
    bairro VARCHAR(50), 
    cidade VARCHAR (50),
    PRIMARY KEY(cpf)
);

SELECT pedido.id, pedido.estado, pedido.cpf, cliente.nome, produto.nome, pedido.qtd_produto, pedido.precop,
utensilio.nome, pedido.qtd_utensilio, pedido.precou,pedido.precoFinal
FROM pedido
INNER JOIN cliente
ON pedido.cpf=cliente.cpf
INNER JOIN produto
ON pedido.id_produto=produto.id
INNER JOIN utensilio
ON pedido.id_utensilio=utensilio.id
WHERE pedido.id="1"