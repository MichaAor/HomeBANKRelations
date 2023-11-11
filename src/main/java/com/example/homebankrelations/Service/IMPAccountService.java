package com.example.homebankrelations.Service;

import com.example.homebankrelations.Model.Account;
import com.example.homebankrelations.Repository.AccountRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IMPAccountService implements AccountService {
    @Autowired
    private AccountRepo ar;

    
    /*
        ? ADMIN SERVICES
    */

    @Override
    public List<Account> findAll() {
        return ar.findAll();
    }

    @Override
    public Optional<Account> findById(Long idA) {
        return ar.findById(idA);
    }

    @Override
    @Transactional
    public Account saveOrUpd(Account account) {
        if(!(ar.existsByAccountN(account.getAccountN()) &&
                ar.existsByCbu(account.getCbu()) &&
                ar.existsByAlias(account.getAlias()))){

        }

        if(account.getIdA() != null){
            Optional<Account> accountExist = ar.findById(account.getIdA());
            if(accountExist.isPresent()){
                Account accountToUpd = accountExist.map(acc -> {
                    acc.setIdA(account.getIdA());
                    acc.setAccountN(account.getAccountN());
                    acc.setCbu(account.getCbu());
                    acc.setAlias(account.getAlias());
                    acc.setBalance(account.getBalance());
                        return acc;
                }).get();
                return ar.save(accountToUpd);
            }else {
                return ar.save(account);
            }
        }
        return ar.save(account);
    }

    @Override
    public boolean deleteById(Long idA) {
        ar.deleteById(idA);
        return ar.existsById(idA);
    }
}
