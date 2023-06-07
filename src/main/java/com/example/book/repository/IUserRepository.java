package com.example.book.repository;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.book.Model.user;

import jakarta.transaction.Transactional;

public interface IUserRepository extends JpaRepository<user,Long> {
    @Query("SELECT u FROM user u WHERE u.username=?1")
    user findByUsername(String username);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_role(user_id,role_id)"+ "VALUES (?1,?2)",nativeQuery = true)
    void addRoleToUser(Long userId,Long roleId);
    @Query("SELECT u.id from user u where u.username =?1")
    Long getUserIdByUsername(String username);

    @Query(value = "Select r.name from role r INNER JOIN user_role ur"+"ON r.id = ur.role_id WHERE ur.role_id WHERE ur.user_id=?1",nativeQuery = true)
    String[] getRolesOfUser(Long userId);
}
