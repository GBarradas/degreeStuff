DROP TABLE IF EXISTS animais CASCADE;
CREATE TABLE animais(
  nome VARCHAR(100),
  sexo CHAR(10),
  registo DECIMAL PRIMARY KEY,
  local CHAR(5)
);
-- Inserções dos animais::
--Tigres
INSERT INTO animais VALUES ('Taji', 'masculino', 123456, 'A3');
INSERT INTO animais VALUES ('Malii', 'feminino', 222456, 'A3');
INSERT INTO animais VALUES ('Aka', 'feminino', 322456, 'A3');
INSERT INTO animais VALUES ('TaTa', 'masculino', 422456, 'A4');
INSERT INTO animais VALUES ('Cáta', 'masculino', 432456, 'A5');
INSERT INTO animais VALUES ('Kata', 'feminino', 522456, 'A5');
INSERT INTO animais VALUES ('Mata', 'masculino', 622456, 'A4');
-- Hipopotamos
INSERT INTO animais VALUES ('Hipo', 'masculino', 123444, 'A1');
INSERT INTO animais VALUES ('Tapi', 'feminino', 223444, 'A1');
INSERT INTO animais VALUES ('Hita', 'feminino', 323444, 'A1');
--Veados
INSERT INTO animais VALUES ('Kaki', 'masculino', 123666, 'A2');
INSERT INTO animais VALUES ('Kalu', 'feminino', 223666, 'A2');
INSERT INTO animais VALUES ('Kilu', 'feminino', 323666, 'A2');
INSERT INTO animais VALUES ('Luka', 'feminino', 423666, 'A2');
INSERT INTO animais VALUES ('Kuli', 'masculino', 524666, 'A2');
--Araras
INSERT INTO animais VALUES ('Ará', 'masculino', 123555, 'A5');
INSERT INTO animais VALUES ('Zará', 'masculino', 133555, 'A5');
INSERT INTO animais VALUES ('Rará', 'feminino', 223555, 'A5');
INSERT INTO animais VALUES ('Rara', 'masculino', 323555, 'A5');
INSERT INTO animais VALUES ('Zula', 'feminino', 423555, 'A5');
INSERT INTO animais VALUES ('Zura', 'feminino', 523555, 'A5');

DROP TABLE IF EXISTS class_biologica CASCADE;
CREATE TABLE class_biologica(
  classe VARCHAR(100),
  ordem VARCHAR(100),
  familia VARCHAR(100),
  especie VARCHAR(100),
  registo DECIMAL PRIMARY KEY,
  FOREIGN KEY (registo) REFERENCES animais ON DELETE RESTRICT
);
--Inserção das classes biologicas::
INSERT INTO class_biologica VALUES ('mamíferos', 'carnívoros', 'felinos', 'tigre', 123456);
INSERT INTO class_biologica VALUES ('mamíferos', 'carnívoros', 'felinos', 'tigre', 222456);
INSERT INTO class_biologica VALUES ('mamíferos', 'carnívoros', 'felinos', 'tigre', 322456);
INSERT INTO class_biologica VALUES ('mamíferos', 'carnívoros', 'felinos', 'tigre', 422456);
INSERT INTO class_biologica VALUES ('mamíferos', 'carnívoros', 'felinos', 'tigre', 432456);
INSERT INTO class_biologica VALUES ('mamíferos', 'carnívoros', 'felinos', 'tigre', 522456);
INSERT INTO class_biologica VALUES ('mamíferos', 'carnívoros', 'felinos', 'tigre', 622456);
INSERT INTO class_biologica VALUES ('mamíferos', 'artiodáctilos', 'hipopótamos', 'hipopótamo comum', 123444);
INSERT INTO class_biologica VALUES ('mamíferos', 'artiodáctilos', 'hipopótamos', 'hipopótamo comum', 223444);
INSERT INTO class_biologica VALUES ('mamíferos', 'artiodáctilos', 'hipopótamos', 'hipopótamo comum', 323444);
INSERT INTO class_biologica VALUES ('mamíferos', 'artiodáctilos', 'cervídeos', 'veado', 123666);
INSERT INTO class_biologica VALUES ('mamíferos', 'artiodáctilos', 'cervídeos', 'veado', 223666);
INSERT INTO class_biologica VALUES ('mamíferos', 'artiodáctilos', 'cervídeos', 'veado', 323666);
INSERT INTO class_biologica VALUES ('mamíferos', 'artiodáctilos', 'cervídeos', 'veado', 423666);
INSERT INTO class_biologica VALUES ('mamíferos', 'artiodáctilos', 'cervídeos', 'veado', 524666);
INSERT INTO class_biologica VALUES ('aves', 'psittaciformes', 'psittacidae', 'arara-azul-pequena', 123555);
INSERT INTO class_biologica VALUES ('aves', 'psittaciformes', 'psittacidae', 'arara-azul-pequena', 133555);
INSERT INTO class_biologica VALUES ('aves', 'psittaciformes', 'psittacidae', 'arara-azul-pequena', 223555);
INSERT INTO class_biologica VALUES ('aves', 'psittaciformes', 'psittacidae', 'arara-azul-pequena', 323555);
INSERT INTO class_biologica VALUES ('aves', 'psittaciformes', 'psittacidae', 'arara-azul-pequena', 423555);
INSERT INTO class_biologica VALUES ('aves', 'psittaciformes', 'psittacidae', 'arara-azul-pequena', 523555);

