package com.example.bibliotheque.service;

import com.example.bibliotheque.model.Loan;
import com.example.bibliotheque.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan borrowBook(Loan loan) {
        loan.setLoanDate(LocalDate.now());
        loan.setReturnDate(null); // non retourné
        return loanRepository.save(loan);
    }

    public Loan returnBook(Long id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        loan.setReturnDate(LocalDate.now()); // retourné

        return loanRepository.save(loan);
    }
}
