package com.curso.springboot.config;

import com.curso.springboot.entities.Category;
import com.curso.springboot.entities.Order;
import com.curso.springboot.entities.OrderItem;
import com.curso.springboot.entities.Payment;
import com.curso.springboot.entities.Product;
import com.curso.springboot.entities.User;
import com.curso.springboot.entities.enums.OrderStatus;
import com.curso.springboot.repositories.CategoryRepository;
import com.curso.springboot.repositories.OrderItemRepository;
import com.curso.springboot.repositories.OrderRepository;
import com.curso.springboot.repositories.ProductReposiry;
import com.curso.springboot.repositories.UserRepository;
import java.time.Instant;
import java.util.Arrays;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author Evandro
 */
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductReposiry productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = new Product(null, 250.0, "Vinkings", "Guerra medieval", " ");
        Product p2 = new Product(null, 2190.0, "Smart TV", " Nulla eu imperdiet purus. Maecenas ante.", "");
        Product p3 = new Product(null, 1250.0, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", "");
        Product p4 = new Product(null, 1200.0, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", "");
        Product p5 = new Product(null, 100.99, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", "");
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "96547");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "13547");
        User u3 = new User(null, "Sandro Lima", "sandro@gmail.com", "245178");
        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAD, u1);
        Order o2 = new Order(null, Instant.parse("2019-04-21T03:42:10Z"), OrderStatus.PAD, u2);
        Order o3 = new Order(null, Instant.parse("2019-03-22T15:21:22Z"), OrderStatus.WEINTING_PAIMENT, u3);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        OrderItem oi1 = new OrderItem(o1, p1, 7, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 6, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 8, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 3, p5.getPrice());
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));


        Payment pay1 = new Payment(null, Instant.parse("2019-06-21T21:53:07Z"), o1);
        Payment pay2 = new Payment(null, Instant.parse("2019-06-23T22:53:07Z"), o2);
        Payment pay3 = new Payment(null, Instant.parse("2019-06-23T22:53:07Z"), o3);
        o1.setPayment(pay1);
        o2.setPayment(pay2);
        o2.setPayment(pay3);
        orderRepository.save(o1);
        orderRepository.save(o2);
        orderRepository.save(o3);
        

    }

}
