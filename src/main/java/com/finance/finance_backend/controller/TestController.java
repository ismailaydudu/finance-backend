package com.finance.finance_backend.controller;

import com.finance.finance_backend.entity.Transaction;
import com.finance.finance_backend.repository.TransactionRepository;
import com.finance.finance_backend.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class TestController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/api/test")
    public Map<String, String> testMesaji() {
        return Map.of(
            "mesaj", "Selam İsmail! Backend mutfağı başarıyla ayağa kalktı, fırın yanıyor!",
            "durum", "Basarili"
        );
    }

    @GetMapping("/api/veri-ekle")
    public String veriEkle() {
        Transaction t1 = new Transaction();
        t1.setBaslik("Gece Yarısı Kahvesi");
        t1.setTutar(95.0);
        t1.setIslemTipi("GIDER");
        t1.setKategori("Gıda");
        
        // DÜZELTME: Artık LocalDate değil, LocalDateTime kullanıyoruz (Saat bilgisi eklendi)
        t1.setTarih(LocalDateTime.now());

        transactionRepository.save(t1);
        return "95 TL'lik kahve harcaması veritabanına başarıyla kaydedildi!";
    }

    @GetMapping("/api/verileri-getir")
    public List<Transaction> verileriGetir() {
        return transactionRepository.findAll();
    }

    @GetMapping("/api/kurlar")
    public Map<String, Object> kurlariGetir() {
        return currencyService.canliKurGetir();
    }

    @PostMapping("/api/islemler")
    public ResponseEntity<String> yeniIslemEkle(@RequestBody Map<String, Object> islem) {
        // Gelen veriden nesne oluştur
        Transaction yeniKayit = new Transaction();
        yeniKayit.setBaslik(islem.get("baslik").toString());
        yeniKayit.setTutar(Double.valueOf(islem.get("tutar").toString()));
        yeniKayit.setKategori(islem.get("kategori").toString());
        yeniKayit.setIslemTipi(islem.get("islemTipi").toString());
        
        // EFSANEVİ SAAT/TARİH YAKALAMA MOTORU
        if (islem.containsKey("tarih") && islem.get("tarih") != null) {
            String tarihStr = islem.get("tarih").toString();
            try {
                // Eğer Flutter'dan içinde "T" harfi olan tam bir tarih-saat gelirse
                if (tarihStr.contains("T")) {
                    yeniKayit.setTarih(LocalDateTime.parse(tarihStr));
                } 
                // Eğer sadece "2026-05-31" gibi gün gelirse, o günün şu anki saatini ekle
                else {
                    LocalDate sadeceGun = LocalDate.parse(tarihStr);
                    yeniKayit.setTarih(LocalDateTime.of(sadeceGun, LocalTime.now()));
                }
            } catch (Exception e) {
                // Parse hatası olursa sistem çökmesin, şu anki zamanı bassın
                yeniKayit.setTarih(LocalDateTime.now());
            }
        } else {
            yeniKayit.setTarih(LocalDateTime.now()); 
        }

        // Veritabanına kaydet
        transactionRepository.save(yeniKayit);

        System.out.println("---- VERİTABANINA KAYDEDİLDİ: " + yeniKayit.getBaslik() + " ----");
        return ResponseEntity.ok("İşlem başarıyla kaydedildi!");
    }
}