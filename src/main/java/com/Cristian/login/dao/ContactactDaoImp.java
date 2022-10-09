package com.Cristian.login.dao;

import com.Cristian.login.models.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
@Transactional
public class ContactactDaoImp implements ContactDao{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Contacto> list(Long id) {
        String query = "FROM Contacto WHERE user_id = :id";
        List<Contacto> list = entityManager.createQuery(query).setParameter("id", id).getResultList();
        if(list.isEmpty()){
           return  list;
        }
       return list ;
    }

    @Override
    public Boolean agregar(Contacto contacto) {
        entityManager.merge(contacto);
        return null;
    }

    @Override
    public Long eliminar(Long id) {
        entityManager.remove(entityManager.find(Contacto.class,id));
        return null;
    }


    @Override
    public Contacto update(Contacto contacto) {
        Contacto user = entityManager.find(Contacto.class,contacto.getId());
        if(contacto.getUser_id() != user.getUser_id()){
            return  null;
        }
        user.setNombre(contacto.getNombre());
        user.setTelefono(contacto.getTelefono());
        return null;
    }

}
