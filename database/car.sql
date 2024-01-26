CREATE TABLE marque(
   id_marque VARCHAR(50) ,
   nom VARCHAR(50)  NOT NULL,
   deleted BOOLEAN,
   PRIMARY KEY(id_marque)
);

CREATE TABLE modele(
   id_modele VARCHAR(50) ,
   nom VARCHAR(50) ,
   annee DATE,
   deleted BOOLEAN,
   id_marque VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_modele),
   FOREIGN KEY(id_marque) REFERENCES marque(id_marque)
);

CREATE TABLE categorie(
   id_categorie VARCHAR(50) ,
   nom VARCHAR(50) ,
   deleted BOOLEAN,
   PRIMARY KEY(id_categorie)
);

CREATE TABLE boite_vitesse(
   id_boite VARCHAR(50) ,
   nom VARCHAR(50) ,
   deleted BOOLEAN,
   PRIMARY KEY(id_boite)
);

CREATE TABLE type_moteur(
   id_type VARCHAR(50) ,
   nom VARCHAR(50) ,
   deleted BOOLEAN,
   PRIMARY KEY(id_type)
);

CREATE TABLE carburant(
   id_carburant VARCHAR(50) ,
   nom VARCHAR(50) ,
   deeted BOOLEAN,
   PRIMARY KEY(id_carburant)
);

CREATE TABLE moteur(
   id_moteur VARCHAR(50) ,
   nom VARCHAR(50) ,
   cylindre INTEGER,
   puissance DOUBLE PRECISION,
   configuration VARCHAR(100) ,
   deleted BOOLEAN,
   id_marque VARCHAR(50)  NOT NULL,
   id_carburant VARCHAR(50)  NOT NULL,
   id_type VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_moteur),
   FOREIGN KEY(id_marque) REFERENCES marque(id_marque),
   FOREIGN KEY(id_carburant) REFERENCES carburant(id_carburant),
   FOREIGN KEY(id_type) REFERENCES type_moteur(id_type)
);

CREATE TABLE design(
   id_design VARCHAR(50) ,
   id_categorie VARCHAR(50)  NOT NULL,
   id_modele VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_design),
   FOREIGN KEY(id_categorie) REFERENCES categorie(id_categorie),
   FOREIGN KEY(id_modele) REFERENCES modele(id_modele)
);

CREATE TABLE transmission(
   id_transmission VARCHAR(50) ,
   id_boite VARCHAR(50)  NOT NULL,
   id_moteur VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_transmission),
   FOREIGN KEY(id_boite) REFERENCES boite_vitesse(id_boite),
   FOREIGN KEY(id_moteur) REFERENCES moteur(id_moteur)
);

CREATE TABLE specificite(
   id_specificite VARCHAR(50) ,
   id_modele VARCHAR(50)  NOT NULL,
   id_moteur VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_specificite),
   FOREIGN KEY(id_modele) REFERENCES modele(id_modele),
   FOREIGN KEY(id_moteur) REFERENCES moteur(id_moteur)
);

CREATE TABLE etat(
   valeur INTEGER,
   designation VARCHAR(50) ,
   PRIMARY KEY(valeur)
);

CREATE TABLE utilisateur(
   id_utilisateur VARCHAR(50) ,
   nom VARCHAR(100)  NOT NULL,
   prenom VARCHAR(100)  NOT NULL,
   email VARCHAR(100)  NOT NULL,
   contact VARCHAR(50)  NOT NULL,
   mot_de_passe VARCHAR(100)  NOT NULL,
   date_naissance DATE NOT NULL,
   PRIMARY KEY(id_utilisateur)
);

CREATE TABLE lieu(
   id_lieu VARCHAR(50) ,
   nom VARCHAR(100)  NOT NULL,
   deleted BOOLEAN,
   PRIMARY KEY(id_lieu)
);

CREATE TABLE caracteristique(
   id_caracteristique VARCHAR(50) ,
   nom VARCHAR(50)  NOT NULL,
   deleted BOOLEAN,
   PRIMARY KEY(id_caracteristique)
);

CREATE TABLE couleur(
   id_couleur VARCHAR(50) ,
   nom VARCHAR(50)  NOT NULL,
   deleted BOOLEAN,
   PRIMARY KEY(id_couleur)
);

CREATE TABLE discussion(
   id_discussion VARCHAR(50) ,
   message TEXT,
   date_envoye TIMESTAMP,
   id_utilisateur VARCHAR(50)  NOT NULL,
   id_utilisateur_1 VARCHAR(50)  NOT NULL,
   valeur INTEGER NOT NULL,
   PRIMARY KEY(id_discussion),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id_utilisateur),
   FOREIGN KEY(id_utilisateur_1) REFERENCES utilisateur(id_utilisateur),
   FOREIGN KEY(valeur) REFERENCES etat(valeur)
);

