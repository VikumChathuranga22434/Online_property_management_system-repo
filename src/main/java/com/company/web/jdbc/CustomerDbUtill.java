package com.company.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CustomerDbUtill {
	
	private DataSource dataSource;

	public CustomerDbUtill(DataSource thedatasource) {
		dataSource = thedatasource;
	}

	public void insertCustomer(Customer tempCustomer) {
		
		//getting the connection variables
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			
			//getting the connection
			myConn = dataSource.getConnection();
			
			//write the statement
			String sql = "INSERT INTO web_property_manager.buyerdetails(username,lastname,address,NIC,message)VALUES(?,?,?,?,?);";
			
			//preparing the statement
			myStmt = myConn.prepareStatement(sql);
			
			//setting the values for the statement
			//(username,lastname,address,NIC,message)
			myStmt.setString(1, tempCustomer.getFirstname());
			myStmt.setString(2, tempCustomer.getLastname());
			myStmt.setString(3, tempCustomer.getAddress());
			myStmt.setString(4, tempCustomer.getNIC());
			myStmt.setString(5, tempCustomer.getMessage());
			
			//execute the statement
			myStmt.execute();
			
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally{
			//closing the JDBC
			close(myConn, myStmt, null);
		}
		
		
	}

	private void close(Connection myConn, PreparedStatement myStmt, ResultSet myRs) {
		
		try {
			
			if(myRs != null) {
				myRs.close();
			}if (myStmt != null) {	
				myStmt.close();	
			}if (myConn != null) {	
				myConn.close(); // doesn't really close it ... just put back in to connection pool	
			}	
			
		}catch (Exception exc) {	
			exc.printStackTrace();	
		}
		
	}

	public List<Customer> getCustomerdetails(String nic) throws SQLException {
		
		/// get the NIC form the parameter
		String Nic = nic;
		
		//declaring a arrayList
		List<Customer> customer = new ArrayList<>();
 		
		//getting he connection variables
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			
			//get the connection
			myConn = dataSource.getConnection();
			
			//Write the sql Statement
			String sql = "SELECT * FROM web_property_manager.buyerdetails WHERE NIC=?;";
			
			//Preparing the details
			myStmt = myConn.prepareStatement(sql);
			
			//set the statements for the query
			myStmt.setString(1, Nic);
			
			//execute the query
			myRs = myStmt.executeQuery();
			
			while(myRs.next()) {
				
				//getting the details from the data base
				int id = myRs.getInt("id");
				String firstname = myRs.getString("username");
				String lastname = myRs.getString("lastname");
				String address = myRs.getString("address");
				String NIC = myRs.getString("NIC");
				String message = myRs.getString("message");
				
				//enter the data to the customer details
				Customer tempCustomer  = new Customer(id, firstname, lastname, address, NIC, message);
				
				//adding to the arrayList
				customer.add(tempCustomer);				
				
			}
			
			return customer;
			
			
		}finally {
			//close the JDBC
			close(myConn, myStmt, myRs);
		}

	}

	public Customer getCustomer(String customerID) throws SQLException {
		
		//get the cus id and convert it in to a int
		int cusId = Integer.parseInt(customerID);
		
		//get connection variables
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			
			//declaring the customer variable
			Customer nesCustomer = null;
			
			//create connection
			myConn = dataSource.getConnection();
			
			//write the sql query
			String sql = "SELECT * FROM web_property_manager.buyerdetails WHERE id=?;";
			
			//preparing the statement
			myStmt = myConn.prepareStatement(sql);
			
			//set the variable values for the query
			myStmt.setInt(1, cusId);
			
			//execute the query
			myRs = myStmt.executeQuery();
			
			if (myRs.next()) {
				
				//getting details from the database
				int id = myRs.getInt("id");
				String firstname = myRs.getString("username");
				String lastname = myRs.getString("lastname");
				String address = myRs.getString("address");
				String NIC = myRs.getString("NIC");
				String message = myRs.getString("message");
				
				//adding the details for a customer obj
				nesCustomer = new Customer(id, firstname, lastname, address, NIC, message);				
				
			}
			
			return nesCustomer;
			
		}finally {
			//Close the JDBC
			close(myConn, myStmt, myRs);
		}
		
		
	}

	public void updateCustomer(Customer theCustomer) throws SQLException {
		
		// make connection
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {

			// create connection
			myConn = dataSource.getConnection();

			// update query
			String sql = "update web_property_manager.buyerdetails set username=?, lastname=?, address=?, NIC=?, message=? where id=?";

			// prepare Statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, theCustomer.getFirstname());
			myStmt.setString(2, theCustomer.getLastname());
			myStmt.setString(3, theCustomer.getAddress());
			myStmt.setString(4, theCustomer.getNIC());
			myStmt.setString(5, theCustomer.getMessage());
			myStmt.setInt(6, theCustomer.getCustomerId());

			// execute query
			myStmt.execute();
		} finally {

			// clean up the JDBC ojects
			close(myConn, myStmt, null);

		}

	}

	public void deleteCustomer(String theCustomerId) throws SQLException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			
			//convert studentId to int
			int customerId = Integer.parseInt(theCustomerId);
			
			//get connection to database
			myConn = dataSource.getConnection();
						
			//create sql to delete student
			String sql = "delete from web_property_manager.buyerdetails where id=?";
						
			//prepare stmt
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setInt(1, customerId);
			
			//execute the statement
			myStmt.execute();
									
		}finally {
			// close database connection
			close(myConn, myStmt, null);
		}
		
	}

}
