package com.example.homebankrelations.Controller;

import com.example.homebankrelations.Model.Account;
import com.example.homebankrelations.Model.User;
import com.example.homebankrelations.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiHB/users")
public class UserController {
    @Autowired
    private UserService us;

    /*
        *ADMIN CONTROLLERS
    */

    @GetMapping
    ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(us.findAll());
    }

    @GetMapping("/{idU}")
    ResponseEntity<User> findById(@PathVariable("idU")Long idU){
        Optional<User> optUs = us.findById(idU);
        if(optUs.isPresent()){
            return ResponseEntity.ok(optUs.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

   @GetMapping("/dni/{dni}")
   ResponseEntity<User> findByDni(@PathVariable("dni")String dni){
       Optional<User> optUs = us.findByDNI(dni);
       if(optUs.isPresent()){
           return ResponseEntity.ok(optUs.get());
       }else{
           return ResponseEntity.notFound().build();
       }
   }
/*
 * SAVES
 */

    @PostMapping()
    ResponseEntity<User> saveOneToOne(@RequestBody User user){
        User userSaved = us.saveOrUpd(user);
        if(userSaved != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

//    @PutMapping("/{idU}")
//    ResponseEntity<User> update(@RequestBody User user,@PathVariable("idU")Long idU){
//        user.setIdU(idU);
//        User userUpd = us.saveOrUpd(user, account);
//        if(! user.equals(userUpd)){
//            return ResponseEntity.ok(userUpd);
//        }else{
//            return ResponseEntity.notFound().build();
//        }
//    }

    @DeleteMapping("/{idU}")
    ResponseEntity<?> deleteById(@PathVariable("idU")Long idU){
        return (us.deleteById(idU))?
                ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

   @DeleteMapping("/{dni}")
   ResponseEntity<?> deleteByDni(@PathVariable("dni")String dni){
       return (us.deleteByDNI(dni))?
               ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
   }
}