DROP TABLE IF EXISTS progenitores CASCADE;
CREATE TABLE progenitores(
  registo_pai DECIMAL,
  registo_mae DECIMAL,
  registo DECIMAL PRIMARY KEY,
  data_nascimento DATE,
  FOREIGN KEY (registo) REFERENCES animais ON DELETE RESTRICT,
  FOREIGN KEY (registo_pai) REFERENCES animais ON DELETE RESTRICT,
  FOREIGN KEY (registo_mae) REFERENCES animais ON DELETE RESTRICT
);
--Inserção dos nascios em cativeiro::
--Tigre::
INSERT INTO progenitores VALUES (123456, 222456, 322456, '2005/12/12');
INSERT INTO progenitores VALUES (123456, 222456, 422456, '2006/1/20');
INSERT INTO progenitores VALUES (422456, 432456, 522456, '2007/3/2');
INSERT INTO progenitores VALUES (123456, 522456, 622456, '2008/2/2');
--Hipo::
INSERT INTO progenitores VALUES (123444, 223444, 323444, '2006/9/1');
--Veado::
INSERT INTO progenitores VALUES (123666, 223666, 323666, '2008/4/3');
INSERT INTO progenitores VALUES (123666, 423666, 524666, '2008/3/4');
--Araras::
INSERT INTO progenitores VALUES (123555, 223555, 323555, '2009/5/7');
INSERT INTO progenitores VALUES (123555, 223555, 423555, '2009/5/7');
INSERT INTO progenitores VALUES (123555, 223555, 523555, '2009/5/7');

DROP TABLE IF EXISTS captura CASCADE;
CREATE TABLE captura(
  local_captura VARCHAR(100),
  data_captura DATE,
  idade_esimada DATE,
  registo DECIMAL PRIMARY KEY,
  FOREIGN KEY (registo) REFERENCES animais ON DELETE RESTRICT
);
--Inserção de capturas::
--Tigres
INSERT INTO captura VALUES ('India em Agra', '2016/1/1', '2015/1/1', 123456);
INSERT INTO captura VALUES ('India em Deli', '2016/1/1', '2015/1/1', 222456);
INSERT INTO captura VALUES ('India em Calcutá', '2005/1/1', '2004/9/1', 432456);
--Hipo
INSERT INTO captura VALUES ('África em Madagascar', '2004/6/6', '2003/6/6', 123444);
INSERT INTO captura VALUES ('África em Madagascar', '2004/6/6', '2003/12/6', 223444);
--Veados
INSERT INTO captura VALUES ('Europa em Pirenéus', '2018/1/1', '2017/6/1', 123666);
INSERT INTO captura VALUES ('Europa em Ourense', '2018/1/1', '2017/6/1', 223666);
INSERT INTO captura VALUES ('Europa em Gerês', '2019/1/1', '2018/9/1', 423666);
--Araras
INSERT INTO captura VALUES ('América do Sul em Paraná', '2018/1/1', '2017/6/1', 123555);
INSERT INTO captura VALUES ('América do Sul em Paraná', '2018/1/1', '2017/9/1', 133555);
INSERT INTO captura VALUES ('América do Sul em Uruguai', '2019/1/1', '2018/11/1', 223555);

