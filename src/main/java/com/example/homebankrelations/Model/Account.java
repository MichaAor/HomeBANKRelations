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
    ? Relación: OneToOne  
    ? Tipo: UNIDIRECCIONAL  
    ? Detalle: No posee conocimiento de la otra entidad
*/

/*
    ? Relación: OneToOne  
    ? Tipo: BIDIRECCIONAL  
    ? Rol: Propietario.  
    ? Propiedades: 
    ?    *fetch - EAGER: Carga la relación automáticamente junto con la entidad propietaria.
    ?    *@JoinColumn: especifica la columna de la base de datos que se utilizará como clave foránea 
    ?       para establecer la relación entre dos entidades.

    !Ejemplo : Anotación y declaración junto a un método sencillo para vincular ambas entidades.
    !   Donde se tiene(o se guarda primero) los users para luego guardar cuentas con el idU a vincular

    *   @OneToOne(fetch = FetchType.EAGER)
    *   @JoinColumn(name = "idU")
    *   private User user;

    *   public void addUser(Long idU){
    *       User userAdd = new User();
    *       userAdd.setIdU(idU);
    *       this.setUser(userAdd);
    *   }
*/

/*
    ? Relación: ManyToOne 
    ? Tipo: UNIDIRECCIONAL  
    ? Detalle: No posee conocimiento de la otra entidad
*/

/*
    ? Relación: ManyToOne  
    ? Tipo: BIDIRECCIONAL  
    ? Rol: Propietario.  
    ? Propiedades: 
    ?    *fetch - EAGER: Carga la relación automáticamente junto con la entidad propietaria.
    ? Detalle: Para problemas de serializacion, consultar el modulo.

    !Ejemplo : Anotación y declaración junto a un método sencillo para vincular ambas entidades.
    !   Donde se tiene(o se guarda primero) los users para luego guardar cuentas con el idU a vincular

    *   @ManyToOne(fetch = FetchType.EAGER)
    *   private User user;
    *
    *   public void addUser(Long idU){
    *       User user = new User();
    *       user.setIdU(idU);
    *       this.setUser(user);
    *   }
*/

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "idA",referencedColumnName = "idA")
              ,inverseJoinColumns = @JoinColumn(name = "idU",referencedColumnName = "idU"))
    private List<User> users;

    public Account(){
        this.users = new ArrayList<>();
    }

    public void addUser(Long idU){
        User user = new User();
        user.setIdU(idU);
        this.getUsers().add(user);
    }
}
