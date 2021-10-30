--Tabelas ex2

drop table membro,gostade;
create table membro(
	nome varchar(50) CONSTRAINT membroKey PRIMARY key,
  	email  varchar(50),
  	ano DECIMAL(4)
);
create table gostade(
	nome varchar(50) PRIMARY key,
  	country varchar(50)
);
