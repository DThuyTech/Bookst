package com.example.book.repository;

import javax.management.relation.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.book.Model.role;

public interface IRoleRepository extends JpaRepository<role,Long> {
    @Query("SELECT r.id from  role r where r.name = ?1")
    Long getRoleIdByName(String roleName);
}
