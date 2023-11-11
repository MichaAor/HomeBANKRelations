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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idU")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idU;
    private String name;
    private String surname;
    private String dni;

     /*
        ?OneToOne -UNIDIRECCIONAL- Usa anotación simple, puede usar propiedades como cascade,fetch,optional
        ?Es posible utilizar el método 'addAccount' para facilitar el mergeo de entidades.
        !Ejemplo
        *   @OneToOne
        *   private Account account;
    */


    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Account account;
}