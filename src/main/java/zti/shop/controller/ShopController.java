package zti.shop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import zti.shop.model.Person;
import zti.shop.model.Product;
import zti.shop.repository.PersonRepository;
import zti.shop.repository.ProductRepository;


@RequestMapping("api/v1/shop")
@RestController
@CrossOrigin("*")
public class ShopController {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(path = "/person")
	public @ResponseBody Iterable<Person> getAllPeople(){
		return personRepository.findAll();
	}
	
	@GetMapping(path = "/product")
	public @ResponseBody Iterable<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	@GetMapping(path = "person/firstname/{firstNameValue}")
	public @ResponseBody Iterable<Person> getPersonByFirstName(@PathVariable("firstNameValue") String firstNameValue){
		return personRepository.findByFirstName(firstNameValue);
	}
	
	
	@PostMapping(path = "person/{firstNameValue}/{lastNameValue}")
    public void addPerson(@PathVariable("firstNameValue") String firstNameValue, @PathVariable("lastNameValue") String lastNameValue){
        Person person = new Person();
        person.setFirstName(firstNameValue);
        person.setLastName(lastNameValue);
        personRepository.save(person);
    }
}


