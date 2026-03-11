package com.example.classCrud12.jwt;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter  extends OncePerRequestFilter {

   private final jwtToken jToken ;

    JwtAuthFilter(jwtToken jToken) {
        this.jToken = jToken;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException{
            


 // 1️⃣ Authorization header lo  
  String authHeader =  request.getHeader("Authorization");
String token = null;
String email = null;
String Roles = null ;
   // 2️⃣ Check karo Bearer token hai ya nahi

      if (authHeader != null && authHeader.startsWith("Bearer ")) {
         // 3️⃣ Bearer hatao
            token = authHeader.substring(7);
                 // 4️⃣ email extract karo
          email =  jToken.extract(token);
          Roles = jToken.extractRoles(token);
        }


        if (email!=null &&   SecurityContextHolder.getContext().getAuthentication()== null ) {
            
         GrantedAuthority authority = 
    new SimpleGrantedAuthority("ROLE_" + Roles);  //Role_Admin
   UsernamePasswordAuthenticationToken  authenticationToken = new UsernamePasswordAuthenticationToken(email , null ,Collections.singleton(authority));

   // db email se aerify hoge 
//   value/user ki  , null     ,, role 

authenticationToken.setDetails( new WebAuthenticationDetailsSource().buildDetails(request));
  SecurityContextHolder.getContext()
                    .setAuthentication(authenticationToken);
        }
     
  filterChain.doFilter(request, response);
    }
        }
           

        // context   data 
     
   
          // 5️⃣ Agar user already authenticated nahi hai
            // 6️⃣ Token validate karo
               // 7️⃣ Spring Security ko authentication de do