DROP TABLE IF EXISTS espaços CASCADE;
CREATE TABLE espaços(
  registo_local VARCHAR(5) PRIMARY KEY,
  area_do_local DECIMAL,
  meio VARCHAR(50),
  temperatura VARCHAR(8),
  humidade VARCHAR(8)
);
--Inserção dos espaços do zoo::
INSERT INTO espaços VALUES ('A3', 1200, 'terrestre', 'quente', 'húmido');
INSERT INTO espaços VALUES ('A4', 1100, 'terrestre', 'quente', 'húmido');
INSERT INTO espaços VALUES ('A5', 1200, 'terrestre', 'quente', 'húmido');
INSERT INTO espaços VALUES ('A1', 2000, 'misto', 'quente', 'seca');
INSERT INTO espaços VALUES ('A2', 1500, 'terrestre', 'fria', 'seca');

DROP TABLE IF EXISTS funcionarios CASCADE;
CREATE TABLE funcionarios(
  nome_funcionario VARCHAR(100),
  inicio_funçoes CHAR(8),
  telefone CHAR(9),
  telemovel CHAR(9),
  funçao VARCHAR(20),
  nif DECIMAL PRIMARY KEY 
);
--Inserção dos Funcionarios::
--Tratadores
INSERT INTO funcionarios VALUES('Joaquim Silva','2003/2/1',266787809,919999999,'Tratador',123123123);
INSERT INTO funcionarios VALUES('Manuel Santos','2003/4/1',266787808,919999998,'Tratador',123123124);
INSERT INTO funcionarios VALUES('Maria Gomes','2003/1/1',266787807,919999997,'Tratador', 123123125);
--Tratador Auxiliar
INSERT INTO funcionarios VALUES('Mariana Silva','2004/2/1',266878806,919999996,'Tratador Auxiliar',123123126);
INSERT INTO funcionarios VALUES('Jorge Gomes','2004/3/1',266787807,919999995,'Tratador Auxiliar',123123127);
INSERT INTO funcionarios VALUES('Francisco Jorge','2004/3/1',266787806,919999994,'Tratador Auxiliar',123123128);
--Administrativos
INSERT INTO funcionarios VALUES('Manuel Ferreira','2004/2/1',266787806,919999996,'Administrativo',123123129);
INSERT INTO funcionarios VALUES('Manuela Torres','2004/4/1',266787806,919999996,'Administrativo',123123130);
--Veterinários
INSERT INTO funcionarios VALUES('Pedro Vale','2004/5/1',266787816,919999986,'Veterinário',123123131);
INSERT INTO funcionarios VALUES('Isabel Soares','2004/5/1',266787826,919999976,'Veterinário',123123132);

DROP TABLE IF EXISTS responsavel CASCADE;
CREATE TABLE responsavel(
  nif_responsavel DECIMAL,
  nif DECIMAL,
  PRIMARY KEY (nif_responsavel, nif),
  FOREIGN KEY (nif_responsavel) REFERENCES funcionarios ON DELETE RESTRICT,
  FOREIGN KEY (nif) REFERENCES funcionarios ON DELETE RESTRICT
);
--Inserção dos responsáveis::
INSERT INTO responsavel VALUES(123123125,123123123);
INSERT INTO responsavel VALUES(123123125,123123124);
INSERT INTO responsavel VALUES(123123130,123123125);
INSERT INTO responsavel VALUES(123123130,123123126);
INSERT INTO responsavel VALUES(123123130,123123127);
INSERT INTO responsavel VALUES(123123130,123123128);
INSERT INTO responsavel VALUES(123123130,123123129);
INSERT INTO responsavel VALUES(123123129,123123130);
INSERT INTO responsavel VALUES(123123129,123123131);
INSERT INTO responsavel VALUES(123123131,123123132);

DROP TABLE IF EXISTS tratadores CASCADE;
CREATE TABLE tratadores(
  nif_tratador DECIMAL,
  registo DECIMAL PRIMARY KEY,
  FOREIGN KEY (nif_tratador) REFERENCES funcionarios ON DELETE RESTRICT,
  FOREIGN KEY (registo) REFERENCES animais ON DELETE RESTRICT
);
--Inserção dos Tratadores::
INSERT INTO tratadores VALUES(123123123,123456);
INSERT INTO tratadores VALUES(123123123,222456);
INSERT INTO tratadores VALUES(123123123,322456);
INSERT INTO tratadores VALUES(123123123,422456);
INSERT INTO tratadores VALUES(123123123,432456);
INSERT INTO tratadores VALUES(123123123,522456);
INSERT INTO tratadores VALUES(123123123,622456);
INSERT INTO tratadores VALUES(123123124,123444);
INSERT INTO tratadores VALUES(123123124,223444);
INSERT INTO tratadores VALUES(123123124,323444);
INSERT INTO tratadores VALUES(123123124,123666);
INSERT INTO tratadores VALUES(123123124,223666);
INSERT INTO tratadores VALUES(123123124,323666);
INSERT INTO tratadores VALUES(123123124,423666);
INSERT INTO tratadores VALUES(123123124,524666);
INSERT INTO tratadores VALUES(123123125,123555);
INSERT INTO tratadores VALUES(123123125,133555);
INSERT INTO tratadores VALUES(123123125,223555);
INSERT INTO tratadores VALUES(123123125,323555);
INSERT INTO tratadores VALUES(123123125,423555);
INSERT INTO tratadores VALUES(123123125,523555);

