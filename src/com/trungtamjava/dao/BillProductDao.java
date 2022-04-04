package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.BillProduct;

public interface BillProductDao {
	void create(BillProduct b);

	void update(BillProduct b);

	void delete(int id);

	BillProduct get(int id);

	List<BillProduct> search(int billId);
}
