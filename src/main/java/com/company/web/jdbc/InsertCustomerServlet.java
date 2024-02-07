package com.company.web.jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class InsertCustomerServlet
 */
@WebServlet("/InsertCustomerServlet")
public class InsertCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerDbUtill customerDbUtill;
	
	//define the dataSource/connection pool for resource injection
	@Resource(name="jdbc/web_property_manager")
	private DataSource datasource;
	
	
       
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		//create our customer Db Utill... and pass in the connection pool/Datasource
		try {
			customerDbUtill = new CustomerDbUtill(datasource);
		}catch(Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCustomerServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			//read the command parameter
			String theCommand = request.getParameter("command");
			
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			switch(theCommand) {
			
			case "LIST" :
				break;
			
			case "LOAD" :
				loadDetails(request, response);
				break;
				
			case "DELETE" :
				deleteCusDetails(request, response);
				break;
				
			
			}
			
			
		}catch(Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteCusDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		// read student id from form data
		String theStudentId = request.getParameter("customerId");

		// delete the student from the database
		customerDbUtill.deleteCustomer(theStudentId);

		// send them back to "Customer.jsp" page
		RequestDispatcher dispatcher = request.getRequestDispatcher("Customer.jsp");
		dispatcher.forward(request, response);
		
	}

	private void loadDetails(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		//get the id from the form
		String customerID = request.getParameter("customerId");
		
		//get the buyer details from the database
		Customer theCustomer = customerDbUtill.getCustomer(customerID);
		
		//setting the attributes for the jsp
		request.setAttribute("CUSTOMER", theCustomer);
		
		//send to jsp page update.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("Update.jsp");
		dispatcher.forward(request, response);		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try {
			
			//read the command parameter
			String theCommand = request.getParameter("command");
			
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			switch(theCommand) {
			
			case "LIST" :
				break;
			
			case "ADD" :
				insertData(request, response);
				break;
				
			case "UPDATE" :
				updateDetails(request, response);
				break;
			
			}
			
			
		}catch(Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void updateDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		// read student info from form data
		int id = Integer.parseInt(request.getParameter("customerId"));
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String address = request.getParameter("address");
		String nic = request.getParameter("nicNumber");
		String message = request.getParameter("message");

		// create a new student object
		Customer theStudent = new Customer(id, firstname, lastname, address, nic, message);

		// perform update on database
		customerDbUtill.updateCustomer(theStudent);

		// load the customer details for the confirmation
		loadCustomer(request, response);
		
	}

	private void insertData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		//getting the data from the data 
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String address = request.getParameter("address");
		String NIC = request.getParameter("nicNumber");
		String message = request.getParameter("message");
		
		//add the details for the customer obj
		Customer tempCustomer = new Customer(firstname, lastname, address, NIC, message);
		
		//forward to the utill class to insert the details
		customerDbUtill.insertCustomer(tempCustomer);
		
		//load the customer details for the confirmation
		loadCustomer(request, response);
		
	}

	private void loadCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		//getting email from teh request
		String nic = request.getParameter("nicNumber");
		
		//get the customer details from the database and add to the arraylist 
		List<Customer> theCustomer = customerDbUtill.getCustomerdetails(nic);
		
		// set the attribute for the jsp page
		request.setAttribute("THE_CUSTOMER", theCustomer);
		
		//forward it to the confirm.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("Confirmation.jsp");
		dispatcher.forward(request, response);
		
	}

}
