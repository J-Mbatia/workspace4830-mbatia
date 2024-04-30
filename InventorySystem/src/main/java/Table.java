
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Table
 */
@WebServlet("/Table")
public class Table extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:mysql://ec2-3-86-89-158.compute-1.amazonaws.com:3306/myDB?useSSL=false&allowPublicKeyRetrieval=true";
	static String user = "onlineuser";
	static String password = "password";
	Connection connection = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Table() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
	      //this gets the driver
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");// ("com.mysql.jdbc.Driver");
	      } catch (ClassNotFoundException e) {
	         System.out.println("The MySQL JDBC Driver is missing :(");
	         e.printStackTrace();
	         return;
	      }
	      connection = null;
	      //this changes the connection from null to the sql database
	      try {
	          connection = DriverManager.getConnection(url, user, password);
	          connection.setCatalog("myDB"); 
	       } catch (SQLException e) {
	          System.out.println("Connection Failed! Check output console");
	          e.printStackTrace();
	          return;
	       }

		
		//if connection NOT = null, can be used for sql queries
	    if (connection != null) {
	    	  System.out.println("Connected to database successfully.<br>");
	       }
	    else {
	          System.out.println("Failed to make connection!");
	       }
		
		try {
	    	  String sqlcommand = "Select * from inventory";
	    	  PreparedStatement prepState = connection.prepareStatement(sqlcommand);
	    	  ResultSet rs = prepState.executeQuery();
		
	    	  
	    	  response.getWriter().append("<title>Inventory</title>");
	    	  response.getWriter().append("<link rel=\"shortcut icon\" href=\"favicon.ico\"/>");
	    	  response.getWriter().append("<a href=\"Add.jsp\"><button>ADD</button>");
		      response.getWriter().append("<a href=\"Delete.jsp\"><button>Delete</button></a><br><br>");
		    	 
		    while(rs.next()) {
		    	
		    	
		    	response.getWriter().append("Product: "+rs.getString("PRODUCTNAME")+"<br>");
	    		response.getWriter().append("Product Info: "+rs.getString("PRODUCTINFO")+"<br>");
	    		response.getWriter().append("Ordered Last: "+rs.getString("LASTORDERED")+"<br>");
	    		response.getWriter().append("Expiration: "+rs.getString("EXPIRATIONDATE")+"<br>");
	    		response.getWriter().append("Stock: "+rs.getString("STOCKLEVEL")+"<br>");
	    		response.getWriter().append("Supplier Details: "+rs.getString("SUPPLIERDETAILS")+"<br><br>");	
	    		
			}
		    
	    	response.getWriter().append("<a href=\"Add.jsp\"><button>ADD</button>");
	    	response.getWriter().append("<a href=\"Delete.jsp\"><button>Delete</button></a><br><br>");
	    	
		    
		} catch (SQLException e) {
	    	  response.getWriter().println("SQL Exception occured. <br>");
	    	  e.printStackTrace();
	      }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		
	}

}
