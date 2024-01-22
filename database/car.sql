CREATE TABLE marque(
   id_marque serial,
   nom VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_marque)
);

CREATE TABLE modele(
   id_modele serial,
   nom VARCHAR(50) ,
   annee DATE,
   id_marque integer NOT NULL,
   PRIMARY KEY(id_modele),
   FOREIGN KEY(id_marque) REFERENCES marque(id_marque)
);

CREATE TABLE categorie(
   id_categorie serial,
   nom VARCHAR(50) ,
   PRIMARY KEY(id_categorie)
);

CREATE TABLE boite_vitesse(
   id_boite serial,
   nom VARCHAR(50) ,
   PRIMARY KEY(id_boite)
);

CREATE TABLE type_moteur(
   id_type serial ,
   nom VARCHAR(50) ,
   PRIMARY KEY(id_type)
);

CREATE TABLE carburant(
   id_carburant serial,
   nom VARCHAR(100) ,
   PRIMARY KEY(id_carburant)
);

CREATE TABLE moteur(
   id_moteur serial ,
   nom VARCHAR(50) ,
   cylindre INTEGER,
   puissance DOUBLE PRECISION,
   configuration VARCHAR(100) ,
   id_marque integer  NOT NULL,
   id_carburant integer  NOT NULL,
   id_type integer  NOT NULL,
   PRIMARY KEY(id_moteur),
   FOREIGN KEY(id_marque) REFERENCES marque(id_marque),
   FOREIGN KEY(id_carburant) REFERENCES carburant(id_carburant),
   FOREIGN KEY(id_type) REFERENCES type_moteur(id_type)
);

CREATE TABLE design(
   id_design serial ,
   id_categorie integer  NOT NULL,
   id_modele integer  NOT NULL,
   PRIMARY KEY(id_design),
   FOREIGN KEY(id_categorie) REFERENCES categorie(id_categorie),
   FOREIGN KEY(id_modele) REFERENCES modele(id_modele)
);

CREATE TABLE transmission(
   id_transmission serial ,
   id_boite integer  NOT NULL,
   id_moteur integer  NOT NULL,
   PRIMARY KEY(id_transmission),
   FOREIGN KEY(id_boite) REFERENCES boite_vitesse(id_boite),
   FOREIGN KEY(id_moteur) REFERENCES moteur(id_moteur)
);

CREATE TABLE specificite(
   id_specificite serial,
   id_modele integer NOT NULL,
   id_moteur integer NOT NULL,
   PRIMARY KEY(id_specificite),
   FOREIGN KEY(id_modele) REFERENCES modele(id_modele),
   FOREIGN KEY(id_moteur) REFERENCES moteur(id_moteur)
);

CREATE TABLE etat(
   valeur integer not null ,
   designation VARCHAR(50) ,
   PRIMARY KEY(valeur)
);

CREATE TABLE utilisateur(
   id_utilisateur serial ,
   nom VARCHAR(100)  NOT NULL,
   prenom VARCHAR(100)  NOT NULL,
   email VARCHAR(100)  NOT NULL,
   contact VARCHAR(50)  NOT NULL,
   mot_de_passe VARCHAR(100)  NOT NULL,
   date_naissance DATE NOT NULL,
   PRIMARY KEY(id_utilisateur)
);

CREATE TABLE lieu(
   id_lieu serial,
   nom VARCHAR(100)  NOT NULL,
   PRIMARY KEY(id_lieu)
);

CREATE TABLE caracteristique(
   id_caracteristique serial ,
   nom VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_caracteristique)
);

CREATE TABLE couleur(
   id_couleur serial ,
   nom VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_couleur)
);

CREATE TABLE discussion(
   id_discussion serial ,
   message TEXT,
   date_envoye TIMESTAMP,
   id_utilisateur integer  NOT NULL,
   id_utilisateur_1 integer  NOT NULL,
   valeur integer  NOT NULL,
   PRIMARY KEY(id_discussion),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id_utilisateur),
   FOREIGN KEY(id_utilisateur_1) REFERENCES utilisateur(id_utilisateur),
   FOREIGN KEY(valeur) REFERENCES etat(valeur)
);

