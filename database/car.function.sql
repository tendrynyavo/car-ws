CREATE OR REPLACE FUNCTION get_validate_annonce_by_year(_annee INT)
	RETURNS TABLE (
		annee numeric,
		mois VARCHAR,
		nbr_annonce_valide BIGINT
	) AS $$
	BEGIN
		RETURN QUERY
			SELECT 
				COALESCE(v.annee, _annee) AS annee,
				m.nom AS mois,
				COALESCE(v.nbr_annonce_valide, 0) AS nbr_annonce_valide
			FROM 
				(SELECT _annee AS annee) y
			CROSS JOIN 
				mois m
			LEFT JOIN 
				v_statistics_validate_month v ON m.nom = v.mois AND y.annee = v.annee
			ORDER BY 
				m.reference;
	END; $$ LANGUAGE plpgsql;
