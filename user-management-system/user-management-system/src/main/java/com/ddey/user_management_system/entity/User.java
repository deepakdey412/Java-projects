package com.ddey.user_management_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false) // DB: not null
    @NotBlank(message = "Name is required.")      // Validation: not blank
    @Size(min = 3, max = 50)                      // Validation: length
    private String name;

    @Column(name = "user_email", nullable = false, unique = true) // DB: not null, unique
    @NotBlank(message = "Email is required.")                     // Validation: not blank
    @Email(message = "Enter a valid email")                       // Validation: valid email
    private String email;

    @Column(name = "user_password", nullable = false) // DB: not null
    @NotBlank(message = "Password is required.")     // Validation: not blank
    @Size(min = 6, max = 100)                        // Validation: length
    private String password;

    public User() {}
    public User(Long id, String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