DROP TABLE IF EXISTS tratadores_auxiliares CASCADE;
CREATE TABLE tratadores_auxiliares(
  nif_auxiliar DECIMAL,
  registo_local VARCHAR(5),
  PRIMARY KEY(nif_auxiliar, registo_local),
  FOREIGN KEY (nif_auxiliar) REFERENCES funcionarios ON DELETE RESTRICT,
  FOREIGN KEY (registo_local) REFERENCES espaços ON DELETE RESTRICT
);
--Inserção dos Tratadores Auxiliares::
INSERT INTO tratadores_auxiliares VALUES(123123126,'A3');
INSERT INTO tratadores_auxiliares VALUES(123123126,'A4');
INSERT INTO tratadores_auxiliares VALUES(123123126,'A5');
INSERT INTO tratadores_auxiliares VALUES(123123127,'A1');
INSERT INTO tratadores_auxiliares VALUES(123123128,'A2');
INSERT INTO tratadores_auxiliares VALUES(123123128,'A5');

DROP TABLE IF EXISTS consultas CASCADE;
CREATE TABLE consultas(
  nif_vet DECIMAL,
  registo DECIMAL,
  data_hora DATE,
  diagnostico VARCHAR(100),
  local VARCHAR(5),
  FOREIGN KEY (nif_vet) REFERENCES funcionarios ON DELETE RESTRICT,
  FOREIGN KEY (registo) REFERENCES animais ON DELETE RESTRICT,
  FOREIGN KEY (local) REFERENCES espaços ON DELETE RESTRICT
);
--Inserção dos dados das consultas::
INSERT INTO consultas VALUES(123123131,222456,'2005/8/12','grávida','A3');
INSERT INTO consultas VALUES(123123131,222456,'2005/9/12','cálcio injetado','A3');
INSERT INTO consultas VALUES(123123131,222456,'2005/12/12','parto','A3');
INSERT INTO consultas VALUES(123123131,222456,'2006/7/12','infecção','A3');
INSERT INTO consultas VALUES(123123131,222456,'2006/7/12','antibiótico injectado','A3');
INSERT INTO consultas VALUES(123123131,123666,'2009/5/12','infecção','A2');
INSERT INTO consultas VALUES(123123131,123666,'2009/5/12','antibiótico injectado','A2');
INSERT INTO consultas VALUES(123123131,123555,'2009/5/12','infecção','A5');
INSERT INTO consultas VALUES(123123131,123555,'2009/5/12','antibiótico injectado','A5');
INSERT INTO consultas VALUES(123123131,423555,'2009/5/12','infecção','A5');
INSERT INTO consultas VALUES(123123131,423555,'2009/5/12','antibiótico injectado','A5');
INSERT INTO consultas VALUES(123123131,223444,'2007/8/12','infecção','A1');
INSERT INTO consultas VALUES(123123131,223444,'2007/8/12','antibiótico injectado ','A1');
INSERT INTO consultas VALUES(123123132,223444,'2006/7/12','grávida','A1');
INSERT INTO consultas VALUES(123123132,223444,'2006/7/12','cálcio injectado','A1');
INSERT INTO consultas VALUES(123123132,223444,'2006/9/12','parto','A1');
INSERT INTO consultas VALUES(123123132,223444,'2007/7/12','infecção','A1');
INSERT INTO consultas VALUES(123123132,223444,'2007/7/12','antibiótico injectado','A1');
INSERT INTO consultas VALUES(123123132,223444,'2007/7/12','grávida','A1');
INSERT INTO consultas VALUES(123123132,223444,'2007/7/12','cálcio injectado','A1');
INSERT INTO consultas VALUES(123123132,223444,'2007/9/12','parto','A1');
INSERT INTO consultas VALUES(123123132,423555,'2009/6/12','infecção','A5');
INSERT INTO consultas VALUES(123123132,423555,'2009/6/12','antibiótico injectado','A5');