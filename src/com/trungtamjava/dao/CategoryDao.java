package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.Category;

public interface CategoryDao {
	void add(Category category);

	void delete(int id);

	void update(Category updateCategory);

	Category getId(int Id);

	List<Category> search(String name);
	
	List<Category> search(String name, int offset, int maxPerPage);
	
	int count(String name);
}
