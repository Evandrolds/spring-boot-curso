package com.curso.springboot.config;

import com.curso.springboot.entities.Category;
import com.curso.springboot.entities.Order;
import com.curso.springboot.entities.Product;
import com.curso.springboot.entities.User;
import com.curso.springboot.entities.enums.OrdemStatus;
import com.curso.springboot.repositories.CategoryRepository;
import com.curso.springboot.repositories.OrderRepository;
import com.curso.springboot.repositories.ProductReposiry;
import com.curso.springboot.repositories.UserRepository;
import java.time.Instant;
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
    private ProductReposiry productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User user3 = new User(null, "Samuel", "samuel@hotmail.com", "6587");
        User user1 = new User(null, "Evandro", "evandro@hotmail.com", "1234");
        User user2 = new User(null, "Saandro", "sandro@hotmail.com", "7894");

        Order order = new Order(null, Instant.parse("2021-06-20T19:53:07Z"), OrdemStatus.WEINTING_PAIMENT, user1);
        Order order1 = new Order(null, Instant.parse("2021-07-21T03:42:10Z"), OrdemStatus.CANCELED, user2);
        Order order2 = new Order(null, Instant.parse("2021-07-22T15:21:22Z"), OrdemStatus.CHIPPED, user3);

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Tools");
        Category cat3 = new Category(null, "Books");

        Product pro1 = new Product(null, 65.40, "Matelo", "Ferramenta", "www.ferramentas.com.br");
        Product pro2 = new Product(null, 420.30, "Cerra Marmore", "Eletronico", "www.ferramentas.com.br");
        Product pro3 = new Product(null, 260.25, "Furadeira", "Ferramenta", "www.ferramentas.com.br");
        Product pro4 = new Product(null, 260.25, "A Cabana", "Ficção", "www.books.com.br");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
        orderRepository.saveAll(Arrays.asList(order, order1, order2));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(pro1, pro2, pro3));
        
        pro1.getCategories().add(cat2);
        pro2.getCategories().add(cat1);
        pro3.getCategories().add(cat1);
        pro4.getCategories().add(cat3);
       productRepository.saveAll(Arrays.asList(pro1,pro2,pro3,pro4));
    }

}
