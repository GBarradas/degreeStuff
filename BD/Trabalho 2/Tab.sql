drop table if exists animais cascade;
create table animais(
  nome VARCHAR(100),
  sexo varchar(10),
  data_nascimento DATE,
  registo DECIMAL PRIMARY key
  
);
drop table if exists class_biologica cascade;
create table class_biologica(
  classe varchar(100),
  ordem varchar(100),
  familia VARCHAR(100),
  especie varchar(100),
  registo DECIMAL PRIMARY key,
  foreign key (registo) REFERENCES animais on delete RESTRICT
);
drop table if exists progenitores cascade;
create table progenitores(
  registo_pai decimal,
  registo_mae decimal,
  registo DECIMAL PRIMARY key,
  foreign key (registo) REFERENCES animais on delete RESTRICT,
  foreign key (registo_pai) REFERENCES animais on delete RESTRICT,
  foreign key (registo_mae) REFERENCES animais on delete RESTRICT
);
drop table if exists captura cascade;
create table captura(
  local_captura varchar(100),
  data_captura DATE,
  idade_esimada DECIMAL,
  registo DECIMAL PRIMARY key,
  FOREIGN key (registo) REFERENCES animais on DELETE RESTRICT
);
drop table if exists espaços cascade;
create table espaços(
  registo_local varchar(5) primary key,
  area_do_local decimal,
  temperatura varchar(8),
  humidade varchar(8)
);
drop table if exists habitat cascade;
create table habitat(
  registo Decimal primary key,
  registo_local varchar(5),
  foreign key (registo) references animais on delete RESTRICT,
  foreign key (registo_local) references espaços on delete RESTRICT  
);
drop table if exists funcionarios cascade;
create table funcionarios(
  nome_funcionario varchar(100),
  inicio_funçoes char(8),
  telefone char(9),
  telemovel char(9),
  funçao varchar(20),
  nif DECIMAL PRIMARY key 
);
drop table if exists responsavel cascade;
CREATE table responsavel(
  nif_responsavel decimal,
  nif DECIMAL,
  primary key (nif_responsavel, nif),
  FOREIGN key (nif_responsavel) references funcionarios on DELETE RESTRICT,
  FOREIGN key (nif) references funcionarios on DELETE RESTRICT
);
drop table if exists tratadores cascade;
create table tratadores(
  nif_tratador decimal,
  registo DECIMAL primary key,
  FOREIGN key (nif_tratador) REFERENCES funcionarios on DELETE RESTRICT,
  FOREIGN key (registo) REFERENCES animais on DELETE RESTRICT
);
drop table if exists tratadores_auxiliares cascade;
create table tratadores_auxiliares(
  nif_auxiliar decimal,
  registo_local varchar(5) primary key,
  FOREIGN key (nif_auxiliar) references funcionarios on DELETE RESTRICT,
  FOREIGN key (registo_local) REFERENCES espaços on DELETE RESTRICT
);
drop table if exists veterinarios cascade;
create table veterinarios(
  nif_vet decimal,
  registo decimal,
  data_hora date,
  diagnostico varchar(100),
  local varchar(5),
  primary key (nif_vet, registo),
  foreign key (nif_vet) REFERENCES funcionarios on DELETE RESTRICT,
  FOREIGN key (registo) REFERENCES animais on DELETE RESTRICT,
  foreign key (local) REFERENCES espaços on delete RESTRICT
);