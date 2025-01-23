package com.javatechie.jwt.api.controller;

import com.javatechie.jwt.api.entity.AuthRequest;
import com.javatechie.jwt.api.entity.ResponseEntityTKN;
import com.javatechie.jwt.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to MODULE !!";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Object> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }

        return new ResponseEntity<>( new ResponseEntityTKN(
                jwtUtil.generateToken(authRequest.getUserName()) ), HttpStatus.OK);

    }


}
