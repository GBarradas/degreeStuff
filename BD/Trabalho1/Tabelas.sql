-- Tabelas Trabalho 1 Base de Dados

CREATE TABLE Country(
  	Name VARCHAR(50) NOT NULL UNIQUE,
 	Code VARCHAR(5) CONSTRAINT CountryKey PRIMARY KEY,
 	Capital VARCHAR(50),
 	Province VARCHAR(50),
 	Area DECIMAL CONSTRAINT CountryArea
   	CHECK (Area >= 0),
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
 create table Organization(
   	name varchar(100),
   abreviation varchar(30),
   city varchar(50),
   county varchar(5),
   province varchar(100),
   dateOfEstablisment date,
   CONSTRAINT OrganizationKey PRIMARY key (name,country)
);
   
   
   
                                                      

