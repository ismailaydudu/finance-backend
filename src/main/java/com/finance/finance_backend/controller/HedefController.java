package com.finance.finance_backend.controller;

import com.finance.finance_backend.entity.TasarrufHedefi;
import com.finance.finance_backend.repository.HedefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hedefler")
@CrossOrigin(origins = "*") // Flutter'ın IP engeline takılmaması için şart
public class HedefController {

    @Autowired
    private HedefRepository hedefRepository;

    // Yeni hedef ekleme (POST)
    @PostMapping
    public ResponseEntity<?> hedefEkle(@RequestBody TasarrufHedefi yeniHedef) {
        try {
            TasarrufHedefi kaydedilen = hedefRepository.save(yeniHedef);
            return ResponseEntity.ok(kaydedilen);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Hata: " + e.getMessage());
        }
    }

    // Tüm hedefleri listeleme (GET)
    @GetMapping
    public List<TasarrufHedefi> hedefleriGetir() {
        return hedefRepository.findAll();
    }

    
}