insert into categorie ( nom_categorie ) values ('Camion');
insert into categorie ( nom_categorie ) values ('Plaisir');
insert into categorie ( nom_categorie ) values ('Taxi');

insert into etats (id, nom ) values (10, 'en attente');
insert into etats (id, nom ) values (20, 'supprimer');
insert into etats (id, nom ) values (30, 'validee');
insert into etats (id, nom ) values (40, 'favorie');
insert into etats (id, nom ) values (50, 'vendu');

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

db.discussions.find({$or:[{ idEnvoyeur: "eTLPHjKBKTUyMQ2UCJ0UYSQBx5g1", idReceveur: "aRU7yww5lgZ6eDev3iJ95SKgmAA3" },{ idEnvoyeur: "aRU7yww5lgZ6eDev3iJ95SKgmAA3", idReceveur: "eTLPHjKBKTUyMQ2UCJ0UYSQBx5g1" }]}).sort({ dateHeureEnvoie: 1 })


db.discussions.aggregate([
    {
        $match: {
            $or: [
                { idEnvoyeur: "aRU7yww5lgZ6eDev3iJ95SKgmAA3" },
                { idReceveur: "aRU7yww5lgZ6eDev3iJ95SKgmAA3" }
            ]
        }
    },
    {
        $group: {
            _id: {
                idEnvoyeur: "$idEnvoyeur",
                idReceveur: "$idReceveur"
            },
            discussions: { $push: "$$ROOT" }
        }
    }
]);

db.discussions.aggregate([
    {
        $match: {
            $or: [
                { idEnvoyeur: "aRU7yww5lgZ6eDev3iJ95SKgmAA3" },
                { idReceveur: "aRU7yww5lgZ6eDev3iJ95SKgmAA3" }
            ]
        }
    },
    {
        $group: {
            _id: {
                idEnvoyeur: "$idEnvoyeur",
                idReceveur: "$idReceveur"
            },
            discussions: { $push: "$$ROOT" }
        }
    },
    {
        $project: {
            _id: 0,
            idEnvoyeur: "$_id.idEnvoyeur",
            idReceveur: "$_id.idReceveur"
        }
    }
]);

db.discussions.aggregate([
    {
        $match: {
            $or: [
                { idEnvoyeur: "aRU7yww5lgZ6eDev3iJ95SKgmAA3" },
                { idReceveur: "aRU7yww5lgZ6eDev3iJ95SKgmAA3" }
            ]
        }
    },
    {
        $addFields: {
            newIdEnvoyeur: {
                $cond: {
                    if: { $eq: ["$idEnvoyeur", "aRU7yww5lgZ6eDev3iJ95SKgmAA3"] },
                    then: "$idReceveur",
                    else: "$idEnvoyeur"
                }
            }
        }
    },
    {
        $group: {
            _id: {
                idEnvoyeur: "$newIdEnvoyeur",
                idReceveur: "$idReceveur"
            },
            discussions: { $push: "$$ROOT" }
        }
    },
    {
        $project: {
            _id: 0,
            idEnvoyeur: "$_id.idEnvoyeur",
        }
    }
]);


db.discussions.aggregate([
    {
        $match: {
            $or: [
                { idEnvoyeur: "aRU7yww5lgZ6eDev3iJ95SKgmAA3" },
                { idReceveur: "aRU7yww5lgZ6eDev3iJ95SKgmAA3" }
            ]
        }
    },
    {
        $addFields: {
            idEnvoyeur: {
                $cond: {
                    if: { $eq: ["$idEnvoyeur", "aRU7yww5lgZ6eDev3iJ95SKgmAA3"] },
                    then: "$idReceveur",
                    else: "$idEnvoyeur"
                }
            },
            idReceveur: {
                $cond: {
                    if: { $eq: ["$idReceveur", "aRU7yww5lgZ6eDev3iJ95SKgmAA3"] },
                    then: "$idEnvoyeur",
                    else: "$idReceveur"
                }
            }
        }
    },
    {
        $group: {
            _id: {
                idEnvoyeur: "$idEnvoyeur",
                idReceveur: "$idReceveur"
            }
        }
    },
    {
        $project: {
            _id: 0,
            idEnvoyeur: "$_id.idEnvoyeur",
            idReceveur: "$_id.idReceveur"
        }
    }
]);


-- pour un utilisateur
db.discussions.aggregate([
    {
        $match: {
            $or: [
                { idEnvoyeur: "T1YpCelZGHSkrLLniqfYYwlip113" },
                { idReceveur: "T1YpCelZGHSkrLLniqfYYwlip113" }
            ]
        }
    },
    {
        $addFields: {
            newIdEnvoyeur: {
                $cond: {
                    if: { $eq: ["$idEnvoyeur", "T1YpCelZGHSkrLLniqfYYwlip113"] },
                    then: "$idReceveur",
                    else: "$idEnvoyeur"
                }
            }
        }
    },
    {
        $group: {
            _id: {
                idEnvoyeur: "$newIdEnvoyeur",
                idReceveur: "$idReceveur"
            },
            discussions: { $push: "$$ROOT" }
        }
    },
    {
        $project: {
            _id: 0,
            idEnvoyeur: "$_id.idEnvoyeur"
        }
    },
    {
        $group: {
            _id: "$idEnvoyeur"
        }
    },
    {
        $project: {
            _id: 0,
            idEnvoyeur: "$_id"
        }
    }
]);

insert into role values ('ADMIN', 'Administrateur'), ('USER', 'Client');
insert into roles_user (id_user, roles_id) values ('Vo9M3bvgthYy1zUfklqUqrf4C8a2', 'ADMIN');

CREATE OR REPLACE FUNCTION get_statistique_vente_mois(annee_donne INT)
RETURNS TABLE (mois INT, quantite bigint) AS
$$
BEGIN
    RETURN QUERY 
    SELECT m.mois, COALESCE(v.quantite, 0) AS quantite
    FROM generate_series(1, 12) AS m(mois)
    LEFT JOIN v_statistique_vente_mois v 
    ON m.mois = v.mois AND v.annee = annee_donne
    ORDER BY m.mois;
END;
$$
LANGUAGE PLPGSQL;

-- liste des discussions d'un utilisateur
db.discussions.aggregate([
    {
        $match: {
            $or: [
                { idEnvoyeur: "USER2" },
                { idReceveur: "USER2" }
            ]
        }
    },
    { $sort: { dateHeureEnvoie: -1 } },
    {
        $group: {
            _id: {
                $cond: [
                    { $eq: ["$idEnvoyeur", "USER2"] },
                    "$idReceveur",
                    "$idEnvoyeur"
                ]
            },
            idEnvoyeur: { $first: "$idEnvoyeur" },
            dateHeureEnvoie: { $first: "$dateHeureEnvoie" },
            dernierMessage: { $first: "$message" },
            dernierStatus: { $first: "$status" },
            nombreMessagesNonLu: {
                $sum: {
                    $cond: [{ $eq: ["$status", 1] }, 1, 0]
                }
            }
        }
    },
    {
        $project: {
            _id: 1,
            idEnvoyeur: 1,
            dateHeureEnvoie: 1,
            dernierMessage: 1,
            dernierStatus: 1,
            nombreMessagesNonLu: 1,
        }
    }
]);
