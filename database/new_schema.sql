create table marque(
	id_marque serial primary key,
	nom_marque varchar(50) not null unique,
	origine varchar(50),
	deleted boolean default false
);

create table modele(
	id_modele serial primary key,
	id_marque integer not null,
	nom_modele varchar(50) not null unique,
	annee integer,
	deleted boolean default false,
	foreign key ( id_marque ) REFERENCES marque(id_marque)
);

create table categorie(
	id_categorie serial primary key,
	nom_categorie varchar(50) not null unique,
	deleted boolean default false
);

create table a_modele_categorie(
	id serial primary key,
	id_modele integer not null,
	id_categorie integer not null,
	foreign key( id_modele ) REFERENCES modele(id_modele),
	foreign key( id_categorie ) REFERENCES categorie(id_categorie)
);

create table boite_vitesse(
	id serial primary key,
	nom varchar(50) not null unique,
	deleted boolean default false
);

create table carburant(
	id_carburant serial primary key,
	nom_carburant varchar(50) not null,
	deleted boolean default false
);

create table type_moteur(
	id serial primary key,
	nom varchar(50) not null unique
);

create table couleur(
	id serial primary key,
	nom_couleur varchar(50) not null unique	
);

create table a_carburant_type_moteur(
	id serial primary key,
	id_type_moteur integer not null,
	id_carburant integer not null,
	foreign key( id_type_moteur ) REFERENCES type_moteur(id),
	foreign key( id_carburant ) REFERENCES carburant(id_carburant)
);

create table moteur(
	id_moteur serial primary key,
	marque integer not null,
	modele varchar(50) not null,
	puissance double precision,
	id_type_moteur integer not null,
	carburant integer not null,
	cylindre double precision,
	configuration varchar(50) not null,
	foreign key(marque) REFERENCES marque( id_marque ),
	foreign key(id_type_moteur) REFERENCES type_moteur( id ),
	foreign key(carburant) REFERENCES carburant( id_carburant )
	-- okey mila inona koa moa type ana moteur
);

create table moteur_vitesse(
	id serial primary key,
	id_moteur integer not null,
	id_type_vitesse integer not null,
	foreign key( id_moteur ) REFERENCES moteur(id_moteur),
	foreign key( id_type_vitesse ) REFERENCES boite_vitesse( id )
);

CREATE TABLE a_modele_moteur(
	id serial primary key,
	id_modele integer not null,
	id_moteur integer not null,
	foreign key( id_modele ) REFERENCES modele(id_modele),
	foreign key( id_moteur ) REFERENCES moteur(id_moteur)
);

create table caracteristique(
	id serial primary key,
	nom_caracterstique varchar(50) not null unique
);


create table etats(
	id int primary key,
	nom VARCHAR(255) not null
);


create table users(
	id_user text not null primary key,
	nom_user varchar(50) not null,
	prenom varchar(50) ,
	mail varchar(60) not null,
	contact varchar(50),
	password varchar(100),
	date_naissance date
);

create table lieu(
	id_lieu serial primary key,
	nom_lieu varchar(50) not null unique,
	code_postal varchar(25) not null
);

-- Ampiana condition ito ( neuf, occasion )


create table voiture_annonce(
	id_voiture_annonce serial primary key,
	id_modele integer not null,
	id_categorie integer not null,
	id_moteur integer not null,
	kilometrage double precision,
	annee int,
	foreign key( id_modele ) REFERENCES modele(id_modele),
	foreign key( id_categorie ) REFERENCES categorie(id_categorie),
	foreign key( id_moteur ) REFERENCES moteur(id_moteur)
);

create table annonce(
	id_annonce serial primary key,
	date_heure_publication timestamp,
	id_user text not null,
	id_etat int not null,
	lieu integer not null,
	description text,
	id_voiture_annonce integer not null,
	prix double precision,
	foreign key( id_user ) REFERENCES users( id_user ),
	foreign key( id_etat ) REFERENCES etats( id ),
	foreign key( lieu ) REFERENCES lieu(id_lieu),
	foreign key( id_voiture_annonce ) REFERENCES voiture_annonce( id_voiture_annonce )
);

create table annonce_couleur(
	id serial primary key,
	id_annonce integer not null,
	id_couleur integer not null,
	foreign key( id_annonce ) REFERENCES annonce(id_annonce),
	foreign key( id_couleur ) REFERENCES couleur( id )
);

create table validate_annonce(
	id_annonce_valide serial primary key,
	id_annonce integer not null,
	date_time_validation timestamp,
	foreign key(id_annonce) REFERENCES annonce( id_annonce )
);



