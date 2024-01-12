create table categorie(
	id_categorie serial primary key,
	nom_categorie varchar(50) not null,
	deleted boolean default false
);

create table carburant(
	id_carburant serial primary key,
	nom_carburant varchar(50) not null,
	deleted boolean default false
);

create table modele(
	id_modele serial primary key,
	nom_modele varchar(50) not null,
	deleted boolean default false
);

create table transmission(
	id_transmission serial primary key,
	nom_transmission varchar(50) not null,
	deleted boolean default false
);

create table marque(
	id_marque serial primary key,
	nom_marque varchar(50) not null,
	deleted boolean default false
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

create table annonce(
	id_annonce serial primary key,
	date_heure_publication timestamp,
	id_user text not null,
	prix double precision,
	foreign key(id_user) REFERENCES users( id_user )
);

create table validate_annonce(
	id_annonce_valide serial primary key,
	id_annonce integer not null,
	date_time_validation timestamp,
	foreign key(id_annonce) REFERENCES annonce( id_annonce )
);


create table voiture_annonce(
	id_voiture_annonce serial primary key,
	id_marque integer not null,
	id_modele integer not null,
	id_carburant integer not null,
	id_categorie integer not null,
	id_transmission integer not null,
	foreign key( id_marque ) REFERENCES marque(id_marque),
	foreign key( id_modele ) REFERENCES modele(id_modele),
	foreign key( id_carburant ) REFERENCES carburant(id_carburant),
	foreign key( id_categorie ) REFERENCES categorie(id_categorie),
	foreign key( id_transmission ) REFERENCES transmission(id_transmission)
);

create table detail_annonce(

	id_detail_annonce serial primary key,
	id_annonce integer not null,
	description text,
	marque integer not null,
	modele integer not null,
	id_voiture_annonce integer not null,
	kilometrage double precision,
	foreign key(id_voiture_annonce) REFERENCES voiture_annonce(id_voiture_annonce),
	foreign key(id_annonce) REFERENCES annonce(id_annonce)
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
