package com.example.bibliotheque.service;

import com.example.bibliotheque.model.Book;
import com.example.bibliotheque.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // Iinjection du repository via le constructeur
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // tous les livres
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // par id
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // creer un livre
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // modifier un livre
    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setAvailable(updatedBook.isAvailable());
            return bookRepository.save(book);
        }).orElseThrow(() -> new RuntimeException("livre non trouvé"));
    }

    // supprimer un livre
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}