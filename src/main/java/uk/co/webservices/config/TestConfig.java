package uk.co.webservices.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import uk.co.webservices.entities.Brand;
import uk.co.webservices.entities.Category;
import uk.co.webservices.entities.Order;
import uk.co.webservices.entities.OrderItem;
import uk.co.webservices.entities.Payment;
import uk.co.webservices.entities.Product;
import uk.co.webservices.entities.User1;
import uk.co.webservices.entities.enums.OrderStatus;
import uk.co.webservices.repositories.BrandRepository;
import uk.co.webservices.repositories.CategoryRepository;
import uk.co.webservices.repositories.OrderItemRepository;
import uk.co.webservices.repositories.OrderRepository;
import uk.co.webservices.repositories.ProductRepository;
import uk.co.webservices.repositories.User1Repository;
//configuration to test profile and seeding database

@Configuration
@Profile("test")// need to be same name from aplication-test.properties, to use this configuration only for test profile
public class TestConfig implements CommandLineRunner{

	@Autowired
	private User1Repository user1Repository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User1 u1 = new User1(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User1 u2 = new User1(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1);
		

		Category cat1 = new Category(null, "Sport"); 
		Category cat2 = new Category(null, "SUV"); 
		Category cat3 = new Category(null, "Eletric");

		Product p1 = new Product(null, "Camaro", "Lorem ipsum dolor sit amet, consectetur.", 25000.5, ""); 
		Product p2 = new Product(null, "Volvo XC60", "Nulla eu imperdiet purus. Maecenas ante.", 12190.0, "");
		Product p3 = new Product(null, "Ferrari", "Nam eleifend maximus tortor, at mollis.", 31250.0, "");
		Product p4 = new Product(null, "Mustang", "Donec aliquet odio ac rhoncus cursus.", 21200.0, "");
		Product p5 = new Product(null, "Tesla", "Cras fringilla convallis sem vel faucibus.", 8100.99, "");
		
		Brand b1 = new Brand(null, "Ford"); 
		Brand b2 = new Brand(null, "Volvo"); 
		Brand b3 = new Brand(null, "Tesla");
		Brand b4 = new Brand(null, "Ferrari");
		
		p1.getCategories().add(cat1);
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat2);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat1);
		p5.getCategories().add(cat3);
		
		p1.setBrand(b4);
		p2.setBrand(b2);
		p3.setBrand(b4);
		p4.setBrand(b1);
		p5.setBrand(b3);
	
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));		
		user1Repository.saveAll(Arrays.asList(u1,u2));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		brandRepository.saveAll(Arrays.asList(b1, b2, b3, b4));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
	}	
}
