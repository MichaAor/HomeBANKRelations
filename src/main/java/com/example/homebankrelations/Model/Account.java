package com.example.homebankrelations.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idA")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idA;
    private Long accountN;
    private Long cbu;
    private String alias;
    private float balance;

     /*
        ?OneToOne: No posee conocimiento de la otra entidad
    */

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idU")
    private User user;

    public void addUser(Long idU){
        User userAdd = new User();
        userAdd.setIdU(idU);
        this.setUser(userAdd);
    }
}
