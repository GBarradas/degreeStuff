num(z).
num(s(X)) :- num(X).

le(z,X) :- num(X).
le(s(A), s(B)) :- le(A,B).

lt(z, s(X)) :- num(X).
lt(s(A),s(B)) :- lt(A,B).

soma(z, X,X) :- num(X).
soma(s(X),Y,s(Z)):- soma(X,Y,Z).
sub(A,B,X):- soma(X,B,A).

mult(z,_,z).
mult(s(A),B,X) :- mult(A,B,Y), soma(B,Y,X).

num(z,0).
num(s(s(s(z))),3).

num(s(X),SY) :- num(X,Y) , SY is Y+1.

div(A,B,Q,R) :- mult(B,Q,X),soma(X,R,A), lt(R,B).

nprimo(2).
nprimo(3).
nprimo(A) :- A>3, A mod 2 =\=0, \+ podeser(A,3).
podeser(X,Y) :- X mod Y =:= 0.
podeser(X,Y) :- Y*Y<X, L2 is Y+2, podeser(X,L2).
