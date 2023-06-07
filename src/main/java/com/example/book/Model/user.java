package com.example.book.Model;
import com.example.book.validator.annotation.ValidUsername;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Data
@Entity
@Getter
@Setter
@Table(name = "user")
public class user {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "username", length = 50, nullable = false, unique = true)
@NotBlank(message = "Username is required")
@Size(max = 50, message = "Username must be less than 50 characters")
@ValidUsername
private String username;
@Column(name = "password", length = 250, nullable = false)
@NotBlank(message = "Password is required")
private String password;
@Column(name = "email", length = 50)
@Size(max = 50, message = "Email must be less than 50 characters")
private String email;
@Column(name = "name", length = 50, nullable = false)
@Size(max = 50, message = "Your name must be less than 50 characters")
@NotBlank(message = "Your name is required")
private String name;
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
private List<Book> books = new ArrayList<>();

public void setRoles(Set<role> roles) {
    this.roles = roles;
}
@Fetch(FetchMode.JOIN)
@ManyToMany()
@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
private Set<role> roles = new HashSet<>();

    public Long getId(){
        return this.id;
    }
    public String getPassword(){
        return this.password;
    }
    public String getUsername(){
        return this.username;
    }
}
