# Resolução da Pergunta 8
[Pagina Principal](Resolução.md)
> **8.**  Indique os comandos SQL para a criação das tabelas que constituem esta base de dados.  E construa esta base de dados no Postgres.  
  
- **animais**(nome, sexo, registo, local)
``` SQL
DROP TABLE IF EXISTS animais CASCADE;
CREATE TABLE animais(
  nome VARCHAR(100),
  sexo CHAR(10),
  registo DECIMAL PRIMARY KEY,
  local CHAR(5)
);
```  
- **class_biologica**(clase, ordem, familia, especie, registo)
``` SQL
DROP TABLE IF EXISTS class_biologica CASCADE;
CREATE TABLE class_biologica(
  classe VARCHAR(100),
  ordem VARCHAR(100),
  familia VARCHAR(100),
  especie VARCHAR(100),
  registo DECIMAL PRIMARY KEY,
  FOREIGN KEY (registo) REFERENCES animais ON DELETE RESTRICT
);
```  
- **progenitores**(registo_pai, registo_mae, registo, data_nascimento)
``` SQL
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
```  
- **captura**(local_captura, data_captura, idade_estimada, registo)
``` SQL
DROP TABLE IF EXISTS captura CASCADE;
CREATE TABLE captura(
  local_captura VARCHAR(100),
  data_captura DATE,
  idade_esimada DATE,
  registo DECIMAL PRIMARY KEY,
  FOREIGN KEY (registo) REFERENCES animais ON DELETE RESTRICT
);
``` 
- **espaços**(registo_local, area_do_local,meio, temperatura, humadise) 
``` SQL
DROP TABLE IF EXISTS espaços CASCADE;
CREATE TABLE espaços(
  registo_local VARCHAR(5) PRIMARY KEY,
  area_do_local DECIMAL,
  meio VARCHAR(50),
  temperatura VARCHAR(8),
  humidade VARCHAR(8)
);
``` 
- **funcionarios**(nome_funcionario, inicio_funçoes, telefone, telemovel, função, nif)
``` SQL
DROP TABLE IF EXISTS responsavel CASCADE;
CREATE TABLE responsavel(
  nif_responsavel DECIMAL,
  nif DECIMAL,
  PRIMARY KEY (nif_responsavel, nif),
  FOREIGN KEY (nif_responsavel) REFERENCES funcionarios ON DELETE RESTRICT,
  FOREIGN KEY (nif) REFERENCES funcionarios ON DELETE RESTRICT
);
```  
- **responsavel**(nif_responsavel, nif)
``` SQL
DROP TABLE IF EXISTS funcionarios CASCADE;
CREATE TABLE funcionarios(
  nome_funcionario VARCHAR(100),
  inicio_funçoes CHAR(8),
  telefone CHAR(9),
  telemovel CHAR(9),
  funçao VARCHAR(20),
  nif DECIMAL PRIMARY KEY 
);
```  
- **tratadores**(nif_tratador,registo)
``` SQL
DROP TABLE IF EXISTS tratadores CASCADE;
CREATE TABLE tratadores(
  nif_tratador DECIMAL,
  registo DECIMAL PRIMARY KEY,
  FOREIGN KEY (nif_tratador) REFERENCES funcionarios ON DELETE RESTRICT,
  FOREIGN KEY (registo) REFERENCES animais ON DELETE RESTRICT
);
```  
- **tratadores_auxiliares**(nif_auxiliar,registo_local)
``` SQL
DROP TABLE IF EXISTS tratadores_auxiliares CASCADE;
CREATE TABLE tratadores_auxiliares(
  nif_auxiliar DECIMAL,
  registo_local VARCHAR(5),
  PRIMARY KEY(nif_auxiliar, registo_local),
  FOREIGN KEY (nif_auxiliar) REFERENCES funcionarios ON DELETE RESTRICT,
  FOREIGN KEY (registo_local) REFERENCES espaços ON DELETE RESTRICT
);
```  
- **consultas**(nif_vet, registo, data_consulta, diagnostico, local)
``` SQL
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
```