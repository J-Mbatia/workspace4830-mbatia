
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
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:mysql://ec2-3-85-39-5.compute-1.amazonaws.com:3306/myDB?useSSL=false&allowPublicKeyRetrieval=true";
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
		
		response.getWriter().append("This is the ADD Page");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("<title>Add</title>");
		response.getWriter().append("<link rel=\"shortcut icon\" href=\"favicon.ico\"/>");
		
		String PN = request.getParameter("PN").trim();
		String PI = request.getParameter("PI").trim();
		String last = request.getParameter("last").trim();
		String exp = request.getParameter("exp").trim();
		String stock = request.getParameter("stock").trim();
		String supply = request.getParameter("supply").trim();
		
		String sqlcommand = "INSERT INTO inventory (PRODUCTNAME, PRODUCTINFO, LASTORDERED, EXPIRATIONDATE, STOCKLEVEL, SUPPLIERDETAILS) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://ec2-3-86-89-158.compute-1.amazonaws.com:3306/myDB?useSSL=false&allowPublicKeyRetrieval=true", "onlineuser", "password");
			PreparedStatement preparedStatement = conn.prepareStatement(sqlcommand)) {
			
			preparedStatement.setString(1, PN);
			preparedStatement.setString(2, PI);
			preparedStatement.setString(3, last);
			preparedStatement.setString(4, exp);
			preparedStatement.setString(5, stock);
			preparedStatement.setString(6, supply);
			
			int row = preparedStatement.executeUpdate();
			
			System.out.println(row);
			
		} catch (SQLException e) {
	    	  response.getWriter().println("SQL Exception occured. <br>");
	    	  e.printStackTrace();
	      }
		
		doGet(request, response);
		response.sendRedirect("Table");
		
	}
}
