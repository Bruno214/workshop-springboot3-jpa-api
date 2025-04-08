package com.estudos.course.config;

import com.estudos.course.models.Order;
import com.estudos.course.models.User;
import com.estudos.course.repositories.OrderRepository;
import com.estudos.course.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public TestConfig(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456",null);
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456", null);

        Order o1 = new Order(null, LocalDateTime.now(), u1);
        Order o2 = new Order(null, LocalDateTime.now(), u2);
        Order o3 = new Order(null, LocalDateTime.now(), u1);

        this.userRepository.saveAll(Arrays.asList(u1, u2));
        this.orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }
}
