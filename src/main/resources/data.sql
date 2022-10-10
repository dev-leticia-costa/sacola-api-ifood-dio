INSERT INTO restaurant (id, cep, additional_information, nome) VALUES
(1L, '0000001', 'Complemento Endereço Restaurante 1', 'Restaurante JavaLanches'),
(2L, '0000002', 'Complemento Endereço Restaurante 2', 'Restaurante Consuma API');

INSERT INTO customer (id, cep, additional_information, name) VALUES
(1L, '0000001', 'Complemento Endereço Cliente 1', 'Cliente 1');

INSERT INTO product (id, isavailable, name, unity_value, restaurante_id) VALUES
(1L, true, 'Produto 1', 5.0, 1L),
(2L, true, 'Produto 2', 6.0, 1L),
(3L, true, 'Produto 3', 7.0, 2L);

INSERT INTO shopping_bag (id, payment, isclosed, value_total, client_id) VALUES
(1L, 0, false, 0.0, 1L);

