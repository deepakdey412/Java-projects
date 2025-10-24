package com.ddey.user_management_system.dto;

public class UserResponseDTO {
    private Long id;        // unique user ID
    private String name;    // user name
    private String email;   // user email
    private String role;    // Admin / Teacher / Student

    // ✅ Default constructor (required for frameworks like Jackson)
    public UserResponseDTO() {
    }

    // ✅ Parameterized constructor (for easy object creation)
    public UserResponseDTO(Long id, String name, String email, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    // ✅ Getters and Setters
    public Long getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
