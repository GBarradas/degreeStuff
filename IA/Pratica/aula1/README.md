# Aula Pratica 1  
##### *Inteligência Artificial* | **Data:** 13/02/2023; **Hora**:14:00; **Duração**: 2h; **Sala**:CLAV_137;**Docente**: [Irene Pimenta](../../#docentes)  
### [Pagina Principal](../../)  

Exercícios de programação em lógica
1. Dada uma base de dados com os seguintes predicados (ver p1.pl):
- homem(nome, profissão, data de nascimento)
- mulher(nome, profissão, data de nascimento)
- filho(nome,nomeDoPaiOuDaMae)
2. Defina o predicado: irmao(nome1,nome2)
Tenha em conta que uma pessoa não é irmã de si mesma.  
``` prolog
irmao(N1,N2) :- filho(N1, P), filho(N2,P),N1\=N2.
```
3. Defina o predicado: primoDireito(nome1,nome2)
Primos direitos são os filhos dos irmãos do pai ou da mãe.
``` prolog
primo(N1,N2) :- filho(N1,P1), filho(N2,P2), irmao(P1,P2). 
```
4. Defina o predicado: irmãos(nome1,-[nome*])
Dado um nome nome1 deve construir uma lista com todos os irmãos de
nome1. (sugestão: use o predicado findall)
``` prolog
pessoa(X):- homem(X,_,_); mulher(X,_,_).
irmao(N1,L1):- pessoa(N1),findall(X, irmaoN(N1,X),L),sort(L,L1).
irmaoN(N1,N2) :- filho(N1, P), filho(N2,P),N1\=N2.   
```
5. Defina o predicado: primos(nome1,-[nome*])
Primos são: os primos direitos, os filhos dos primos e os primos dos pais.
``` prolog
primoAll(N1,[L,L1,L2]):-pessoa(N1), findall(P,primo(N1,P),LP),sort(LP,L),
    findall(F,(primo(N1,Pf),filho(F,Pf),F)),sort(F,L1),
    findall(Pp,(filho(N1,P),primo(P,Pp)),PP),sort(PP,L2).    
```
6. Defina o predicado: esposa(nomeMulher,nomeHomem)
Considere que esposa de um homem é uma mulher que é mãe do filho do
homem.
``` prolog
esposa(M,H) :- mulher(M,_,_), homem(H,_,_), filho(F,M), filho(F,M).    
```
7. Defina o predicado: descende(nome, -[ascendentes])
Dado um nome deve construir uma lista com todos os ascendentes na base
de dados, pais, avós, bisavós, etc.
``` prolog
    
```
8. Defina o predicado: descendentes(nome, -[descendentes])
Dado um nome deve construir uma lista com todos os descendentes, filhos,
netos, bisnetos, etc.
``` prolog
    
```
9. Defina o predicado: ascendentes(nome, c(Nome,AscendentesPai,AscendentesMae))
ex:
``` prolog
ascendentes(’Sancho II’,L).
L = c(’Sancho II’,
c(’Afonso II’,
c(’Sancho I’,
c(’Afonso Henriques’,
c(’Henrique de Borgonha’,0,0),
c(’Teresa de Castela’,0,0)),
c(’Mafalda’,0,0)),
c(’Dulce de Barcelona’,0,0)),
c(’Urraca C’,0,0)) 
```  

``` prolog
    
```
10. Defina o predicado: descendentes(Nome, c(Nome, NomeEsposa, -[DescendentesFilho*])).
ex:
``` prolog
descendentes(’Afonso Henriques’,L).
L = c(’Afonso Henriques’,’Mafalda’,
[c(’Fernando II’,’Urraca’,[c(’Afonso IX’,0,[])]),
c(’Sancho I’,’Dulce de Barcelona’,
[c(’Afonso II’,’Urraca C’,
[c(’Sancho II’,0,[]),c(’Afonso III’,0,[])]),
c(0,’Berengária’,[])])])
```  

``` prolog
    
```
11. Defina o predicado: descendentesNivel(Nome, Nivel, [Nomes])
Se Nível igual a 1 lista os filhos
Se Nível igual a 2 lista os netos
Se Nível igual a 3 lista os bisnetos
etc.
Deve utilizar o predicado já definido descendentes.
``` prolog
    
```
12. Defina o predicado: ascendentesNivel(Nome, Nível, [Nomes])
``` prolog
    
```
13. Defina o predicado: ordenaNomesAlf(+lista,-listaordenada)
Que dada uma lista de nomes constrói uma lista com os nomes ordenados
por ordem alfabética crescente.
Use o insertion sort.
``` prolog
    
```
14. Defina o predicado: ordenaNomesIdade(+lista,-listaordenada)
Que dada uma lista de nomes constrói uma lista com os nomes ordenados
por ordem de nascimento crescente.
Use o merge sort.
``` prolog
    
```
15. Complete a base de dados incluindo informação até ao fim da primeira
dinastia D João I, mestre de Aviz.
``` prolog
    
```
16. Defina o predicado troca(+lista,p1,p2,-listaTrocada que dada uma lista,
constroi a listaTrocada que tem os mesmo elementos da lista excepto os
elemento que estão nas posiç˜oes p1 e p2 que devem trocar de posição.  
``` prolog
    
```