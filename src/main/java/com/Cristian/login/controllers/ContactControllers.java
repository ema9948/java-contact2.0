package com.Cristian.login.controllers;

import com.Cristian.login.dao.ContactactDaoImp;
import com.Cristian.login.models.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://app-contacto.netlify.app/")
@RestController
@RequestMapping(value = "api/v1/contact")
public class ContactControllers {

    @Autowired
    private ContactactDaoImp contactactDaoImp;

    @GetMapping("/{id}")
    public List<Contacto> list (@PathVariable Long id){

       return contactactDaoImp.list(id);

    }

    @PostMapping("agregar")
    public Boolean agregar(@RequestBody Contacto contacto){
         contactactDaoImp.agregar(contacto);
        return  null;
    }
    @DeleteMapping("/delete/{id}")
    public  Boolean eliminar(@PathVariable Long id){
        contactactDaoImp.eliminar(id);
        return  null;
    }


    @PostMapping("/edit")
    public Boolean upadte(@RequestBody Contacto contacto){
        contactactDaoImp.update(contacto);
        return  null;

    }
}
