homem(goncalo).
homem(ricardo).
homem(amandio).
homem(acacio).
homem(filipe).
homem(sergio).
homem(tiago).

mulher(silvia).
mulher(catarina).
mulher(antonia).
mulher(angela).
mulher(daniela).
mulher(alice).

progenitor(goncalo, ricardo).
progenitor(goncalo, silvia).
progenitor(silvia, amandio).
progenitor(silvia, antonia).
progenitor(catarina, ricardo).
progenitor(catarina, silvia).
progenitor(angela, amandio).
progenitor(angela, antonia).
progenitor(filipe, amandio).
progenitor(filipe, antonia).
progenitor(daniela,acacio).
progenitor(daniela,angela).
progenitor(tiago,acacio).
progenitor(tiago,angela).
progenitor(filipe, alice).

pai(X,Y) :- homem(Y), progenitor(X,Y).
mae(X,Y) :- mulher(Y), progenitor(X,Y).
irmao(X,Y) :- /*homem(X),*/ pai(X,A),pai(Y,A), mae(X,B) , mae(Y,B), Y \= X.
irma(X,Y) :- mulher(X), pai(X,A),pai(Y,A), mae(X,B) , mae(Y,B), X \= Y.
avos(X,Y) :- progenitor(X,A),progenitor(A,Y) .
tio(X,Y) :- homem(Y), irmao(Y,B), (pai(X,B); mae(X,B)). 
tia(X,Y) :- mulher(Y), irma(Y,B), (pai(X,B); mae(X,B)). 
primo(X,Y) :- /*homem(Y),*/ irmao(A,B), progenitor(X,A), progenitor(Y,B), X \==Y.
desce(X,Y):- progenitor(X,Y).
desc2(X,Y):- progenitor(X,A), desce(A,Y).
%antep(X,Y):- 
%ir2ma(X,Y):- 