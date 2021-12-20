# Resolução do trabalho de Base  de Dados
>**1.**  Para o problema acima, construa um diagrama Entidade-Relação que descreva a informação.  No diagrama não se esqueça de indicar as restrições das relações e as chaves primárias das entidades.  

[<img src="fotos/er_final.png">](fotos/er_final.png)  


>**2.**  Transforme  o  modelo  E-R  em  tabelas.   Nas  tabelas  não  se  esqueça  deindicar as chaves primárias e as chaves candidatas.  

- **animais**(nome, sexo, registo, local)
- **class_biologica**(clase, ordem, familia, especie, registo)
- **progenitores**(registo_pai, registo_mae, registo, data_nascimento)
- **captura**(local_captura, data_captura, idade_estimada, registo)
- **espaços**(registo_local, area_do_local,meio, temperatura, humadise)
- **funcionarios**(nome_funcionario, inicio_funçoes, telefone, telemovel, função, nif)
- **responsavel**(nif_responsavel, nif)
- **tratadores**(nif_tratador,registo)
- **tratadores_auxiliares**(nif_auxiliar,registo_local)
- **consultas**(nif_vet, registo, data_consulta, diagnostico, local)

>  **3.**  Defina o conjunto de dependências funcionais que a base de dados deve verificar. Exemplo,  as  seguintes  dependências  funcionais  devem-se  verificar  neste domínio:
>- local→tratadorauxiliar 
>- animal→tratador
>- espécie→família
>- família→ordem
>- ordem→classe
  
- nome → sexo
- sexo → registo
- registo → local
- classe → ordem
- ordem → familia
- familia → especie
- especie → registo
- registo_pai → registo_mae
- registo_ mae → registo
- registo → data_nascimento
- local_captura → data_captura
- data_captura → idade_estimada
- idade_estimada → registo
- registo_local → area_do_local
- area_do_local → meio
- meio → temperatura
- temperatura → humidade
- nome_funcionario → inicio_funçoes
- inicio_funçoes → telefone
- telefone → telemovel
- telemovel → função
- função → nif
- nif_responsavel → nif
- nif_tratador → registo
- nif_auxiliar → registo_local
- nif_vet → registo
- registo → data_consulta
- data_consulta → diagnostico
- diagnostico → local


> **4.** Apresente a Base de Dados na forma normal de Boyce Codd, BCNF.

>**5.**  Indique justificando se a sua base de dados tem informação redundante.

>**6.**  Indique  se  a  base  de  dados  que  apresentou  na  forma  normal  de  BoyceCodd preserva as dependências.

>**7.**  Para cada relação da base de dados na BCNF indique as chaves primárias,candidatas e estrangeiras.  

> **8.**  Indique os comandos SQL para a criação das tabelas que constituem esta base de dados.  E construa esta base de dados no Postgres.

[Resolução](Resposta8.md) 
> **9.**  Indique as expressões em SQL para inserir a seguinte informação na suabase de dados e inseria-a.  

[Resolução](Resposta9.md)  
>**10.**  Indique a expressão em SQL para responder às seguintes perguntas (no relatório indique também o resultado;  

[Resolução](Resposta10.md) 