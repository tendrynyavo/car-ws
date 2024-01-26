insert into categorie ( nom_categorie ) values ('Camion');
insert into categorie ( nom_categorie ) values ('Plaisir');
insert into categorie ( nom_categorie ) values ('Taxi');

insert into etats (id, nom ) values (10, 'en attente');
insert into etats (id, nom ) values (20, 'supprimer');
insert into etats (id, nom ) values (30, 'validee');
insert into etats (id, nom ) values (40, 'favorie');
insert into etats (id, nom ) values (50, 'vendu');

insert into mois values
	( 'JAN' , 'Janvier' , 1 ),
	( 'FEB' , 'Fevrier' , 2 ),
	( 'MAR' , 'Mars' 	, 3 ),
	( 'APR' , 'Avril' 	, 4 ),
	( 'MAI' , 'Mai' 	, 5 ),
	( 'JUN' , 'Juin' 	, 6 ),
	( 'JUL' , 'Juillet' , 7 ),
	( 'AUG' , 'Aout' 	, 8 ),
	( 'SEP' , 'Septembre', 9 ),
	( 'OCT' , 'Octobre' , 10 ),
	( 'NOV' , 'Novembre', 11 ),
	( 'DEC' , 'Decembre', 12 );

psql -h viaduct.proxy.rlwy.net -p 26857 -d carocaz -U postgres -W

insert into utilisateur values
	( 'USER1', 'RANDRIAHAVANA' , 'Manoary Sarobidy' , 'manoary@gmail.com', '+261341422651', 'Sarobidy!!!', '2004-05-11' );
	insert into utilisateur values
	( 'USER2', 'ANJARATIANA' , 'Layah' , 'layah@gmail.com', '+261341422651', 'Layah!!!' , '2002-06-12');

insert into annonce values
	( default, CURRENT_TIMESTAMP , 'USER1', 2500000 );
insert into annonce values
	( default, '2023-01-05 10:00:00' , 'USER1', 2500000 );
insert into annonce values
	( default, '2023-01-23 10:00:00' , 'USER1', 2500000 );
insert into annonce values
	( default, '2023-01-27 10:00:00' , 'USER1', 2500000 );
insert into annonce values
	( default, '2023-04-01 10:00:00' , 'USER1', 2500000 );
insert into annonce values
	( default, '2023-05-10 10:00:00' , 'USER1', 2500000 );
	
insert into annonce values
	( default, '2023-01-10 10:00:00' , 'USER1', 2500000 );
insert into annonce values
	( default, '2023-01-10 10:00:00' , 'USER1', 2500000 );
insert into annonce values
	( default, '2023-01-10 10:00:00' , 'USER1', 2500000 );
insert into annonce values
	( default, '2023-01-10 10:00:00' , 'USER1', 2500000 );
insert into annonce values
	( default, '2023-05-10 10:00:00' , 'USER1', 2500000 );
insert into annonce values
	( default, '2023-05-10 10:00:00' , 'USER1', 2500000 );
insert into annonce values
	( default, '2023-05-10 10:00:00' , 'USER1', 2500000 );
insert into annonce values
	( default, '2023-05-10 10:00:00' , 'USER1', 2500000 );

insert into annonce values
	( default, '2023-02-10 10:00:00' , 'USER1', 2500000 );
insert into annonce values
	( default, '2023-02-10 10:00:00' , 'USER1', 2500000 );
insert into annonce values
	( default, '2023-03-10 10:00:00' , 'USER1', 2500000 );
insert into annonce values
	( default, '2023-02-10 10:00:00' , 'USER1', 2500000 );
insert into annonce values
	( default, '2023-07-10 10:00:00' , 'USER1', 2500000 );

db.discussions.find({$or:[{ idEnvoyeur: "eTLPHjKBKTUyMQ2UCJ0UYSQBx5g1", idReceveur: "aRU7yww5lgZ6eDev3iJ95SKgmAA3" },{ idEnvoyeur: "aRU7yww5lgZ6eDev3iJ95SKgmAA3", idReceveur: "eTLPHjKBKTUyMQ2UCJ0UYSQBx5g1" }]}).sort({ dateHeureEnvoie: 1 })

db.discussions.updateOne(
   { _id: ObjectId('65a70723152b89710aa53280') },
   { $set: { statut: 20 } }
)

db.discussions.find({ idEnvoyeur: "eTLPHjKBKTUyMQ2UCJ0UYSQBx5g1", idReceveur: "aRU7yww5lgZ6eDev3iJ95SKgmAA3", statut: 1 })

