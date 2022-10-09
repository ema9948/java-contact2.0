package com.Cristian.login.dao;


import com.Cristian.login.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserDaoImp  implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public User login(User user) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String query = "FROM User WHERE  email = :email";
        List<User> result = entityManager.createQuery(query).setParameter("email",user.getEmail()).getResultList();

        if(result.isEmpty()){
            return null;
        }
        User data = result.get(0);

        if(argon2.verify(result.get(0).getPassword(),user.getPassword())){
                return  data;
        }else {
                User error = new User();
                error.setNombre("Credenciales incorrectas");
                return  error;
        }
    }

    @Override
    public Boolean register(User user) {
        String query = "FROM User WHERE email = :email";
        List<User> result = entityManager.createQuery(query).setParameter("email", user.getEmail()).getResultList();
        if(!result.isEmpty()){
            return  false;
        }
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
                                  //(cuantas veces va a hashar, uso de memoria, hilo de processos)
        String hash = argon2.hash(1,1026,1,user.getPassword());
        user.setPassword(hash);
        entityManager.merge(user);
        return true;
    }
}
