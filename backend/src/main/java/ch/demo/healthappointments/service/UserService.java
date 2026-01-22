package ch.demo.healthappointments.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ch.demo.healthappointments.exception.BLLException;
import ch.demo.healthappointments.model.User;
import ch.demo.healthappointments.repository.UserRepository;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Mono<User> login(String username, String password) {
        return userRepository.findByUsername(username)
        .switchIfEmpty(Mono.error(new BLLException("Aucun résultat")))
        .map(user -> {
               if (!passwordEncoder.matches(password, user.getPassword())) {
                    throw new BLLException("Mot de passe incorrect");
                }
            return user;
        });
    }

   
}
