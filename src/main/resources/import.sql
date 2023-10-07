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
  (25, 'Zona Leste', 15, '403Sul', 16),
  (25, 'Zona Sul', 16, '403Sul', 17),
  (25, 'Zona Norte', 17, '403Sul', 18),
  (25, 'Zona Oeste', 18, '403Sul', 19),
  (1, 'Dinossauro', 01, 'Era', 10);



--INSERT USUARIOS
  INSERT INTO public.usuario(login, senha) VALUES 
	( 'pessoa1', '1234'),
	( 'pessoa2', '1234'),
	( 'pessoa3', '1234'),
	( 'pessoa4', '1234'),
	( 'pessoa5', '1234');
	







