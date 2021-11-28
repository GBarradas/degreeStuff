--TABELAS Base de Dados(Trabalho1)
Create Table country(
    name VARCHAR(50) NOT NULL UNIQUE,
    code VARCHAR(5) PRIMARY KEY,
    capital VARCHAR(50),
    province VARCHAR(50),
    population DECIMAL ,
    CHECK(population>=0),
);

CREATE TABLE language(
    code VARCHAR(5),
    name VARCHAR(50),
    percentage DECIMAL,
    CHECK(percentage>=0) AND (percentage<=100),
);

CREATE TABLE religion(
    code VARCHAR(5),
    name VARCHAR(50),
    percentage DECIMAL,
    CHECK(percentage>=0) AND (percentage<=100),
);

CREATE TABLE borders(
    country1 VARCHAR(5),
    country2 VARCHAR(5),
    length DECIMAL,
    CHECK (length>0)
);

CREATE TABLE continent(
    name VARCHAR(50),
    area DECIMAL,
    CHECK (area>0),
);

CREATE TABLE encompasse(
    country VARCHAR(50),
    continent VARCHAR(50),
    percentage DECIMAL,
    CHECK (percentage>=0) AND (percentage<=100),

);

CREATE TABLE economy(
    country VARCHAR(5),
    GDP DECIMAL,
    ariculture DECIMAL,
    CHECK (agriculture>=0) AND (agriculture<=100),
    industry DECIMAL,
    CHECK (industry>=0) AND (industry<=100),
    inflation DECIMAL,
    CHECK (inflation>=0) AND (inflation<=100),
    uneployment DECIMAL,
    CHECK (uneployment>=0) AND (uneployment<=100),
);

CREATE TABLE organization(
    name VARCHAR(100),
    abbreviation VARCHAR(20),
    city VARCHAR(50),
    country VARCHAR(5),
    province VARCHAR(50),
    dateOfEsatablisment DATE,
);

CREATE TABLE isMember(
    organization VARCHAR(20),
    country VARCHAR(5),
    type VARCHAR(50),
);
