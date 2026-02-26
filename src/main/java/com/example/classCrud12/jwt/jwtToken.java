package com.example.classCrud12.jwt;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class jwtToken {

 // jwt  dependecy 


 // header . payload . signature
private static final String SECRET =
            "bXlndkfnnsdfknsdkfsdfksdfkjsdfksdfkdsjsfmsfsnfskdjfdsVDI1Ng==";


public Key  getSingKey(){
    return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
}
//  SIGNATURE 
  
//  HEADER . PAYLAOY

public String gernateToken(String email){
    return Jwts.builder().setSubject(email)
    .setIssuedAt(new Date())  //2:26  --> 2:36
    .setExpiration(new Date(System.currentTimeMillis()+1000*60*10)) 
    .signWith(getSingKey(),SignatureAlgorithm.HS256).compact() ;
}
//new Jwts("john", "123456", "john@email.com");




//  builder    .name(name)
//  constroter  (name email password)
/*
User user = User.builder()
        .name("adarsh ")
        .email("adarsh")
        .password("4872348dcmxzckj")
        .build();

        payload me jo data jata h  usko subject 
*/
}
