package com.example.classCrud12.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.classCrud12.model.AuthData;
import com.example.classCrud12.service.AuthService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController   // COMPONENT SCAM   BEANS 
public class crudController {
AuthService aService ;

    crudController(AuthService aService){
this.aService =aService ;
    }


@PostMapping("/register")
public AuthData postMethodName(@RequestBody AuthData  data) {

    
    return aService.post(data);
}


@GetMapping("path")
public String getMethodName(@RequestParam String param) {
    return new String();
}


@PutMapping("path/{id}")
public String putMethodName(@PathVariable String id, @RequestBody String entity) {
    //TODO: process PUT request
    
    return entity;
}



}
