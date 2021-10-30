-- Tabelas Trabalho 1 Base de Dados

CREATE TABLE Country(
  	Name VARCHAR(50) NOT NULL UNIQUE,
 	Code VARCHAR(5) CONSTRAINT CountryKey PRIMARY KEY,
 	Capital VARCHAR(50),
 	Province VARCHAR(50),
 	Population DECIMAL CONSTRAINT CountryPop
   	CHECK (Population >= 0)
);

CREATE TABLE Language(
  	Country VARCHAR(5),
 	Name VARCHAR(50),
 	Percentage DECIMAL CONSTRAINT LanguagePercent 
   	CHECK ((Percentage > 0) AND (Percentage <= 100)),
 	CONSTRAINT LanguageKey PRIMARY KEY (Name, Country)
);
CREATE TABLE Religin (
  	Country VARCHAR(5),
 	Name VARCHAR(50),
 	Percentage DECIMAL CONSTRAINT ReligionPercent 
   	CHECK ((Percentage > 0) AND (Percentage <= 100)),
 	CONSTRAINT ReligionKey PRIMARY KEY (Name, Country)
); 
create table Borders(
    Country1 varchar(5),
    country2 varchar(5),
   	Length DECIMAL 
    CHECK (Length > 0),
   	CONSTRAINT BorderKey PRIMARY KEY (Country1,Country2) 
);
CREATE TABLE Continent(
  NAME VARCHAR(50) CONSTRAINT ContinentKey primary key,
 Area DECIMAL(10)
);
 create table Encompasses(
   	country varchar(5),
   	continent varchar(50),
   	Percentage DECIMAL CONSTRAINT ContinentPercent
   	CHECK ((Percentage > 0) AND (Percentage <= 100)),
 	constraint EncodeKey primary key (country, continent)
 );
 create table Economy(
 	country varchar(5),
   	GDP decimal(9),
   	agriculture decimal,
   	check((agriculture>=0)and(agriculture<=100)),
   	industry decimal,
   	check((industry>=0)and(industry<=100)),
   	inflation decimal,
   	uneployment decimal,
   	check((uneployment>=0)and(uneployment<=100)),
   	constraint economyKey primary key (country)
 );
 create table Organization(
   	name varchar(100),
   	abreviation varchar(30),
   	city varchar(50),
   	country varchar(5),
   	province varchar(100),
   	CONSTRAINT OrganizationKey PRIMARY key (name,country)
);
create table isMember(
	organization varchar(30),
  	country varchar(5),
  	type varchar(100),
  	constraint memberKey primary Key(organization)
);
   
   
                                                      
