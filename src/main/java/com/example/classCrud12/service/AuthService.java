package com.example.classCrud12.service;

import org.springframework.stereotype.Service;

import com.example.classCrud12.model.AuthData;
import com.example.classCrud12.repositry.authRepo;

@Service
public class AuthService {

authRepo repo ;




AuthService(authRepo repo){
     this.repo = repo;
}

    public AuthData post (AuthData  data){


repo.save(data);

return  data ;

    }
}
