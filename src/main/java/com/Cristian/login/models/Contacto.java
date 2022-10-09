package com.Cristian.login.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "contacto")
@ToString @EqualsAndHashCode
public class Contacto {

    @Id
    @Getter @Setter
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name  = "user_id")
    @Setter @Getter
    private Long user_id;

    @Setter @Getter
    @Column(name = "nombre")
    private String nombre;

    @Setter @Getter
    @Column(name = "telefono")
    private String telefono;

}
