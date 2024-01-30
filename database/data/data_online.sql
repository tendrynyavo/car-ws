-- MARQUE
insert into marque values   ('MAR01', 'Ford', false);
insert into marque values   ('MAR02', 'BMW', false);
insert into marque values   ('MAR03', 'Fiat', false);
insert into marque values   ('MAR04', 'Renault', false);
insert into marque values   ('MAR05', 'Peugeot', false);

-- CARBURANT
insert into carburant values    ('CRB01', 'Essence', false);
insert into carburant values    ('CRB02', 'Diesel', false);
insert into carburant values    ('CRB03', 'GPL', false);
insert into carburant values    ('CRB04', 'Bioethanol', false);

-- MODELE
insert into modele values   ('MOD01', 'Ford Bronco', '2020-01-01', false, 'MAR01');
insert into modele values   ('MOD02', 'Ford Explorer', '2001-01-01', false, 'MAR01');
insert into modele values   ('MOD03', 'Ford Fiesta', '2023-01-01', false, 'MAR01');
insert into modele values   ('MOD04', 'Ford Kuga', '2007-01-01', false, 'MAR01');

insert into modele values   ('MOD05', 'BMW i7', '2022-01-01', false, 'MAR02');
insert into modele values   ('MOD06', 'BMW X3', '2004-01-01', false, 'MAR02');

insert into modele values   ('MOD07', '500X', '2014-01-01', false, 'MAR03');
insert into modele values   ('MOD08', 'Fiat 500', '1957-01-01', false, 'MAR03');

insert into modele values   ('MOD09', 'Renault Clio', '2019-01-01', false, 'MAR04');
insert into modele values   ('MOD10', 'Renault D10', '2010-01-01', false, 'MAR04');

insert into modele values   ('MOD11', '308', '2021-01-01', false, 'MAR05');
insert into modele values   ('MOD12', '208', '2012-01-01', false, 'MAR05');

-- TYPE_MOTEUR
insert into type_moteur values  ('TPM01', 'Combustion interne', false);

-- MOTEUR
insert into moteur values   ('MOT01', 'EcoBoost', 4, 4500, 'DV6', false, 'MAR01', 'CRB02', 'TPM01');

-- BOITE_VITESSE
insert into boite_vitesse values    ('BDV01', 'Powershift', false);

-- CATEGORIE
insert into categorie values ('CAT01', 'Camion', false);
insert into categorie values ('CAT02', 'Plaisir', false);
insert into categorie values ('CAT03', 'Taxi', false);

-- ETAT
insert into etat values (10, 'Non valider');
insert into etat values (20, 'Valider');
insert into etat values (30, 'Retirer');
insert into etat values (40, 'vendu');

-- MOIS
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

-- COULEUR
insert into couleur values  ('COU01', 'Rouge', false),
                            ('COU02', 'Bleu Ciel', false),
                            ('COU03', 'Rose', false),
                            ('COU04', 'Violet', false),
                            ('COU05', 'Gris', false),
                            ('COU06', 'Noir', false),
                            ('COU07', 'Blanc', false),
                            ('COU08', 'Jaune', false),
                            ('COU09', 'Vert Clair', false),
                            ('COU10', 'Vert Fonce', false),
                            ('COU11', 'Bleu Roi', false);

-- SPECIFICITE
insert into specificite values  ('SPC01', 'MOD01', 'MOT01');

-- TRANSMISSION
insert into transmission values ('TRS01', 'BDV01', 'MOT01');

-- TYPE CARBURANT
insert into type_carburant values   ('TPC01', 'CRB01', 'TPM01');
insert into type_carburant values   ('TPC02', 'CRB02', 'TPM01');

-- ROLE
insert into role values ('ADMIN', 'Administrateur'), ('USER', 'Client');

-- UTILISATEUR
insert into utilisateur values  ('', 'RANDRIANANDRASANA', 'Jean Martin', 'jean@gmail.com', '+261342156789', 'jean!!!', '1976-06-11');

-- ROLE USER
insert into roles_user values (default, '', 'ADMIN', 10);

-- COMMISSION
insert into commission values (default, 1, 1000000, 2);
-->>> Id User 