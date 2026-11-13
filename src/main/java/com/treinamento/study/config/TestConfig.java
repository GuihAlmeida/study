package com.treinamento.study.config;

import com.treinamento.study.entities.Category;
import com.treinamento.study.entities.Order;
import com.treinamento.study.entities.Product;
import com.treinamento.study.entities.User;
import com.treinamento.study.enums.OrderStatus;
import com.treinamento.study.repositories.CategoryRepository;
import com.treinamento.study.repositories.OrderRepository;
import com.treinamento.study.repositories.ProductRepository;
import com.treinamento.study.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Marcela", "marcela@gmail.com", "14993032555","2704");
        User u2 = new User(null, "Fernanda", "fernanda@gmail.com", "1498390294","2714");

        userRepository.saveAll(Arrays.asList(u1,u2));

        Product p1 = new Product(null,"ovo","ovo caipira",23.9,"");
        Product p2 = new Product(null,"frango","frango caipira",53.3,"");

        productRepository.saveAll(Arrays.asList(p1,p2));

        Order o1 = new Order(null, Instant.parse("2026-10-20T19:53:07Z"), OrderStatus.DELIVERED, u1);
        Order o2 = new Order(null, Instant.parse("2026-10-23T19:53:07Z"),OrderStatus.CANCELED ,u2);
        Order o3 = new Order(null, Instant.parse("2026-10-01T19:53:07Z"), OrderStatus.WAITNG_PAYMENT, u1);

        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

        Category c1 = new Category(null,"Açougue");
        Category c2 = new Category(null,"limpeza");
        Category c3 = new Category(null,"outros");

        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));

        p1.getCategories().add(c2);
        p2.getCategories().add(c1);
        p2.getCategories().add(c2);

        productRepository.saveAll(Arrays.asList(p1,p2));
    }
}
