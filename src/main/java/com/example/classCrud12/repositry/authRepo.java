package com.example.classCrud12.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.classCrud12.model.AuthData;

@Repository
public interface authRepo  extends JpaRepository<AuthData , Long> {

    
} 
