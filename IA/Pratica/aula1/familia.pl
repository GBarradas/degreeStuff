pessoa(X):- homem(X,_,_); mulher(X,_,_).
homem('Afonso Henriques','rei de Portugal',1109).
homem('Henrique de Borgonha','conde de Portugal',1069).

homem('Sancho I','rei de Portugal',1154).
homem('Fernando II','rei de Leão',1137).
homem('Afonso IX', 'rei de Leão e Castela', 1171).
homem('Afonso II', 'rei de Portugal',1185).

homem('Sancho II', 'rei de Portugal',1207).
homem('Afonso III', 'rei de Portugal',1210).


mulher('Teresa de Castela', 'condessa de Portugal', 1080).
mulher('Mafalda', 'condessa de Saboia', 1125).
mulher('Urraca', 'infanta de Portugal',1151).
mulher('Dulce de Barcelona','infanta de Aragão',1160).
mulher('Berengária', 'infanta de Portugal',1194).
mulher('Urraca C','infanta de Castela',1186).


filho('Afonso Henriques','Henrique de Borgonha').
filho('Afonso Henriques','Teresa de Castela').
filho('Urraca','Afonso Henriques').
filho('Sancho I','Afonso Henriques').
filho('Urraca','Mafalda').
filho('Sancho I','Mafalda').
filho('Afonso IX','Urraca').
filho('Afonso IX','Fernando II').
filho('Afonso II','Sancho I').
filho('Afonso II','Dulce de Barcelona').
filho('Berengária','Sancho I').
filho('Berengária','Dulce de Barcelona').
filho('Sancho II','Afonso II').
filho('Afonso III','Afonso II').
filho('Sancho II','Urraca C').
filho('Afonso III','Urraca C').
primoAll(N1,[L,L1,L2]):-pessoa(N1), findall(P,primo(N1,P),LP),sort(LP,L),
    findall(F,(primo(N1,Pf),filho(F,Pf),F)),sort(F,L1),
    findall(Pp,(filho(N1,P),primo(P,Pp)),PP),sort(PP,L2).
primo(N1,N2) :- filho(N1,P1), filho(N2,P2), irmao(P1,P2).
irmao(N1,L1):- pessoa(N1),findall(X, irmaoN(N1,X),L),sort(L,L1).
irmaoN(N1,N2) :- filho(N1, P), filho(N2,P),N1\=N2.
primoAll(N1,[L,L1,L2]):-pessoa(N1), findall(P,primo(N1,P),LP),sort(LP,L),
    findall(F,(primo(N1,Pf),filho(F,Pf),F)),sort(F,L1),
    findall(Pp,(filho(N1,P),primo(P,Pp)),PP),sort(PP,L2).

esposa(M,H) :- mulher(M,_,_), homem(H,_,_), filho(F,M), filho(F,M).

