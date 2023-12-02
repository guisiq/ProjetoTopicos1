-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

--INSERT ESTADOS
INSERT INTO estado (nome, sigla)
VALUES
  ('Acre', 'AC'),
  ('Alagoas', 'AL'),
  ('Amapá', 'AP'),
  ('Amazonas', 'AM'),
  ('Bahia', 'BA'),
  ('Ceará', 'CE'),
  ('Distrito Federal', 'DF'),
  ('Espírito Santo', 'ES'),
  ('Goiás', 'GO'),
  ('Maranhão', 'MA'),
  ('Mato Grosso', 'MT'),
  ('Mato Grosso do Sul', 'MS'),
  ('Minas Gerais', 'MG'),
  ('Pará', 'PA'),
  ('Paraíba', 'PB'),
  ('Paraná', 'PR'),
  ('Pernambuco', 'PE'),
  ('Piauí', 'PI'),
  ('Rio de Janeiro', 'RJ'),
  ('Rio Grande do Norte', 'RN'),
  ('Rio Grande do Sul', 'RS'),
  ('Rondônia', 'RO'),
  ('Roraima', 'RR'),
  ('Santa Catarina', 'SC'),
  ('São Paulo', 'SP'),
  ('Sergipe', 'SE'),
  ('Tocantins', 'TO');

-- INSERT CIDADES
INSERT INTO cidade (nome, id_estado) VALUES
  ('Rio Branco', 1),
  ('Macapá', 2),
  ('Maceió', 3),
  ('Manaus', 4),
  ('Salvador', 5),
  ('Fortaleza', 6),
  ('Brasília', 7),
  ('Vitória', 8),
  ('Goiânia', 9),
  ('São Luís', 10),
  ('Cuiabá', 11),
  ('Campo Grande', 12),
  ('Belo Horizonte', 13),
  ('Belém', 14),
  ('João Pessoa', 15),
  ('Curitiba', 16),
  ('Recife', 17),
  ('Teresina', 18),
  ('Rio de Janeiro', 19),
  ('Natal', 20),
  ('Porto Alegre', 21),
  ('Porto Velho', 22),
  ('Boa Vista', 23),
  ('Florianópolis', 24),
  ('São Paulo', 25),
  ('Aracaju', 26),
  ('Palmas', 27);


--INSERT DOS ENDERECOS
INSERT INTO public.endereco (cidade_id, bairro, lote, quadra, rua)
VALUES 
  (27, 'Plano diretor Sul', 10, '403Sul', 11),
  (27, 'Plano diretor Norte', 11, '110Norte', 12),
  (27, 'Aureny I', 12, 'Taquaralto', 13),
  (27, 'Aureny II', 13, 'Taquaralto', 14),
  (27, 'Aureny III', 14, 'Taquaralto', 15),
  (25, 'Zona Leste', 15, 'Av. Paulista', 16),
  (25, 'Zona Sul', 16, 'Rua Oscar Freire', 17),
  (25, 'Zona Norte', 17, 'Av. Tiradentes', 18),
  (25, 'Zona Oeste', 18, 'Rua Augusta', 19),
  (1, 'Dinossauro', 01, 'Era', 10);


--INSERT USUARIOS
  INSERT INTO usuario(login, senha, perfil) VALUES --SENHA: "1234"
	( 'mariasilva', 'O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==',2),
	( 'joao.oliveira', 'O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==',2),
	( 'amanda.costa', 'O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==',1),
	( 'pedro.santos', 'O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==',2),
	( 'luana.almeida', 'O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==',1),
	( 'carlos.ferreira', 'O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==',2),
	( 'laura.oliveira', 'O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==',1),
	( 'ricardo.costa', 'O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==',2),
	( 'fernanda.santos', 'O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==',1),
	( 'aline.almeida', 'O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA==',2);


--INSERT PESSOAS
INSERT INTO public.pessoa (data_nascimento, id_endereco, id_usuario, cpf, nome)
VALUES
  ('2000-03-15', 1, 1, '123.456.789-01', 'Maria Silva'),
  ('1995-07-20', 2, 2, '987.654.321-00', 'João Oliveira'),
  ('1988-10-05', 3, 3, '111.222.333-44', 'Amanda Costa'),
  ('1980-12-25', 4, 4, '555.888.999-00', 'Pedro Santos'),
  ('1992-04-18', 5, 5, '777.666.555-44', 'Luana Almeida'),
  ('1990-11-08', 6, 6, '111.222.333-55', 'Carlos Ferreira'),
  ('1985-06-02', 7, 7, '444.555.666-77', 'Laura Oliveira'),
  ('1997-09-12', 8, 8, '888.777.666-11', 'Ricardo Costa'),
  ('1975-08-22', 9, 9, '333.222.111-44', 'Fernanda Santos'),
  ('1994-07-01', 10, 10, '999.888.777-22', 'Aline Almeida');


