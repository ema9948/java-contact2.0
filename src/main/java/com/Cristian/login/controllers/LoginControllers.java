package com.Cristian.login.controllers;

import com.Cristian.login.dao.UserDaoImp;
import com.Cristian.login.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/")
@CrossOrigin(value = "https://app-contacto.netlify.app/")
public class LoginControllers {

    @Autowired
    private UserDaoImp dao;

    @PostMapping("login")
    public User login (@RequestBody User user){
       User data =  dao.login(user);
       if(data == null){
           User error  = new User();
           error.setNombre("Usuario no registrado");
           return error;
       }
       data.setPassword("");
       return  data;
    }

    @PostMapping("register")
    public  boolean register(@RequestBody User user){
        return  dao.register(user);
    }
}
