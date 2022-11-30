membro(X, [X|_]).
membro(X, [_|L]) :- membro(X,L).
membro(X,Y) :- catena(_,[X|_], Y).

prefixo([],_).
prefixo([X|A],[X,B]) :- prefixo(A,B).
prefixo(X,Y) :- catena(X,_,Y).

sufixo(A,A).
sufixo(A,[_|B]) :- sufixo(A,B).
sufixo(X,Y) :- catena(_,X,Y).


sublista(S,L) :- prefixo(P,L), sufixo(S,P).
sublista(S,L) :- prefixo(S,L).
sublista(S,[_|L]) :- sublista(S,L).

catena([],L,L).
catena([X|Xs], L, [X|Y]) :- catena(Xs, L, Y).

ultimo(X,Y) :- catena(_, [X],Y).
adjacente(X,Y,Z) :- catena(_,[X,Y|_], Z).

nrev([],[]).
nrev([X|A], B):- nrev(A, AR), catena(AR, [X], B).

compr([],z).
compr([_|T], X) :- compr(T,X).


sel(E, [E|L], L).
sel(E, [X|L],[X|M]) :- sel(E,L,M).

rev(L,R) :- rev(L, [], R).
rev([], R, R).
rev([A|B], X, R) :- rev(B, [A|X],R).

somalista([],0).
somalista([I|Is], S) :- somalista(Is, S0), S is I+S0.

perm([],[]).
perm(L,[X|LP]):- sel(X,L,LX), perm(LX, LP).

seq([]).
seq([_]).
seq([A,B|X]) :- A+1 =:= B, seq([B|X]).
seq(A,B,L):- seq(L), prefixo([A],L), sufixo([B],L).

double([],[]).
double([A|L1],[A,A|L2]) :- double(L1,L2) .

adj(A1,A2, [A1,A2|_]).
adj(A1,A2, [_|L]) :- adj(A1,A2,L).


ord([]). 
ord([_]).
ord([A,B|X]) :- A<B, ord([B|X]).

psort(L,S) :- perm(L,S), ord(S).

isort(I,S) :- isort(I,[],S).
isort([],S,S).
isort([X|Xs],SI, SO) :- insord(X,SI,SX), isort(Xs, SX,SO).

insord(X, [], [X]).
insord(X, [A|As],[X,A|As]) :- X =<A.
insord(X, [A|As], [A|AAs]) :-
    X>A,
    insord(X, As, AAs).

comp([],[]).
comp([A|L1],[A|L2]) :- comp(L1,L2).

carem(X,L1,L2) :- sel(X,L1,Y),comp(Y,L2).

somalista([],0).
somalista([I|Is], S) :- somalista(Is, S0), S is I+S0.

sort(L1,L2) :- psort(L1,S), comp(S,L2).