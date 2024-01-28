package com.example.carws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.carws.model.users.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

    // @Query(value = "select id, role from liste_role_users_valide where id_user = :idUser order by role", nativeQuery = true)
    // public List<Role> getRoles(@Param("idUser") String idUser);


}