package com.finance.finance_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hedefler")
public class TasarrufHedefi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String baslik;
    private Double hedefTutar;
    private Double birikenTutar;
    private LocalDate sonTarih;
    private String gorselYolu;
    private String renkKodu;

    // Boş constructor (JPA için şart)
    public TasarrufHedefi() {}

    // Getter ve Setterlar
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBaslik() { return baslik; }
    public void setBaslik(String baslik) { this.baslik = baslik; }

    public Double getHedefTutar() { return hedefTutar; }
    public void setHedefTutar(Double hedefTutar) { this.hedefTutar = hedefTutar; }

    public Double getBirikenTutar() { return birikenTutar; }
    public void setBirikenTutar(Double birikenTutar) { this.birikenTutar = birikenTutar; }

    public LocalDate getSonTarih() { return sonTarih; }
    public void setSonTarih(LocalDate sonTarih) { this.sonTarih = sonTarih; }

    public String getGorselYolu() { return gorselYolu; }
    public void setGorselYolu(String gorselYolu) { this.gorselYolu = gorselYolu; }

    public String getRenkKodu() { return renkKodu; }
    public void setRenkKodu(String renkKodu) { this.renkKodu = renkKodu; }

    
}