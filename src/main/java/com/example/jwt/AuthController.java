package com.example.jwt.controller;

import com.example.jwt.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

  @PostMapping("/token")
	public String getToken(@RequestParam String username) {
    return JwtUtil.generateToken(username)+"\n\n";
}


    @GetMapping("/protected")
    public String protectedEndpoint(@RequestHeader("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            String user = JwtUtil.validateToken(token);
            if (user != null) {
                return "Hello, " + user +"----\n";
            }
        }
        return "Unauthorized";
    }
}
