package com.example.homebankrelations.Service;

import com.example.homebankrelations.Model.User;
import com.example.homebankrelations.Repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class IMPUserService implements UserService {
    @Autowired
    private UserRepo ur;
    
    /*
        ? ADMIN SERVICES
    */

    @Override
    public List<User> findAll() {
        return ur.findAll();
    }

    @Override
    public Optional<User> findById(Long idU) {
        return ur.findById(idU);
    }

    @Override
    @Transactional
    public User saveOrUpd(User userNew) {
        if(userNew.getIdU() != null){
            Optional<User> userExist = ur.findById(userNew.getIdU());
            if(userExist.isPresent()){
                User userToUpd = userExist.map(us -> {
                                                    us.setIdU(userNew.getIdU());
                                                    us.setName(userNew.getName());
                                                    us.setSurname(userNew.getSurname());
                                                    us.setDni(userNew.getDni());
                                                return us;
                                                    }).get();
                return ur.save(userToUpd);
            }else {
                return ur.save(userNew);
            }
        }
        return ur.save(userNew);
    }

    @Override
    public boolean deleteById(Long id) {
        ur.deleteById(id);
    return ur.existsById(id);
    }
}
