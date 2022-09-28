CREATE TABLE clientes (
	id bigserial NOT NULL,
	endereco_cep varchar(9) NOT NULL,
	endereco_complemento varchar(100) NULL,
	endereco_numero varchar(6) NOT NULL,
	nome varchar(150) NOT NULL,
	CONSTRAINT clientes_pkey PRIMARY KEY (id)
);

CREATE TABLE sacolas (
	id bigserial NOT NULL,
	data_fechamento timestamp NULL,
	fechada bool NOT NULL,
	forma_pagamento varchar(30) NULL,
	valor_total_sacola numeric(19, 2) NOT NULL,
	cliente_id int8 NOT NULL,
	CONSTRAINT sacolas_pkey PRIMARY KEY (id),
	CONSTRAINT sacolas_clientes_fk FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

CREATE TABLE restaurantes (
	id bigserial NOT NULL,
	endereco_cep varchar(9) NOT NULL,
	endereco_complemento varchar(100) NULL,
	endereco_numero varchar(6) NOT NULL,
	nome varchar(150) NOT NULL,
	CONSTRAINT restaurantes_pkey PRIMARY KEY (id)
);

CREATE TABLE produtos (
	id bigserial NOT NULL,
	disponivel bool NOT NULL,
	nome varchar(150) NOT NULL,
	valor_unitario numeric(19, 2) NOT NULL,
	restaurante_id int8 NOT NULL,
	CONSTRAINT produtos_pkey PRIMARY KEY (id),
	CONSTRAINT produtos_restaurantes_fk FOREIGN KEY (restaurante_id) REFERENCES restaurantes(id)
);

CREATE TABLE items (
	id bigserial NOT NULL,
	quantidade int4 NOT NULL,
	produto_id int8 NOT NULL,
	sacola_id int8 NOT NULL,
	CONSTRAINT items_pkey PRIMARY KEY (id),
	CONSTRAINT items_produtos_fk FOREIGN KEY (produto_id) REFERENCES produtos(id),
	CONSTRAINT items_sacolas_fk FOREIGN KEY (sacola_id) REFERENCES sacolas(id)
);
