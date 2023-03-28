
z(a,b,d).
z(c,b,d).

w(A,B):- z(A,C,D), z(B,C,D),A\=B.

a([],A,A).		
a([A|R],B,[A|S]):- a(R,B,S).


l([],_,[]).
l([A|R],A,R).
l([A|R],B,[A|S]):- A\=B, l(R,B,S).
