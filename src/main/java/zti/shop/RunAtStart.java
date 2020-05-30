package zti.shop;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import zti.shop.model.Person;
import zti.shop.model.Product;
import zti.shop.repository.PersonRepository;
import zti.shop.repository.ProductRepository;

@Component
public class RunAtStart {
	private final PersonRepository personRepository;
	private final ProductRepository productRepository;

	public RunAtStart(PersonRepository personRepository, ProductRepository productRepository) {
		super();
		this.personRepository = personRepository;
		this.productRepository = productRepository;
	}
	
	@PostConstruct
	public void runAtStart(){
		Person person1 = new Person();
		person1.setFirstName("Adam");
		person1.setLastName("Nowak");
		
		Person person2 = new Person();
		person2.setFirstName("Zbigniew");
		person2.setLastName("Brzezinski");
		
		Product bike = new Product();
		Product lego = new Product();
		bike.setName("rower");
		bike.setPrice(200);
		lego.setName("lego");
		lego.setPrice(90);
	
		List<Product> order1= new ArrayList<Product>();
		order1.add(bike);
		order1.add(lego);
		
		List<Product> order2= new ArrayList<Product>();
		order2.add(lego);
		
		
		
		person1.setProducts(order1);

		productRepository.saveAll(order1);
		personRepository.save(person1);
		personRepository.save(person2);
		System.out.println(person1);
	}
}
