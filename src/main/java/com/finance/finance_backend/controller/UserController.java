package com.finance.finance_backend.controller;

import com.finance.finance_backend.entity.User;
import com.finance.finance_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") // Flutter'dan erişim için önemli
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        try {
            String email = loginData.get("email");
            
            if (email == null || email.isEmpty()) {
                return ResponseEntity.badRequest().body("E-posta alanı boş olamaz.");
            }

            Optional<User> user = userRepository.findByEmail(email);
            
            if (user.isPresent()) {
                // Kullanıcı bulundu, tüm kullanıcı nesnesini dönüyoruz
                return ResponseEntity.ok(user.get());
            } else {
                // Kullanıcı yoksa 401 Unauthorized dönüyoruz
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Kullanıcı bulunamadı.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Sunucu hatası: " + e.getMessage());
        }
    }

    @PostMapping("/register")
public ResponseEntity<?> register(@RequestBody User newUser) {
    // Basitçe kaydet ve dön
    User savedUser = userRepository.save(newUser);
    return ResponseEntity.ok(savedUser);
}
}