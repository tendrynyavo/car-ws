package com.example.carws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carws.model.users.Role;
import com.example.carws.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public void enregistrer(Role role) throws Exception {
        this.roleRepository.save(role);
    }

    public List<Role> getListeRoles() throws Exception {
        return this.roleRepository.findAll();
    }

}
