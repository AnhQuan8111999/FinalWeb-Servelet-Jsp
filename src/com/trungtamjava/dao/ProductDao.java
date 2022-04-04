package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.Product;

public interface ProductDao {
	void add(Product product);

	void delete(int id);

	void update(Product product);

	Product getId(int Id);

	List<Product> search(String name);
	
	List<Product> search(int categoryId);
}
