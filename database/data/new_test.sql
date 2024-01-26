-- Brand -- marque
COPY marque(id_marque,nom)
FROM 'E:/ITU/Semestre 5/Mr Rojo/Projet_Cloud/car-ws/car-ws/database/data/manufacturers.csv'
DELIMITER ';'
CSV HEADER;

COPY categorie(id_categorie,nom)
FROM '/home/mounts/GitHub/car-ws/database/data/categories.csv'
DELIMITER ';'
CSV HEADER;

insert into design values ( default , 1 , 1 );
	
insert into design values ( default , 14 , 1 );
insert into design values ( default , 12 , 1 );

insert into lieu values ('LIE01', 'Antananarivo' , false);
insert into lieu values ('LIE02', 'Diego Suarez' , false);
insert into lieu values ('LIE03', 'Fianarantsoa' , false);
insert into lieu values ('LIE04', 'Mahajanga' , false);
insert into lieu values ('LIE05', 'Toamasina' , false);
insert into lieu values ('LIE06', 'Toliara' , false);

-- test sampona
-- Insert data into marque
INSERT INTO marque (id_marque, nom, deleted) VALUES ('MAR01', 'Marque1', FALSE);
INSERT INTO marque (id_marque, nom, deleted) VALUES ('MAR02', 'Marque2', FALSE);

-- Insert data into modele
INSERT INTO modele (id_modele, nom, annee, deleted, id_marque) VALUES ('MOD01', 'Model1', '2024-01-01', FALSE, 'MAR01');
INSERT INTO modele (id_modele, nom, annee, deleted, id_marque) VALUES ('MOD02', 'Model2', '2023-01-01', FALSE, 'MAR02');

-- Insert data into categorie
INSERT INTO categorie (id_categorie, nom, deleted) VALUES ('CAT01', 'Cat1', FALSE);
INSERT INTO categorie (id_categorie, nom, deleted) VALUES ('CAT02', 'Cat2', FALSE);

-- Insert data into boite_vitesse
INSERT INTO boite_vitesse (id_boite, nom, deleted) VALUES ('BDV01', 'Boite1', FALSE);
INSERT INTO boite_vitesse (id_boite, nom, deleted) VALUES ('BDV02', 'Boite2', FALSE);

-- Insert data into type_moteur
INSERT INTO type_moteur (id_type, nom, deleted) VALUES ('TPM01', 'Type1', FALSE);
INSERT INTO type_moteur (id_type, nom, deleted) VALUES ('TPM02', 'Type2', FALSE);

-- Insert data into carburant
INSERT INTO carburant (id_carburant, deleted, nom) VALUES ('CRB01', FALSE, 'Carburant1');
INSERT INTO carburant (id_carburant, deleted, nom) VALUES ('CRB02', FALSE, 'Carburant2');

-- Insert data into moteur
INSERT INTO moteur (id_moteur, nom, cylindre, puissance, configuration, deleted, id_marque, id_carburant, id_type) 
VALUES ('MOT01', 'Moteur1', 4, 150.0, 'V4', FALSE, 'MAR01', 'CRB01', 'TPM01');
INSERT INTO moteur (id_moteur, nom, cylindre, puissance, configuration, deleted, id_marque, id_carburant, id_type) 
VALUES ('MOT02', 'Moteur2', 6, 200.0, 'V6', FALSE, 'MAR02', 'CRB02', 'TPM02');

-- Insert data into design
INSERT INTO design (id_design, id_categorie, id_modele) VALUES ('DGN01', 'CAT01', 'MOD01');
INSERT INTO design (id_design, id_categorie, id_modele) VALUES ('DGN02', 'CAT02', 'MOD02');

-- Insert data into transmission
INSERT INTO transmission (id_transmission, id_boite, id_moteur) VALUES ('TRS01', 'BDV01', 'MOT01');
INSERT INTO transmission (id_transmission, id_boite, id_moteur) VALUES ('TRS02', 'BDV02', 'MOT02');

-- Insert data into specificite
INSERT INTO specificite (id_specificite, id_modele, id_moteur) VALUES ('SPC01', 'MOD01', 'MOT01');
INSERT INTO specificite (id_specificite, id_modele, id_moteur) VALUES ('SPC02', 'MOD02', 'MOT02');

-- Insert data into couleur
INSERT INTO couleur (id_couleur, nom, deleted) VALUES ('COU01', 'Red', FALSE);
INSERT INTO couleur (id_couleur, nom, deleted) VALUES ('COU02', 'Blue', FALSE);

-- Insert data into type_carburant
INSERT INTO type_carburant (id_type_carburant, id_carburant, id_type) VALUES ('TPC01', 'CRB01', 'TPM01');
INSERT INTO type_carburant (id_type_carburant, id_carburant, id_type) VALUES ('TPC02', 'CRB02', 'TPM02');
