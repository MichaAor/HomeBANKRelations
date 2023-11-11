package com.example.homebankrelations.Repository;

import com.example.homebankrelations.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByDni(String dni);
    void deleteByDni(String dni);
    boolean existsByDni(String dni);
}

