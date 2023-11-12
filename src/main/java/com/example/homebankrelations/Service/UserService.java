package com.example.homebankrelations.Service;

import com.example.homebankrelations.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Long idU);
    User saveOrUpd(User user);
    boolean deleteById(Long id);
}
