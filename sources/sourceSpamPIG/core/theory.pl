

address(['trudy@hotmail.com'|T],Punteggio) :-
	address(T,P),
	(Punteggio is P + 3).

address(['marco.ramilli@studio.unibo.it'|T],Punteggio) :-
	address(T,P),
	(Punteggio is P - 100).

address([A|T],Punteggio) :-
	address(T,Punteggio).

address([],0).

check(Address,Subject,Body,Punteggio) :-
	subject(Subject,X1),
	(address(Address,X2),
	(body(Body,X3),
	(Punteggio is X1 + X2 + X3))).

subject([spam|T],Punteggio) :-
	subject(T,P),
	(Punteggio is P + 6).

subject(['work with us'|T],Punteggio) :-
	subject(T,P),
	(Punteggio is P + 6).

subject([A|T],Punteggio) :-
	subject(T,Punteggio).

subject([],0).

body([penis|T],Punteggio) :-
	body(T,P),
	(Punteggio is P + 3).

body([A|T],Punteggio) :-
	body(T,Punteggio).

body([],0).