--INSERT TELEFONES
INSERT INTO public.telefone (id_pessoa, codigoarea, numero)
VALUES 
  (1, 63, '99455-4568'),
  (2, 81, '98765-4321'),
  (3, 55, '99888-7766'),
  (4, 11, '91234-5678'),
  (5, 47, '96666-7777'),
  (6, 21, '95555-1234'),
  (7, 42, '93333-8888'),
  (8, 31, '90000-1111'),
  (9, 48, '97777-5555'),
  (10, 84, '98888-2222');



  --Insert de produto

        INSERT INTO public.produto (preco, quantestoque, nome, tipo)
VALUES 
    (100, 10, 'trembo', 'Bomba'),
    (80, 5, 'bicicleta', 'Equipamento'),
    (25, 15, 'halteres', 'Acessório'),
    (50, 8, 'esteira', 'Equipamento'),
    (15, 20, 'luvas', 'Acessório'),
    (200, 3, 'máquina de musculação', 'Equipamento'),
    (30, 12, 'corda de pular', 'Acessório'),
    (120, 6, 'esteira elétrica', 'Equipamento'),
    (10, 25, 'toalha de academia', 'Acessório'),
    (90, 7, 'elíptico', 'Equipamento');

--------------------------------------------------------------------------------

--Insert de cartao


INSERT INTO public.cartao (bandeiracartao, cvc, datavalidade, nome, numero)
VALUES
    (1, 123, '12/10/2027', 'João', 123456879123),
    (2, 456, '05/08/2026', 'Maria', 987654321987),
    (3, 789, '09/11/2027', 'Pedro', 654321789654),
    (4, 321, '03/05/2026', 'Ana', 789654321123),
    (1, 654, '08/12/2025', 'Carlos', 987123456321),
    (1, 987, '01/07/2028', 'Sofia', 147258369456),
    (2, 159, '06/04/2027', 'Lucas', 963852741369),
    (3, 753, '11/09/2026', 'Laura', 258369147852),
    (4, 852, '02/03/2028', 'Gustavo', 369741258963),
    (1, 246, '07/01/2027', 'Isabella', 654789321456);

    --------------------------------------------------------------------------------

--Insert de itens de pedido

INSERT INTO public.itempedido(preco, quantidade, id, id_pedido, id_prduto) VALUES 
 (15.99, 3, 1, 101, 201);
 (25.50, 2, 2, 102, 202);
 (8.75, 1, 3, 103, 203);
 (50.00, 4, 4, 104, 204);
 (12.49, 2, 5, 105, 205);
 (30.75, 3, 6, 106, 206);
 (18.99, 2, 7, 107, 207);
 (22.50, 1, 8, 108, 208);
 (5.99, 4, 9, 109, 209);
 (40.00, 3, 10, 110, 210);

    --------------------------------------------------------------------------------

--Insert de lista de pedidos de pedido

INSERT INTO public.pedido(totalpedido, datahora, id, id_usuario) VALUES (150.99, '2023-01-15 08:30:00', 1, 101);
INSERT INTO public.pedido(totalpedido, datahora, id, id_usuario) VALUES (220.50, '2023-02-05 12:15:00', 2, 102);
INSERT INTO public.pedido(totalpedido, datahora, id, id_usuario) VALUES (80.75, '2023-03-10 16:45:00', 3, 103);
INSERT INTO public.pedido(totalpedido, datahora, id, id_usuario) VALUES (350.00, '2023-04-22 09:20:00', 4, 104);
INSERT INTO public.pedido(totalpedido, datahora, id, id_usuario) VALUES (98.49, '2023-05-08 14:00:00', 5, 105);
INSERT INTO public.pedido(totalpedido, datahora, id, id_usuario) VALUES (180.75, '2023-06-17 18:30:00', 6, 106);
INSERT INTO public.pedido(totalpedido, datahora, id, id_usuario) VALUES (120.99, '2023-07-25 10:10:00', 7, 107);
INSERT INTO public.pedido(totalpedido, datahora, id, id_usuario) VALUES (90.50, '2023-08-14 20:45:00', 8, 108);
INSERT INTO public.pedido(totalpedido, datahora, id, id_usuario) VALUES (45.99, '2023-09-03 15:05:00', 9, 109);
INSERT INTO public.pedido(totalpedido, datahora, id, id_usuario) VALUES (280.00, '2023-10-12 11:40:00', 10, 110);
