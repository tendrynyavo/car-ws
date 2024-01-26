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
		extract( YEAR from a.date_annonce ) as year,
		a.valeur as annonce_etat
	from one_annonce_to_month as o_a_m
	left join annonce as a
	on extract ( month from a.date_annonce ) = o_a_m.reference
	group by o_a_m.nom, o_a_m.reference, extract(YEAR from a.date_annonce ), a.valeur
	order by o_a_m.reference;

-- Statistiques par mois
drop view if exists v_stats_month;
create or replace view v_stats_month
	as
		select
			v_s.nom, SUM(v_s.nbr_annonce) as total
		from v_stats as v_s
		group by v_s.nom, v_s.reference
		order by v_s.reference;

-- Validatation views ( Layah )
DROP VIEW IF EXISTS v_statistics_validate_month;
CREATE OR REPLACE VIEW v_statistics_validate_month
	AS
		SELECT 
			EXTRACT(YEAR FROM va.date_valide) AS annee,
			m.nom AS mois, 
			COALESCE(COUNT(va.id_annonce), 0) AS nbr_annonce_valide
		FROM 
			mois m 
		LEFT JOIN 
			valide va ON EXTRACT(MONTH FROM va.date_valide) = m.reference
		LEFT JOIN 
			annonce a ON va.id_annonce = a.id_annonce AND a.valeur = 30
		GROUP BY 
			annee, m.nom, m.reference
		ORDER BY 
			annee, m.reference;

-- statistique vente mois par an
create view vente_mois as
select vendu.*, EXTRACT(YEAR From date_vendu) annee, EXTRACT(Month from date_vendu) mois from vendu;

create view v_statistique_vente_mois as
select annee, mois, count(*) quantite from vente_mois group by annee, mois;

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
