-- Brand -- marque
COPY marque(nom)
FROM '/home/mounts/GitHub/car-ws/database/data/manufacturers.csv'
DELIMITER ','
CSV HEADER;

COPY categorie(nom)
FROM '/home/mounts/GitHub/car-ws/database/data/categories.csv'
DELIMITER ','
CSV HEADER;

insert into design values ( default , 1 , 1 );
	
insert into design values ( default , 14 , 1 );
insert into design values ( default , 12 , 1 );

insert into lieu values (default, 'Antananarivo' , '101');
insert into lieu values (default, 'Diego Suarez' , '201');
insert into lieu values (default, 'Fianarantsoa' , '301');
insert into lieu values (default, 'Mahajanga' , '401');
insert into lieu values (default, 'Toamasina' , '501');
insert into lieu values (default, 'Toliara' , '601');