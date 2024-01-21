-- Brand -- marque
COPY marque(nom_marque)
FROM '/home/mounts/GitHub/car-ws/database/data/manufacturers.csv'
DELIMITER ','
CSV HEADER;

COPY categorie(nom_categorie)
FROM '/home/mounts/GitHub/car-ws/database/data/categories.csv'
DELIMITER ','
CSV HEADER;

insert into lieu values (default, 'Antananarivo' , '101');
insert into lieu values (default, 'Diego Suarez' , '201');
insert into lieu values (default, 'Fianarantsoa' , '301');
insert into lieu values (default, 'Mahajanga' , '401');
insert into lieu values (default, 'Toamasina' , '501');
insert into lieu values (default, 'Toliara' , '601');