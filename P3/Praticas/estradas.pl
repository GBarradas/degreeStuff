e(lisboa, santarem).
e(santarem, coimbra).
e(santarem, caldas).
e(caldas, lisboa).
e(coimbra, porto).
e(lisboa, evora).
e(evora, beja).
e(lisboa, faro).
e(beja, faro).

a(X,Y) :- e(X,Y).
a(X,Y) :- e(Y,X).
 
%caminho(K) :- non(K).
%caminho(c(N,KK)) :- non(N), caminho(KK).
/*write_list([Head|Tail]) :-
	write(Head), nl,
	write_list(Tail).
*/
%figura(N,N).
%figura(N, c(N,_)).
%figura(N,c(_,K)) :- figura(N,K).
%nfigura(N,K) :- \+ figura(N,K).
%
%cam(A,B) :- cam(A,B,A).
%cam(A,B,X) :- a(A,B), nfigura(B,X).
%cam(A,B,X) :- a(A,C), nfigura(C,X), cam(C,B,c(C,X)).

cam(A,B,P) :- cam(A,B,[A],P).
cam(B,B,L,L).
cam(A,B,L,P) :- a(A,X), \+ member(X,L), cam(X,B,[X|L],P).
 