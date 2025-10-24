package com.ddey.user_management_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {
    @NotBlank(message = "Name is required.")      // Validation: not blank
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.") // Validation: length
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only letters") // Validation: only letters and space
    // @Pattern → Bean Validation annotation, checks if field matches given regex
    // regexp = "^[a-zA-Z ]+$"
    // ^ → string start
    // [a-zA-Z ] → only lowercase (a-z), uppercase (A-Z), and space allowed
    // + → one or more characters
    // $ → string end
    private String name;

    @NotBlank(message = "Email is required.")       // Validation: not blank
    @Email(message = "Enter a valid email")         // Validation: valid email
    private String email;

    @NotBlank(message = "Password is required.")     // Validation: not blank
    @Size(min = 6, max = 100)                        // Validation: length
    private String password;

    private String role; // Admin / Teacher / Student

    public UserRequestDTO() {
    }

    public UserRequestDTO(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // getters & setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }


}