CREATE TABLE type_carburant(
   id_type_carburant VARCHAR(50) ,
   id_carburant VARCHAR(50)  NOT NULL,
   id_type VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_type_carburant),
   FOREIGN KEY(id_carburant) REFERENCES carburant(id_carburant),
   FOREIGN KEY(id_type) REFERENCES type_moteur(id_type)
);

CREATE TABLE mois(
   id_mois VARCHAR(50) ,
   nom VARCHAR(20) ,
   reference INTEGER,
   PRIMARY KEY(id_mois),
   UNIQUE(nom),
   UNIQUE(reference)
);

CREATE TABLE voiture(
   id_voiture VARCHAR(50) ,
   kilometrage DOUBLE PRECISION,
   id_utilisateur VARCHAR(50)  NOT NULL,
   id_categorie VARCHAR(50)  NOT NULL,
   id_boite VARCHAR(50)  NOT NULL,
   id_moteur VARCHAR(50)  NOT NULL,
   id_modele VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_voiture),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id_utilisateur),
   FOREIGN KEY(id_categorie) REFERENCES categorie(id_categorie),
   FOREIGN KEY(id_boite) REFERENCES boite_vitesse(id_boite),
   FOREIGN KEY(id_moteur) REFERENCES moteur(id_moteur),
   FOREIGN KEY(id_modele) REFERENCES modele(id_modele)
);

CREATE TABLE annonce(
   id_annonce VARCHAR(50) ,
   date_annonce TIMESTAMP,
   description TEXT,
   prix DOUBLE PRECISION NOT NULL,
   id_lieu VARCHAR(50)  NOT NULL,
   id_utilisateur VARCHAR(50)  NOT NULL,
   valeur INTEGER NOT NULL,
   id_voiture VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_annonce),
   FOREIGN KEY(id_lieu) REFERENCES lieu(id_lieu),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id_utilisateur),
   FOREIGN KEY(valeur) REFERENCES etat(valeur),
   FOREIGN KEY(id_voiture) REFERENCES voiture(id_voiture)
);

CREATE TABLE favori(
   id_favori VARCHAR(50) ,
   date_ajout DATE,
   id_utilisateur VARCHAR(50)  NOT NULL,
   id_annonce VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_favori),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id_utilisateur),
   FOREIGN KEY(id_annonce) REFERENCES annonce(id_annonce)
);

CREATE TABLE photo(
   id_photo VARCHAR(50) ,
   file VARCHAR(200)  NOT NULL,
   id_annonce VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_photo),
   FOREIGN KEY(id_annonce) REFERENCES annonce(id_annonce)
);

CREATE TABLE vendu(
   id_vendu VARCHAR(50) ,
   date_vendu VARCHAR(50) ,
   id_utilisateur VARCHAR(50)  NOT NULL,
   id_annonce VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_vendu),
   UNIQUE(id_annonce),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id_utilisateur),
   FOREIGN KEY(id_annonce) REFERENCES annonce(id_annonce)
);

CREATE TABLE valide(
   id_valide VARCHAR(50) ,
   date_valide DATE,
   id_annonce VARCHAR(50)  NOT NULL,
   id_utilisateur VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_valide),
   UNIQUE(id_annonce),
   FOREIGN KEY(id_annonce) REFERENCES annonce(id_annonce),
   FOREIGN KEY(id_utilisateur) REFERENCES utilisateur(id_utilisateur)
);

CREATE TABLE Coloriage(
   id_coloriage VARCHAR(50) ,
   id_couleur VARCHAR(50)  NOT NULL,
   id_voiture VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_coloriage),
   FOREIGN KEY(id_couleur) REFERENCES couleur(id_couleur),
   FOREIGN KEY(id_voiture) REFERENCES voiture(id_voiture)
);

CREATE TABLE detail(
   id_detail VARCHAR(50) ,
   valeur VARCHAR(50)  NOT NULL,
   id_caracteristique VARCHAR(50)  NOT NULL,
   id_annonce VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_detail),
   FOREIGN KEY(id_caracteristique) REFERENCES caracteristique(id_caracteristique),
   FOREIGN KEY(id_annonce) REFERENCES annonce(id_annonce)
);

create table role (
   id varchar(10) primary key,
   role varchar(25) unique
);

CREATE TABLE role_user (
   id serial primary key,
   id_user varchar(50) NOT NULL,
   role_id varchar(50) NOT NULL,
   etat int default 1
);

CREATE TABLE roles_user (
   id serial primary key,
   id_user varchar(50) NOT NULL,
   roles_id varchar(50) NOT NULL,
   etat int default 1
);

create view liste_role_users as 
select ru.id, id_user, ru.role idRole, r.role, etat from role_user ru join role r on ru.role = r.id;

create or replace view liste_role_users_valide as
select id_user, idRole id, role from liste_role_users where etat = 1;

