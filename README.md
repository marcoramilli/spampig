# SpamPIG
---------

![alt SpamPIG](http://spampig.sourceforge.net/img/pig.png "")

This Project born for research target. One of our target was "touch" tuProlog Limit, in fact with this intelligence antispam system we work with tens of Mega Byte prolog theory. As all sould know, Prolog has much goals but if you use it with a very big theory, the computational time of prolog engine is very hight ! In this particular case SpamPIG is very optimized so common user could kill his spam with this. In this version you could controll only a single mail box but in future we would like open this project to unlimited mail box.
What you'll find in this version:

1. Swing Interface : Friendly Grafic User Interface.
2. Prolog Engine: Powerful Prolog Engine to calculate spam probability.
3. Auto Knowledge: Intelligint module that learn on your existing mail.
4. Upadte Black List: Powerful but very slow tecnicque to create an automatic prolog theory (it takes 5 hours, it translate about 6MB of data)
5. View Therory: Simple but efficient Theory viewer ( about 20 minutes )
6. View Mail: Simple but efficient Mail viewer ( very fast :-) )
If you want to contribute please send mail to marcoramilli@users.sourceforge.net, thanks.

Please check the original website for more informations on the project ([SpamPiG Web Site](http://spampig.sourceforge.net) )

### Warning
This project is based on intelligent auto-learning prolog engine. The implemented algorithms will increase the size of the prolog "theory" file depending on your inbox size.

### Repository Description.

*. bin directory, the executable JAR.
*. docs directory, a pdf guide and the JavDocs.
*. lib directory, needed libraries.
*. Sources directory, the complete NetBans project. 
*. Uninstaller directory, the java iZPack uninstaller. 
*. theory.pl. The initial Prolog Theory.

### How to run SpamPIG.

1. If you are running Windows, you shold find the short cut on you Desktop/PStart->Program.
2. If you are running MacOSX, you have to go in your install directory and type sh SpamPIGMAC from command line
3. If you are running Linux,  you have to go in your install directory and type sh SpamPIGLINUX from command line
	
This Versione was created by :
Marco Ramilli, Stefano Bianchini

We want to thaink: 
Paolo Burnacci who designed our Logo. ( http://www.nacci.tk )

### A sampple of Theory
The following listing reoresents a Prolog sample Theory.

```
 address(['08273732856852@'|T],Punteggio):- address(T,P), Punteggio is P + 11. 
 address(['082viiofvl@yahoo.com'|T],Punteggio):- address(T,P), Punteggio is P + 11. 
 address(['083bkhdod@bigfoot.com'|T],Punteggio):- address(T,P), Punteggio is P + 11. 
 address(['083pzcc@earthlink.com'|T],Punteggio):- address(T,P), Punteggio is P + 11. 
 address(['083rlp@juno.com'|T],Punteggio):- address(T,P), Punteggio is P + 11. 
 address(['083rpjl@yahoo.com'|T],Punteggio):- address(T,P), Punteggio is P + 11. 
 address(['083tig@aceweb.net'|T],Punteggio):- address(T,P), Punteggio is P + 11. 
 address(['08432@earthlink.net'|T],Punteggio):- address(T,P), Punteggio is P + 11. 
 address(['085xznvn@msn.com'|T],Punteggio):- address(T,P), Punteggio is P + 11. 
 address(['086akjdxtp@yahoo.com'|T],Punteggio):- address(T,P), Punteggio is P + 11. 
 address(['086mblkq@hn.vnn.vn'|T],Punteggio):- address(T,P), Punteggio is P + 11. 
 address(['086niusagm@fcc.net'|T],Punteggio):- address(T,P), Punteggio is P + 11. 
 address(['086zps@msn.com'|T],Punteggio):- address(T,P), Punteggio is P + 11. 
 address(['087cdtx@msn.com'|T],Punteggio):- address(T,P), Punteggio is P + 11. 
 address(['087kpm@concentric.com'|T],Punteggio):- address(T,P), Punteggio is P + 11. 
 address(['088setlzpq@juno.com'|T],Punteggio):- address(T,P), Punteggio is P + 11. 
 address(['089rlu@seductive.com'|T],Punteggio):- address(T,P), Punteggio is P + 11. 
 address(['08bljdtzp@msn.co'|T],Punteggio):- address(T,P), Punteggio is P + 11. 
 



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

```

### Side Notes
This is a pretty old software born a research project in 
