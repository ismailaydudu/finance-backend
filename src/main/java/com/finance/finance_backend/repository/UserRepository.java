package com.finance.finance_backend.repository;

import com.finance.finance_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * E-posta adresine göre kullanıcıyı veritabanında arar.
     * Optional kullanmamızın sebebi, kullanıcı bulunamadığında 
     * null pointer hatası almanı engellemektir.
     */
    Optional<User> findByEmail(String email);

    /**
     * Alternatif olarak isimle arama yapmak istersen 
     * (Giriş ekranında isim kullanacaksan bunu da ekleyebilirsin):
     */
    Optional<User> findByIsim(String isim);
}