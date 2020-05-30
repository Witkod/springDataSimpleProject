package zti.shop.repository;

import org.springframework.data.repository.CrudRepository;

import zti.shop.model.Product;

public interface ProductRepository extends CrudRepository <Product, Long>{
	
}
