package com.example.book.Model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "role")
public class role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length=50,nullable = false)
    @NotEmpty(message = "name không được để trống")
    @Size(max = 50, message = "name không vượt quá 50 ký tự")
    private String name;
    @Column(name = "description", length=250)
    @Size(max = 50, message = "description không vượt quá 50 ký tự")
    private String description;
    
    @Fetch(FetchMode.JOIN)
    @ManyToMany(mappedBy = "roles")
    private Set<user> users = new HashSet<>();

    public Long getId() {
        return id;
    }

    public role(Long id,
        @NotEmpty(message = "name không được để trống") @Size(max = 50, message = "name không vượt quá 50 ký tự") String name,
        @Size(max = 50, message = "description không vượt quá 50 ký tự") String description, Set<user> users) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.users = users;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<user> getUsers() {
        return users;
    }

    public void setUsers(Set<user> users) {
        this.users = users;
    }
    
    public role() {
    }

}
