package ch.demo.healthappointments.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.demo.healthappointments.dto.LoginRequest;
import ch.demo.healthappointments.dto.LoginResponse;
import ch.demo.healthappointments.model.User;
import ch.demo.healthappointments.service.JwtService;
import ch.demo.healthappointments.service.UserService;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class LoginController {
    private final UserService userService;
    private final JwtService jwtService;

    public LoginController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public Mono<LoginResponse> login(@RequestBody LoginRequest request) {
       return userService.login(request.username, request.password)
       .map( user -> new LoginResponse(
        jwtService.generateToken(user)
       ));
    }
    
}
