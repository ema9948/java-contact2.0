package com.Cristian.login.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

@Entity
@Table(name = "user")
@ToString @EqualsAndHashCode
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    @Column(name = "nombre" )
    private  String nombre;

    @Getter @Setter
    @Column(name = "email")
    private String email;

    @Getter @Setter
    @Column(name = "password")
    private String password;


}
