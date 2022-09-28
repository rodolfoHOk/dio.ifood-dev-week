INSERT INTO restaurantes (id, nome, endereco_cep, endereco_numero, endereco_complemento) VALUES
(1, 'Restaurante 1', '12345-101', '1234', null),
(2, 'Restaurante 2', '12345-201', '567', '10 Andar');

INSERT INTO clientes (id, nome, endereco_cep, endereco_numero, endereco_complemento) VALUES
(1, 'Cliente 1', '12345-302', '901', 'Bloco A Apto 501');

INSERT INTO produtos (id, nome, valor_unitario, disponivel, restaurante_id) VALUES
(1, 'Produto 1', 15.00, true, 1),
(2, 'Produto 2', 18.00, true, 1),
(3, 'Produto 3', 21.00, true, 2);

INSERT INTO sacolas (id, cliente_id, valor_total_sacola, forma_pagamento, fechada) VALUES
(1, 1, 0.00, 'DINHEIRO', false);
