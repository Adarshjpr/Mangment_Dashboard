package com.example.classCrud12.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.classCrud12.dto.loginRequestDto;
import com.example.classCrud12.model.AuthData;
import com.example.classCrud12.service.AuthService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
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

// get by all
@GetMapping("/user")
public List<AuthData> getMethodName() {


return aService.Getbyall();

}

@GetMapping("/users/{id}")
public Optional<AuthData> putMethodName(@PathVariable Long id  ) {
    
    
    return aService.getbyid(id);
}



@GetMapping("/user/{id}")
public String putMethodName(@PathVariable Long id , @RequestBody  loginRequestDto lRdto ) {
    
    
    return aService.loginCheack(id  ,lRdto);
}



}