-- Ampiana an'ito anaovana informations additionnelle
create table detail_car_annonce(
	id_detail serial primary key,
	id_annonce integer not null,
	id_caracteristique integer not null,
	value varchar(100) not null,
	foreign key(id_annonce) REFERENCES annonce(id_annonce),
	foreign key(id_caracteristique) REFERENCES caracteristique(id)
);


-- Okey zavatra hafa indray zao


create table annonce_vendus(
	id_annonce_vendus serial primary key,
	date_vendus date,
	id_annonce integer not null,
	foreign key(id_annonce) REFERENCES annonce( id_annonce )
);

create table annonce_photo(
	id_photo serial primary key,
	id_annonce integer not null,
	photo text,
	foreign key(id_annonce) REFERENCES annonce (id_annonce)
);

create table favoris(
	id_favoris serial primary key,
	id_annonce integer not null,
	id_user text not null,
	date_ajout date,
	foreign key( id_annonce ) REFERENCES annonce(id_annonce),
	foreign key( id_user ) REFERENCES users(id_user)
);

create table discussion(
	id_discussion serial primary key,
	id_envoyeur text not null,
	id_receveur text not null,
	foreign key(id_envoyeur) REFERENCES users( id_user ),
	foreign key(id_receveur) REFERENCES users( id_user )
);

create table message(
	id_messsage serial primary key,
	id_discussion integer not null,
	date_heure_envoie timestamp,
	message text,
	foreign key( id_discussion ) REFERENCES discussion(id_discussion)
);

create table discussions (
	id serial primary key,
	id_envoyeur text not null,
	id_receveur text not null,
	date_heure_envoie timestamp DEFAULT current_timestamp,
	message text,
	foreign key(id_envoyeur) REFERENCES users( id_user ),
	foreign key(id_receveur) REFERENCES users( id_user )
);

create table mois(
	id varchar(4) not null primary key,
	nom varchar(50) unique not null,
	reference integer not null
);

drop view if exists one_annonce_to_month;
create or replace view one_annonce_to_month
	as		
		select
			*
		from mois as m , annonce as a;

drop view if exists v_stats cascade;
create or replace view v_stats
	as
	select
		o_a_m.nom,
		o_a_m.reference,
		count( distinct(a.id_annonce) ) as nbr_annonce,
		extract( YEAR from a.date_heure_publication ) as year,
		a.id_etat as annonce_etat
	from one_annonce_to_month as o_a_m
	left join annonce as a
	on extract ( month from a.date_heure_publication ) = o_a_m.reference
	group by o_a_m.nom, o_a_m.reference, extract(YEAR from a.date_heure_publication ), a.id_etat
	order by o_a_m.reference;


drop view if exists v_stats_month;
create or replace view v_stats_month
	as
		select
			v_s.nom, SUM(v_s.nbr_annonce) as total
		from v_stats as v_s
		group by v_s.nom, v_s.reference
		order by v_s.reference
;

alter table users add column date_naissance date;
alter table voiture_annonce add column annee integer not null;


-- VALIDATE
	--VIEW
	DROP VIEW IF EXISTS v_statistics_validate_month;
	CREATE OR REPLACE VIEW v_statistics_validate_month
		AS
			SELECT 
				EXTRACT(YEAR FROM va.date_time_validation) AS annee,
				m.nom AS mois, 
				COALESCE(COUNT(va.id_annonce), 0) AS nbr_annonce_valide
			FROM 
				mois m 
			LEFT JOIN 
				validate_annonce va ON EXTRACT(MONTH FROM va.date_time_validation) = m.reference
			LEFT JOIN 
				annonce a ON va.id_annonce = a.id_annonce AND a.id_etat = 30
			GROUP BY 
				annee, m.nom, m.reference
			ORDER BY 
				annee, m.reference;

	-- FUNCTIONS
		-- Annonce valider par mois par an

		-- Regarder les details d'une view: \d+ <nom_view>
			CREATE OR REPLACE FUNCTION get_validate_annonce_by_year(_annee INT)
				RETURNS TABLE (
					annee DOUBLE PRECISION,
					mois VARCHAR,
					nbr_annonce_valide BIGINT
				) AS $$
				BEGIN
					RETURN QUERY
						SELECT 
							COALESCE(v.annaee, _annee) AS annee,
							m.nom AS mois,
							COALESCE(v.nbr_annonce_validae, 0) AS nbr_annonce_valide
						FROM 
							(SELECT _annee AS annee) y
						CROSS JOIN 
							mois m
						LEFT JOIN 
							v_statistics_validate_month v ON m.nom = v.mois AND y.annee = v.annee
						ORDER BY 
							m.reference;
				END; $$ LANGUAGE plpgsql;
	
	-- -- TEST
	-- 	select * from get_validate_annonce_by_year(2023);