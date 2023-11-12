package com.example.homebankrelations.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
// import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
// @NoArgsConstructor
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
    ? Relación: OneToOne  
    ? Tipo: UNIDIRECCIONAL  
    ? Detalles: Usa anotación simple, puede usar propiedades como cascade,fetch,optional
    !Ejemplo
    *   @OneToOne
    *   private Account account;
*/

/*
    ? Relación: OneToOne  
    ? Tipo: BIDIRECCIONAL  
    ? Rol: Inversor.  
    ? Propiedades: 
    ?    *mappedBy: Indica el campo en la entidad inversa que mapea la relación, 
    ?               eliminando la necesidad de una columna adicional en la base de datos.
    ?    *cascade: Indica cómo se deben propagar las operaciones de persistencia desde la entidad propietaria 
    ?              hacia la entidad relacionada  
    ?    *fetch - LAZY: 
    ?            + especifica la estrategia de recuperación de datos al cargar una entidad y sus relaciones
    ?              asociadas desde la base de datos.
    ?            + Retrasa la carga de la relación hasta que sea explícitamente accedida
    !Ejemplo
    *   @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    *   private Account account;
*/

/*
    ? Relación: OneToMany  
    ? Tipo: UNIDIRECCIONAL  
    ? Detalle: 
    ?   +Se crea una tabla intermedia con las pk de ambas entidades. No afecta los métodos 'find'. 

    !Ejemplo
    !   Para un manejo mas eficiente, se inicializa el List en el constructor vació.
    !   Formulo un método addAccount partiendo solamente de id del Account a asociar.
    
    *   @OneToMany
    *   private List<Account> accounts;

    *   public User(){
    *       this.accounts = new ArrayList<>();
    *   }

    *   public void addAccount(Long idA){
    *       Account acc = new Account();
    *       acc.setIdA(idA);
    *       this.getAccounts().add(acc);
    *   }
*/

    @OneToMany
    private List<Account> accounts;

    public User(){
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Long idA){
        Account acc = new Account();
        acc.setIdA(idA);
        this.getAccounts().add(acc);
    }
}