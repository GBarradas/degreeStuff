# Resolução Pergunta 10
[Pagina Principal](Resolução.md)  

>**10.**  Indique a expressão em SQL para responder às seguintes perguntas (no relatório indique também o resultado;  
>
>**a.**  Em que locais do zoo se podem visitar aves? 
``` SQL
SELECT DISTINCT "espaços".registo_local FROM "espaços" 
JOIN animais 
ON animais.local="espaços".registo_local 
NATURAL INNER JOIN class_biologica
WHERE classe LIKE 'aves';
```  
|registo_local|
|-------------|
|A5|  

>**b.**  Em que locais do zoo não há carnívoros?  
``` SQL
SELECT DISTINCT "espaços".registo_local FROM "espaços"
JOIN animais 
ON animais.local="espaços".registo_local 
NATURAL INNER JOIN class_biologica
WHERE ordem NOT LIKE 'carnívoros';
```  
|registo_local|
|-------------|
|A2|
|A5|
|A1|
>**c.**  Indique os irmãos da Kilu.  
``` SQL
SELECT nome FROM animais 
NATURAL INNER JOIN progenitores
WHERE progenitores.registo_mae=(SELECT registo_mae FROM progenitores 
NATURAL INNER JOIN animais
WHERE nome LIKE 'Kilu') OR
progenitores.registo_pai=
(SELECT registo_pai FROM progenitores
NATURAL INNER JOIN animais
WHERE NOME LIKE 'Kilu')
EXCEPT
SELECT nome FROM animais WHERE nome LIKE 'Kilu';
```  
|nome|
|----|
|Kuli|  

>**d.**  Indique os telefones do tratador responsável pela Kata.  
``` SQL
SELECT telemovel,telefone FROM funcionarios 
JOIN  tratadores 
ON funcionarios.nif=tratadores.nif_tratador
JOIN animais
ON animais.registo=tratadores.registo
WHERE animais.nome LIKE 'Kata';
```  
|telemovel|telefone |
|---------|---------|
|919999999|266787809|  

>**e.**  Indique  os  telefones  do  responsável  pelo  auxiliar  responsável  pela local onde está a Kata.  
``` SQL
SELECT telemovel,telefone FROM funcionarios 
JOIN  tratadores_auxiliares
on funcionarios.nif=tratadores_auxiliares.nif_auxiliar
WHERE registo_local LIKE 
(SELECT LOCAL FROM animais WHERE nome like 'Kata');
```  
|telemovel|telefone |
|---------|---------|
|919999996|266878806|
|919999994|266787806|
>**f.**  Indique os tratamentos (data e tratamento) que a Mali já fez no zoo.  
``` SQL
SELECT data_consulta,diagnostico FROM consultas
NATURAL INNER JOIN animais 
 WHERE nome LIKE 'Mali';
```  
|data_consulta|diagnostico|
|-------------|-----------|
|2005-08-12|grávida|
|2005-09-12|cálcio injectado|
|2005-12-12|parto|
|2006-07-12|infecção|
|2006-07-12|antibiótico injectado
>**g.**  Indique os nomes dos veterinários que já diagnosticaram uma gravidez a um carnívoro.  
``` SQL
with carnivoros as (SELECT registo FROM animais
NATURAL INNER JOIN class_biologica
WHERE ordem LIKE 'carnívoros')
Select nome_funcionario from funcionarios
join consultas 
on consultas.nif_vet= funcionarios.nif
join carnivoros
on carnivoros.registo=consultas.registo
where consultas.diagnostico like 'grávida'
```   
|nome_funcionario|
|----------------|
|Pedro Vale|  

>**h.**  Indique  para  cada  família  da  ordem  artiodáctilos  quantos  animais tem o zoo.  
``` SQL
SELECT familia, COUNT(ordem) AS numAnimais
FROM class_biologica
WHERE ordem LIKE 'artiodáctilos'
GROUP BY familia;
```  
|familia|numAnimais|
|-------|----------|
|cervídeos|5|
|hipopótamos|3|
>**i.**  Indique para cada espécie quais os pares de animais que podem ser acasalados,  sabendo  que  não  se  devem  acasalar  pais  com  filhos  ou irmãos.  
``` SQL
```
>**j.**  Qual é a ordem com mais animais no zoo?  
``` SQL
SELECT ordem, COUNT(ordem) AS num
FROM class_biologica
GROUP by ordem
Order by num DESC
LIMIT 1;
```
|ordem|num|
|------|---|
|artiodáctilos|8|  

>**k.**  Qual é  a  ordem  dos  animais  que  têm  mais  de  5  consultas  por  ano(diagnóstico ou tratamento).  
``` SQL
SELECT ordem,COUNT(consultas) 
FROM class_biologica
NATURAL INNER JOIN consultas
GROUP BY ordem
HAVING COUNT(consultas) > 5;
```  
|oredem   |count|
|---------|-----|
|artiodáctilos|12|
|psittaciformes|6|  

>**l.**  Indique o número de animais nascidos em cativeiro.  
``` SQL
SELECT COUNT(progenitores) AS nasCativeiro
FROM progenitores;
```  
|nascativeiro|  
|-|
|10|
>**m.**  Qual é o animal (nome e espécie) mais velho do zoo?  
``` SQL
WITH A AS (SELECT data_nascimento AS dn , registo
FROM progenitores
UNION
SELECT idade_estimada AS dn , registo
FROM captura)

SELECT nome FROM animais
WHERE registo=
(SELECT registo
FROM a
WHERE dn=(SELECT MAX(dn)
FROM a))
```  
|maisVelho|
|---------|
|Rará     |  

>**n.**  Qual é o local húmido com mais mamíferos?  
``` SQL
with mamiferos AS(SELECT registo FROM animais
NATURAL INNER JOIN class_biologica
WHERE classe LIKE 'mamíferos'),
 mamiferosperplace AS(SELECT registo_local, COUNT(animais)AS num
FROM "espaços" JOIN animais
ON "espaços".registo_local=animais.local
JOIN mamiferos
ON animais.registo=mamiferos.registo
WHERE "espaços".humidade LIKE 'húmido'
group by registo_local)

SELECT registo_local FROM "espaços"
WHERE registo_local=
(SELECT registo_local
FROM mamiferosperplace
WHERE num=(SELECT MAX(num)
FROM mamiferosperplace))
```  
|registo_local|
|-------------|
|A3           |
>**o.**  Para  cada  tratador  indique  o  número  de  mamíferos  por  que  é  responsável?  
``` SQL
with mamiferos AS(SELECT registo FROM animais
NATURAL INNER JOIN class_biologica
WHERE classe LIKE 'mamíferos'),
mamiferospertratador AS (SELECT nif_tratador,registo 
FROM tratadores NATURAL inner join mamiferos)
SELECT nome_funcionario, COUNT(mamiferospertratador.nif_tratador)
AS mamifpertrat
FROM funcionarios JOIN mamiferospertratador
ON funcionarios.nif=mamiferospertratador.nif_tratador
GROUP BY nome_funcionario
```  
|nome_funcionario|mamifpertrat|
|----------------|------------|
|Manuel Santos   |8           |
|Joaquim Silva   |7           |

>**p.**  Indique o nome dos animais que já foram tratados por todos os veterinários?  
``` SQL
with veterinarios as (select nif from funcionarios
where funçao like 'Veterinário'),
constPedroVale as (Select registo from consultas
join funcionarios on nif_vet=nif
where nome_funcionario like 'Pedro Vale' ),
constIsabelSoares  as (Select registo from consultas
join funcionarios on nif_vet=nif
where nome_funcionario like 'Isabel Soares' )
select DISTINCT nome from animais 
Natural inner join constPedroVale
NATURAL inner join constIsabelSoares
```  
|nome|
|----|
|Tapi|
|Zula|