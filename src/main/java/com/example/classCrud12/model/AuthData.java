package com.example.classCrud12.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  // orm 
public class AuthData {

 @Id

@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
private  String Name ;

private String email ;

 private String password ;

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
