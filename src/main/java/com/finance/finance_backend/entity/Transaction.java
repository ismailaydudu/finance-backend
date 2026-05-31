package com.finance.finance_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public Double getTutar() {
        return tutar;
    }

    public void setTutar(Double tutar) {
        this.tutar = tutar;
    }

    public String getIslemTipi() {
        return islemTipi;
    }

    public void setIslemTipi(String islemTipi) {
        this.islemTipi = islemTipi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public LocalDate getTarih() {
        return tarih;
    }

    public void setTarih(LocalDate tarih) {
        this.tarih = tarih;
    }

    private String baslik; // Örn: Freelance Proje, Kahve, Market Alışverişi
    private Double tutar;
    private String islemTipi; // "GELIR" veya "GIDER"
    private String kategori; // Fatura, Gıda, Eğlence vs.
    private LocalDate tarih;

    // JPA'nın zorunlu kıldığı boş yapıcı metod (Constructor)
    public Transaction() {
    }

    // Tıpkı User sınıfında yaptığın gibi sağ tıklayıp 
    // "Source Action" -> "Generate Getters and Setters" ile kapıları eklemeyi unutma!
}
