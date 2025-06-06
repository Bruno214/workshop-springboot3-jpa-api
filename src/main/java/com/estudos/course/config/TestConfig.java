package com.estudos.course.config;

import com.estudos.course.Enums.OrderStatus;
import com.estudos.course.models.Category;
import com.estudos.course.models.Order;
import com.estudos.course.models.Product;
import com.estudos.course.models.User;
import com.estudos.course.repositories.CategoryRepository;
import com.estudos.course.repositories.OrderRepository;
import com.estudos.course.repositories.ProductRepository;
import com.estudos.course.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, com.estudos.course.repositories.ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
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

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        this.userRepository.saveAll(Arrays.asList(u1, u2));
        this.orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        this.categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
        this.productRepository.saveAll(Arrays.asList(p1, p2, p3, p4,p5));

    }
}
