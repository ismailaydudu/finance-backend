package com.finance.finance_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getFinansalSkor() {
        return finansalSkor;
    }

    public void setFinansalSkor(Double finansalSkor) {
        this.finansalSkor = finansalSkor;
    }

    private String isim;
    private String email;
    private Double finansalSkor;

    // Boş Constructor (JPA'nın çalışması için zorunludur)
    public User() {
    }

    // VS Code'da kodun içine sağ tıklayıp "Source Action" -> "Generate Getters and Setters" 
    // diyerek bu değişkenlerin getter/setter metodlarını otomatik olarak buraya ekleyebilirsin.
}
