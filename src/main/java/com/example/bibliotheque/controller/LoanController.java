package com.example.bibliotheque.controller;

import com.example.bibliotheque.model.Loan;
import com.example.bibliotheque.service.LoanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
@CrossOrigin
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public Loan borrowBook(@RequestBody Loan loan) {
        return loanService.borrowBook(loan);
    }

    @PutMapping("/{id}/return")
    public Loan returnBook(@PathVariable Long id) {
        return loanService.returnBook(id);
    }
}
