package com.example.classCrud12.model;

import com.example.classCrud12.model.Enum.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  // orm 
public class AuthData {

 @Id

@GeneratedValue(strategy = GenerationType.IDENTITY)   //AUTO INCREMENT

    private Long id;
private  String Name ;

// @Column(unique = true ,)

//  select * from table  where email ="value";
private String email ;

 private String password ;

@Enumerated(EnumType.STRING)
 private Roles role;  



 public String getName() {
    return Name;
 }

 public void setName(String name) {
    Name = name;
 }

 public String getEmail() {
    return email;
 }

 public void setEmail(String email) {
    this.email = email;
 }

 public String getPassword() {
    return password;
 }

 public void setPassword(String password) {
    this.password = password;
 }

}
