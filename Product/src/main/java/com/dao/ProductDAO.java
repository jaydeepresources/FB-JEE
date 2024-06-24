package com.dao;

import java.util.List;

public interface ProductDAO {

	int addProduct(Product product);
	int updateProduct(Product product);
	List<Product> getProducts();
	List<Product> searchProducts(String productName);
	List<Integer> getProductIds();
	List<Product> sortProduct(String criteria);
	int deleteProduct(int productId);
	
}