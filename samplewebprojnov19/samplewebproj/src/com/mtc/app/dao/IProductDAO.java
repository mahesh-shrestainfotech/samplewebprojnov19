package com.mtc.app.dao;

import java.util.List;

import com.mtc.app.vo.Product;

public interface IProductDAO {
	
	void add(Product product);
	Product findById(int id);
	List<Product> findAllProducts();
	void update(Product product);
	void delete(int id);

}

