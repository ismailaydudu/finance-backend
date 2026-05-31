package com.finance.finance_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String baslik; // Örn: Freelance Proje, Kahve, Market Alışverişi
    private Double tutar;
    private String islemTipi; // "GELIR" veya "GIDER"
    private String kategori; // Fatura, Gıda, Eğlence vs.
    
    // İŞTE HATALARI YOK EDEN KISIM: Artık LocalDateTime
    private LocalDateTime tarih; 

    // JPA'nın zorunlu kıldığı boş yapıcı metod (Constructor)
    public Transaction() {
    }

    // --- GETTER VE SETTER METOTLARI ---

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

    public LocalDateTime getTarih() {
        return tarih;
    }

    public void setTarih(LocalDateTime tarih) {
        this.tarih = tarih;
    }
}