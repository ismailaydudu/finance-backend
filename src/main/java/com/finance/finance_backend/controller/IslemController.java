package com.finance.finance_backend.controller;

import com.finance.finance_backend.entity.FinansalIslem;
import com.finance.finance_backend.repository.IslemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/islemler")
@CrossOrigin(origins = "*") // Mobilden bağlantı izni için çok kritik
public class IslemController {

    @Autowired
    private IslemRepository islemRepository;

    // Flutter'dan gelen yeni işlemi kaydeder (POST)
    @PostMapping
    public ResponseEntity<FinansalIslem> islemEkle(@RequestBody FinansalIslem islem) {
        try {
            FinansalIslem yeniIslem = islemRepository.save(islem);
            return ResponseEntity.ok(yeniIslem);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Tüm gelir ve giderleri liste olarak döner (GET)
    @GetMapping
    public List<FinansalIslem> islemleriGetir() {
        return islemRepository.findAll();
    }

    // İşlemi ID'ye göre silmek istersen (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> islemSil(@PathVariable Long id) {
        if (islemRepository.existsById(id)) {
            islemRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}