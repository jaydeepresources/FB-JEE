package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

	private static Connection connection;

	static {
		connection = DBUtil.getConnection();
	}

	@Override
	public int addProduct(Product product) {

		try {
			PreparedStatement pst = connection
					.prepareStatement("insert into products(product_name, product_price) values (?, ?)");
			pst.setString(1, product.getProductName());
			pst.setFloat(2, product.getProductPrice());
			int res = pst.executeUpdate();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	@Override
	public int updateProduct(Product product) {
		try {
			PreparedStatement pst = connection
					.prepareStatement("update products set product_name=?, product_price=? where product_id=?");
			pst.setString(1, product.getProductName());
			pst.setFloat(2, product.getProductPrice());
			pst.setInt(3, product.getProductId());
			int res = pst.executeUpdate();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	@Override
	public List<Product> getProducts() {

		List<Product> products = new ArrayList<>();

		try {
			Statement st = connection.createStatement();

			ResultSet res = st.executeQuery("select * from products");

			while (res.next())
				products.add(new Product(res.getInt(1), res.getString(2), res.getFloat(3)));

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return products;
	}

	@Override
	public List<Product> searchProducts(String productName) {
		List<Product> products = new ArrayList<>();

		try {
			PreparedStatement pst = connection.prepareStatement("select * from products where product_name = ?");
			pst.setString(1, productName);

			ResultSet res = pst.executeQuery();

			while (res.next())
				products.add(new Product(res.getInt(1), res.getString(2), res.getFloat(3)));

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return products;

	}

	@Override
	public List<Integer> getProductIds() {
		List<Integer> productIds = new ArrayList<>();
		try {
			Statement st = connection.createStatement();

			ResultSet res = st.executeQuery("select product_id from products");

			while (res.next())
				productIds.add(res.getInt(1));

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return productIds;
	}

	@Override
	public int deleteProduct(int productId) {
		try {
			PreparedStatement pst = connection.prepareStatement("delete from products where product_id = ?");
			pst.setInt(1, productId);
			int res = pst.executeUpdate();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	@Override
	public List<Product> sortProduct(String criteria) {

		List<Product> sortedProducts = new ArrayList<>();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select * from products order by " + criteria);

			while (rs.next())
				sortedProducts.add(new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3)));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sortedProducts;
	}

}
