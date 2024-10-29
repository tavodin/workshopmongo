package com.tavodin.workshopmongo.config;

import com.tavodin.workshopmongo.models.entities.User;
import com.tavodin.workshopmongo.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void init() {
        repository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Gray", "bob@gmail.com");
        repository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
