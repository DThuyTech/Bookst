package com.example.book.Model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


@Table(name="userroleid")
public class UserRoleId implements Serializable{
    @Column(name ="user_id")
    private Integer user;
    @Column(name ="role_id")

    private Integer role;
}