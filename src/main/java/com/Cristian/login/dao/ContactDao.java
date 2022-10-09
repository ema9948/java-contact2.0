package com.Cristian.login.dao;

import com.Cristian.login.models.Contacto;

import java.util.List;

public interface ContactDao {

    List<Contacto> list(Long id);
    Boolean agregar(Contacto contacto);
    Long eliminar(Long id);
    Contacto update(Contacto contacto);


}
