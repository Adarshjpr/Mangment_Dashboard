package com.example.classCrud12.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.classCrud12.dto.loginRequestDto;
import com.example.classCrud12.model.AuthData;
import com.example.classCrud12.repositry.authRepo;

@Service
public class AuthService {

    authRepo repo;

    AuthService(authRepo repo) {
        this.repo = repo;
    }

    public AuthData post(AuthData data) {

        repo.save(data);

        return data;

    }

    public List<AuthData> Getbyall() {

        return repo.findAll();

    }

    public Optional<AuthData> getbyid(Long id) {

        return repo.findById(id);

    }

    public String loginCheack(Long id, loginRequestDto lRdto) {
        Optional<AuthData> loginDb = repo.findById(id);

        if (loginDb.isPresent()) {

            if (loginDb.get().getEmail().equals(lRdto.getEmail())) {

                if (loginDb.get().getPassword().equals(lRdto.getPassword())) {
                    return "  are you correct person ";
                }
            }

        }

        return " are you wrong peron";
    }

    public String logout(Long id) {
       repo.deleteById(id); 
    
    return  " success full";
    }

    public String update(Long id, AuthData  user_update_data) {
       
     AuthData  db_present_value  =repo.findById(id).orElseThrow();
   

// name  value     email  or password  null  
        
if (user_update_data.getName() != null ) {
 db_present_value.setName(user_update_data.getName());
}

if (user_update_data.getEmail() !=null) {
        db_present_value.setEmail(user_update_data.getEmail()); 
}
if (user_update_data.getPassword() != null) {
     db_present_value.setPassword(user_update_data.getPassword());
}




 repo.save(db_present_value);

return null ;
    }






















}
