package com.finance.finance_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "islemler")
public class FinansalIslem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String baslik;
    private Double tutar;
    private String islemTipi; // "GELIR" veya "GIDER"

    // JPA için boş constructor şart
    public FinansalIslem() {}

    public FinansalIslem(String baslik, Double tutar, String islemTipi) {
        this.baslik = baslik;
        this.tutar = tutar;
        this.islemTipi = islemTipi;
    }

    // Getter ve Setter Metotları
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBaslik() { return baslik; }
    public void setBaslik(String baslik) { this.baslik = baslik; }

    public Double getTutar() { return tutar; }
    public void setTutar(Double tutar) { this.tutar = tutar; }

    public String getIslemTipi() { return islemTipi; }
    public void setIslemTipi(String islemTipi) { this.islemTipi = islemTipi; }
}