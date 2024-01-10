CREATE SEQUENCE "public".annonce_id_annonce_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".annonce_photo_id_photo_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".annonce_vendus_id_vendus_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".categorie_id_categorie_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".detail_annonce_id_detail_annonce_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".favoris_id_favoris_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".marque_id_marque_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".message_id_message_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".modele_id_modele_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".users_id_user_seq START WITH 1 INCREMENT BY 1;

CREATE  TABLE "public".categorie ( 
	id_categorie         integer DEFAULT nextval('categorie_id_categorie_seq'::regclass) NOT NULL  ,
	nom_categorie        varchar(50)  NOT NULL  ,
	CONSTRAINT categorie_pkey PRIMARY KEY ( id_categorie )
 );

CREATE  TABLE "public".commission ( 
	"value"              double precision DEFAULT 0   
 );

CREATE  TABLE "public".marque ( 
	id_marque            integer DEFAULT nextval('marque_id_marque_seq'::regclass) NOT NULL  ,
	nom_marque           varchar(50)  NOT NULL  ,
	CONSTRAINT marque_pkey PRIMARY KEY ( id_marque )
 );

CREATE  TABLE "public".modele ( 
	id_modele            integer DEFAULT nextval('modele_id_modele_seq'::regclass) NOT NULL  ,
	nom_modele           varchar(50)  NOT NULL  ,
	CONSTRAINT modele_pkey PRIMARY KEY ( id_modele )
 );

CREATE  TABLE "public".users ( 
	id_user              integer DEFAULT nextval('users_id_user_seq'::regclass) NOT NULL  ,
	nom                  varchar(100)  NOT NULL  ,
	prenom               varchar(100)    ,
	mail                 varchar(100)  NOT NULL  ,
	contact              varchar(50)    ,
	"password"           varchar(100)    ,
	CONSTRAINT users_pkey PRIMARY KEY ( id_user )
 );

CREATE  TABLE "public".annonce ( 
	id_annonce           integer DEFAULT nextval('annonce_id_annonce_seq'::regclass) NOT NULL  ,
	date_heure_publication timestamp    ,
	user_id              integer  NOT NULL  ,
	prix                 double precision    ,
	CONSTRAINT annonce_pkey PRIMARY KEY ( id_annonce )
 );

CREATE  TABLE "public".annonce_photo ( 
	id_photo             integer DEFAULT nextval('annonce_photo_id_photo_seq'::regclass) NOT NULL  ,
	id_annonce           integer  NOT NULL  ,
	photo                varchar(250)    ,
	CONSTRAINT annonce_photo_pkey PRIMARY KEY ( id_photo )
 );

CREATE  TABLE "public".annonce_vendus ( 
	id_vendus            integer DEFAULT nextval('annonce_vendus_id_vendus_seq'::regclass) NOT NULL  ,
	id_annonce           integer  NOT NULL  ,
	date_vendus          date    ,
	CONSTRAINT annonce_vendus_pkey PRIMARY KEY ( id_vendus )
 );

CREATE  TABLE "public".detail_annonce ( 
	id_detail_annonce    integer DEFAULT nextval('detail_annonce_id_detail_annonce_seq'::regclass) NOT NULL  ,
	id_annonce           integer  NOT NULL  ,
	modele               integer  NOT NULL  ,
	categorie            integer  NOT NULL  ,
	marque               integer  NOT NULL  ,
	kilometrage          integer DEFAULT 0   ,
	date_achat           date    ,
	description          varchar(150)    ,
	CONSTRAINT detail_annonce_pkey PRIMARY KEY ( id_detail_annonce )
 );

CREATE  TABLE "public".favoris ( 
	id_favoris           integer DEFAULT nextval('favoris_id_favoris_seq'::regclass) NOT NULL  ,
	id_annonce           integer  NOT NULL  ,
	date_ajout           date    ,
	users                integer  NOT NULL  ,
	CONSTRAINT favoris_pkey PRIMARY KEY ( id_favoris ),
	CONSTRAINT unq_favoris_users UNIQUE ( users ) 
 );

CREATE  TABLE "public".message ( 
	id_message           integer DEFAULT nextval('message_id_message_seq'::regclass) NOT NULL  ,
	envoyeur             integer  NOT NULL  ,
	receveur             integer  NOT NULL  ,
	date_heure_envoie    timestamp    ,
	message              text    ,
	CONSTRAINT message_pkey PRIMARY KEY ( id_message )
 );

ALTER TABLE "public".annonce ADD CONSTRAINT annonce_user_id_fkey FOREIGN KEY ( user_id ) REFERENCES "public".users( id_user );

ALTER TABLE "public".annonce_photo ADD CONSTRAINT annonce_photo_id_annonce_fkey FOREIGN KEY ( id_annonce ) REFERENCES "public".annonce( id_annonce );

ALTER TABLE "public".annonce_vendus ADD CONSTRAINT annonce_vendus_id_annonce_fkey FOREIGN KEY ( id_annonce ) REFERENCES "public".annonce( id_annonce );

ALTER TABLE "public".detail_annonce ADD CONSTRAINT detail_annonce_id_annonce_fkey FOREIGN KEY ( id_annonce ) REFERENCES "public".annonce( id_annonce );

ALTER TABLE "public".detail_annonce ADD CONSTRAINT detail_annonce_categorie_fkey FOREIGN KEY ( categorie ) REFERENCES "public".categorie( id_categorie );

ALTER TABLE "public".detail_annonce ADD CONSTRAINT detail_annonce_marque_fkey FOREIGN KEY ( marque ) REFERENCES "public".marque( id_marque );

ALTER TABLE "public".detail_annonce ADD CONSTRAINT detail_annonce_modele_fkey FOREIGN KEY ( modele ) REFERENCES "public".modele( id_modele );

ALTER TABLE "public".favoris ADD CONSTRAINT favoris_id_annonce_fkey FOREIGN KEY ( id_annonce ) REFERENCES "public".annonce( id_annonce );

ALTER TABLE "public".favoris ADD CONSTRAINT fk_favoris_users FOREIGN KEY ( users ) REFERENCES "public".users( id_user );

ALTER TABLE "public".message ADD CONSTRAINT message_envoyeur_fkey FOREIGN KEY ( envoyeur ) REFERENCES "public".users( id_user );

ALTER TABLE "public".message ADD CONSTRAINT message_receveur_fkey FOREIGN KEY ( receveur ) REFERENCES "public".users( id_user );
