package com.mtc.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mtc.app.vo.Product;

public class ProductDAOImpl extends BaseDAO implements IProductDAO{
	
	public static final String insertQuery = "insert into test.product(id,name,price,description,quantity) values(?,?,?,?,?)";
	
	public static final String selectQuery = "select * from test.product where id = ?";
    //1

	public static final String selectAllQuery = "select * from test.product";


	@Override
	public void add(Product product) {

		try {
			
			Connection connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			
			preparedStatement.setInt(1,product.getId());
			preparedStatement.setString(2,product.getName());
			preparedStatement.setFloat(3,product.getPrice());
			preparedStatement.setString(4, product.getDescription());
			preparedStatement.setInt(5,product.getQuantity());
			
			int noOfRows = preparedStatement.executeUpdate();
			
			if(noOfRows == 1) {
				System.out.println("Record added successfully");
				
			}
			
			connection.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Product findById(int id) {
		
		Product product = null;
		
		try {		
			
			Connection connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				product = mapProduct(resultSet);
			}
			
			connection.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return product;

	}

	@Override
	public List<Product> findAllProducts() {
		
		ArrayList<Product> productsList = new ArrayList<Product>();
		
		try {
			
			Connection connection = getConnection();
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(selectAllQuery);
			
			while (resultSet.next()) {
				
				Product product= mapProduct(resultSet);
				
				productsList.add(product);
				
			}
			
			connection.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return productsList;

	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	private Product mapProduct(ResultSet resultSet) {
		Product  product = new Product();
		
		try {
		
			product.setId(resultSet.getInt("id"));
			product.setName(resultSet.getString("name"));
			product.setPrice(resultSet.getFloat("price"));
			product.setDescription(resultSet.getString("description"));
			product.setQuantity(resultSet.getInt("quantity"));
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return product;

	} 

}
