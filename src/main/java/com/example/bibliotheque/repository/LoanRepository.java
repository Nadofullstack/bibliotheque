package com.example.bibliotheque.repository;

import com.example.bibliotheque.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}