CREATE TABLE voiture(
   id_voiture serial ,
   kilometrage DOUBLE PRECISION,
   id_specificite integer  NOT NULL,
   id_transmission integer  NOT NULL,
   id_design integer  NOT NULL,
   PRIMARY KEY(id_voiture),
   FOREIGN KEY(id_specificite) REFERENCES specificite(id_specificite),
   FOREIGN KEY(id_transmission) REFERENCES transmission(id_transmission),
   FOREIGN KEY(id_design) REFERENCES design(id_design)
);

CREATE TABLE annonce(
   id_annonce serial ,
   date_annonce TIMESTAMP,
   description TEXT,
   prix DOUBLE PRECISION NOT NULL,
   id_lieu integer  NOT NULL,
   id_utilisateur integer  NOT NULL,
   valeur integer  NOT NULL,
   id_voiture integer  NOT NULL,
   PRIMARY KEY(id_annonce),
   FOREIGN KEY(id_lieu) REFERENCES lieu(id_lieu),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id_utilisateur),
   FOREIGN KEY(valeur) REFERENCES etat(valeur),
   FOREIGN KEY(id_voiture) REFERENCES voiture(id_voiture)
);

CREATE TABLE favori(
   id_favori serial ,
   date_ajout DATE,
   id_utilisateur integer  NOT NULL,
   id_annonce integer  NOT NULL,
   PRIMARY KEY(id_favori),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id_utilisateur),
   FOREIGN KEY(id_annonce) REFERENCES annonce(id_annonce)
);

CREATE TABLE photo(
   id_photo serial ,
   file VARCHAR(200)  NOT NULL,
   id_annonce integer  NOT NULL,
   PRIMARY KEY(id_photo),
   FOREIGN KEY(id_annonce) REFERENCES annonce(id_annonce)
);

CREATE TABLE vendu(
   id_vendu serial ,
   date_vendu date ,
   id_utilisateur integer  NOT NULL,
   id_annonce integer  NOT NULL,
   PRIMARY KEY(id_vendu),
   UNIQUE(id_annonce),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id_utilisateur),
   FOREIGN KEY(id_annonce) REFERENCES annonce(id_annonce)
);

CREATE TABLE valide(
   id_valide serial ,
   date_valide DATE,
   id_annonce integer  NOT NULL,
   id_utilisateur integer  NOT NULL,
   PRIMARY KEY(id_valide),
   UNIQUE(id_annonce),
   FOREIGN KEY(id_annonce) REFERENCES annonce(id_annonce),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id_utilisateur)
);

CREATE TABLE type_carburant(
   id_type_carburant serial,
   id_type integer ,
   id_carburant integer ,
   PRIMARY KEY(id_type_carburant),
   FOREIGN KEY(id_type) REFERENCES type_moteur(id_type),
   FOREIGN KEY(id_carburant) REFERENCES carburant(id_carburant)
);

CREATE TABLE detail(
   id_detail serial,
   id_annonce integer not null ,
   id_caracteristique integer not null ,
   valeur integer  NOT NULL,
   PRIMARY KEY(id_detail),
   FOREIGN KEY(id_annonce) REFERENCES annonce(id_annonce),
   FOREIGN KEY(id_caracteristique) REFERENCES caracteristique(id_caracteristique)
);

CREATE TABLE coloriage(
   id_coloriage serial,
   id_annonce integer not null ,
   id_couleur integer not null ,
   PRIMARY KEY(id_coloriage),
   FOREIGN KEY(id_annonce) REFERENCES annonce(id_annonce),
   FOREIGN KEY(id_couleur) REFERENCES couleur(id_couleur)
);

create table mois(
   id varchar(4) not null primary key,
   nom varchar(50) unique not null,
   reference integer not null
);