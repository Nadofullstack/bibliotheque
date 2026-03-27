package com.example.bibliotheque.repository;

import com.example.bibliotheque.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {

}