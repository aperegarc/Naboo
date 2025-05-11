package com.naboo.primera_fase.DTO;

public class UserDTO {

    private int id; // ID único del usuario
    private String name; // Nombre del usuario
    private String email; // Correo electrónico del usuario
    private String role; // Rol del usuario (ADMIN, HOSTELERO, PROVEEDOR)
    private String nif; // Número de identificación fiscal (si aplica)
    private String phoneNumber; // Número de teléfono del usuario

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}