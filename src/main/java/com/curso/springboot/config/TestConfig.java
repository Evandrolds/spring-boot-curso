package com.curso.springboot.config;

import com.curso.springboot.entity.User;
import com.curso.springboot.repositories.UserRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.boot.CommandLineRunner;

/**
 *
 * @author Evandro
 */
//Para a visar que essa classe é uma classe de configuração utilizamos a anotation (@Configuration) 
@Configuration
// Para avisar que essa é uma classe específica de teste usamos a anotation (@Profile())
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    User user = new User(null, "Evandro", "evandro@hotmail.com", "1234");
    User user1 = new User(null, "Saandro", "sandro@hotmail.com", "7894");

    @Override
    public void run(String... args) throws Exception {
        userRepository.saveAll(Arrays.asList(user, user1));
    }

}
