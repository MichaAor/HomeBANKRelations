package com.example.homebankrelations.Repository;

import com.example.homebankrelations.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {
    boolean existsByAccountN(Long accountN);
    boolean existsByCbu(Long cbu);
    boolean existsByAlias(String alias);
    Optional<Account> findByAccountN(Long accountN);
}
