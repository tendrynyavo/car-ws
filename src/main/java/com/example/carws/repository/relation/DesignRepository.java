package com.example.carws.repository.relation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.carws.model.primaire.relation.*;
import com.example.carws.model.primaire.*;

public interface DesignRepository extends JpaRepository< Design, Integer >{

}