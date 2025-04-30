package com.estudos.course.config;

import com.estudos.course.Enums.OrderStatus;
import com.estudos.course.models.Category;
import com.estudos.course.models.Order;
import com.estudos.course.models.User;
import com.estudos.course.repositories.CategoryRepository;
import com.estudos.course.repositories.OrderRepository;
import com.estudos.course.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;

    public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456",null);
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456", null);

        Order o1 = new Order(null, LocalDateTime.now(), OrderStatus.WAITING_PAYMENT, u1);
        Order o2 = new Order(null, LocalDateTime.now(), OrderStatus.PAID, u1);
        Order o3 = new Order(null, LocalDateTime.now(), OrderStatus.CANCELED, u2);

        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");


        this.userRepository.saveAll(Arrays.asList(u1, u2));
        this.orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        this.categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

    }
}
