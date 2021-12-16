drop table if exists animal cascade;
create table animal(
	nome
  	IdAnimal  primary key;
  	sexo
  	dataNascimento char(8) --AAAAMMDD
);
Drop table if exists classBiologica cascade;
create table classBiologica(
	classe
  	ordem
  	familia
  	especie
  	primary key IdAnimal,
  	FOREIGN key IdAnimal REFERENCES animal on DELETE RESTRICT
  
);
Drop Table if exists captura cascade;
create table captura(
	IdAnimal primary Key,
  	localCaptura
  	dataCaptura
  	FOREIGN key IdAnimal REFERENCES animal on delete RESTRICT
  	
);
drop table if exists progenitores cascade;
create table progenitores(
	IdAnimal primary Key
  	IdMae
  	IdPai
  	foreign key IdAnimal references animal on delete restrict
  	foreign key Idmae references animal on delete restrict
  	foreign key IdPai references animal on delete restrict
  
  	
);
drop table if exists funcionario cascade;
create table funcionario(
  	nome
	IdFuncionario primary key
  	dataInicio
  	telemovel
    telefone
  	cargo
);
drop table if exists responsavel cascade;
create table responsavel(
    idResponsavel
    idFuncionario
    foreign key idResponsavel references funcionario on delete restrict 
    foreign key idFuncionario references funcionario on delete restrict
);
drop table if exists habitat cascade;
create table habitat(
	IdHabitat primary KEY
  	IdAnimal 
  	localização 
    Area 
	temperatura
  	humidade
  	tipoMeio
  	FOREIGN KEY IdAnimal references animal on delete restrict
);
drop table if exists tratadorAnimal cascade;
create Table tratadorAnimal(
    idAnimal
    idFuncionario
    foreign key idAnimal references animal on delete restrict
    foreign key idFuncionario references funcionario on delete restrict
  
);
drop table if exists tratadorAuxiliar cascade;
create table tratadorauxiliar(
	idFuncionario
  	idHabitat
  	foreign key idFuncionario references funcionario on delete restrict
  	foreign key idHabitat references habitat on delete restrict
);
drop table if exists consulta cascade;
create table consulta(
    idVeterinario
    idAnimal
    dataConsulta
    horaConsulta
    localConsulta
    diagonostico
);

