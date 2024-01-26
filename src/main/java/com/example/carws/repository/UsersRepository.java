package com.example.carws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.carws.model.users.Users;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, String> {
    @Query(value="select * from utilisateur where email = :email and  mot_de_passe = :password", nativeQuery = true)
    Optional<Users> getUsersByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}