package com.finance.finance_backend.repository;

import com.finance.finance_backend.entity.FinansalIslem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IslemRepository extends JpaRepository<FinansalIslem, Long> {
    // JpaRepository sayesinde save, findAll, delete gibi metodlar otomatik gelir.
}