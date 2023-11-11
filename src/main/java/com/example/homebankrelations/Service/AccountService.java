package com.example.homebankrelations.Service;

import com.example.homebankrelations.Model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> findAll();
    Optional<Account> findById(Long idA);
    Account saveOrUpd(Account account);
    boolean deleteById(Long idA);
}
