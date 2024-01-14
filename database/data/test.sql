insert into categorie ( nom_categorie ) values ('Camion');
insert into categorie ( nom_categorie ) values ('Plaisir');
insert into categorie ( nom_categorie ) values ('Taxi');

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

insert into users values
	( '************************************Test*************************', 'RANDRIAHAVANA' , 'Manoary Sarobidy' , 'manoary@gmail.com', '+261341422651', 'Sarobidy!!!' );
	insert into users values
	( '************************************Test-2*************************', 'ANJARATIANA' , 'Layah' , 'layah@gmail.com', '+261341422651', 'Layah!!!' );

insert into annonce values
	( default, CURRENT_TIMESTAMP , '************************************Test*************************', 2500000 );
insert into annonce values
	( default, '2023-01-05 10:00:00' , '************************************Test*************************', 2500000 );
insert into annonce values
	( default, '2023-01-23 10:00:00' , '************************************Test*************************', 2500000 );
insert into annonce values
	( default, '2023-01-27 10:00:00' , '************************************Test*************************', 2500000 );
insert into annonce values
	( default, '2023-04-01 10:00:00' , '************************************Test*************************', 2500000 );
insert into annonce values
	( default, '2023-05-10 10:00:00' , '************************************Test*************************', 2500000 );
	
insert into annonce values
	( default, '2023-01-10 10:00:00' , '************************************Test*************************', 2500000 );
insert into annonce values
	( default, '2023-01-10 10:00:00' , '************************************Test*************************', 2500000 );
insert into annonce values
	( default, '2023-01-10 10:00:00' , '************************************Test*************************', 2500000 );
insert into annonce values
	( default, '2023-01-10 10:00:00' , '************************************Test*************************', 2500000 );
insert into annonce values
	( default, '2023-05-10 10:00:00' , '************************************Test*************************', 2500000 );
insert into annonce values
	( default, '2023-05-10 10:00:00' , '************************************Test*************************', 2500000 );
insert into annonce values
	( default, '2023-05-10 10:00:00' , '************************************Test*************************', 2500000 );
insert into annonce values
	( default, '2023-05-10 10:00:00' , '************************************Test*************************', 2500000 );

insert into annonce values
	( default, '2023-02-10 10:00:00' , '************************************Test*************************', 2500000 );
insert into annonce values
	( default, '2023-02-10 10:00:00' , '************************************Test*************************', 2500000 );
insert into annonce values
	( default, '2023-03-10 10:00:00' , '************************************Test*************************', 2500000 );
insert into annonce values
	( default, '2023-02-10 10:00:00' , '************************************Test*************************', 2500000 );
insert into annonce values
	( default, '2023-07-10 10:00:00' , '************************************Test*************************', 2500000 );

