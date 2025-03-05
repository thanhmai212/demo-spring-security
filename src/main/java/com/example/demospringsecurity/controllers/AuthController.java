package com.example.demospringsecurity.controllers;

import com.example.demospringsecurity.services.TokenService;
import com.example.demospringsecurity.payloads.auth.Token;
import com.example.demospringsecurity.payloads.auth.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthController(TokenService tokenService, AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }
    @GetMapping("/token")
    public Token login(@RequestBody UserLogin userLogin) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
        return new Token(tokenService.generateToken(authentication));
    }
    @GetMapping("/test")
    public  String Test(){
        return "Test auth";
    }
}