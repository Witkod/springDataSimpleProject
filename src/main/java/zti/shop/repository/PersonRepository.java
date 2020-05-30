package zti.shop.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import zti.shop.model.Person;

public interface PersonRepository extends CrudRepository <Person, Long>{
	Iterable<Person> findByFirstName(String firstName);
	
	@Query(value = "Select p.firstName from Person p")
	Iterable<Person> findAll();
}

	

