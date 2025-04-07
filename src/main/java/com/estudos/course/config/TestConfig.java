package com.estudos.course.config;

import com.estudos.course.models.User;
import com.estudos.course.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;

    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userRepository.saveAll(Arrays.asList(
                new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"),
                new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456")));
    }
}
