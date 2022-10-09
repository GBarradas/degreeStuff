polinomio([W|L],X,Y) :- polinomio([W|L],X,1,0).
polinomio([], X, N, Y).
polinomio([W|L],X,N,Y) :- N1 is N+1,
                          Y1 is Y+(W*(X**N)),
                           polinomio(L,X,N1,Y1).


multPolinomios(_,[],[]).
multPolinomios([],_,[]).
multPolinomios(X,Y,S):-
        multPolinomios(0,X,Y,S).
multPolinomios(_,[],_,[]).
multPolinomios(_,_,[],[]).
multPolinomios(N,[XH|XT],Y,S):-
        N1 is N+1,
        multPolinomios(N1,XT,Y,S1),
        mult(N,XH,Y,S2),
        suma(S1,S2,S).
        mult(0,_,[]).

mult(_,[],[]).
mult(X,[HY|TY],[HS|TS]):-
        HS is X*HY,
        mult(X,TY,TS).

mult(_,_,[],[]).
mult(_,0,_,[]).
mult(Grado,Coeficiente,Y,S):-
        mult(Coeficiente,Y,S1),
        lpad(S1,Grado,S).

    lpad(XS,0,XS).
lpad(XS,N,RES):-
        N>0,
        repeat(0,N,S),
        append(S,XS,RES).

    repeat(_,0,[]).
repeat(Elem,1,[Elem]).
repeat(Elem,Num,[Elem|RT]):-
        Num>0,
        N1 is Num-1,
        repeat(Elem,N1,RT).

    suma([],[],[]).
suma([],YS,YS).
suma(XS,[],XS).
suma([XH|TX],[YH|TY],[S|TS]):-
        suma(TX,TY,TS),S is XH+YH.