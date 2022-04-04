package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.Bill;

public interface BillDao {
	void create(Bill b);

	void update(Bill b);

	void delete(int id);

	Bill get(int id);

	List<Bill> search(int userId);
	
	List<Bill> getAll();
}
