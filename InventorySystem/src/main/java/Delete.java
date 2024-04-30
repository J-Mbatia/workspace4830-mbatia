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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:mysql://ec2-3-85-39-5.compute-1.amazonaws.com:3306/myDB?useSSL=false&allowPublicKeyRetrieval=true";
	static String user = "onlineuser";
	static String password = "password";
	Connection connection = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("This is the DELETE Page");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Del = request.getParameter("Delete").trim();
		
		String sqlcommand = "DELETE FROM inventory WHERE PRODUCTNAME= ? ;";
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://ec2-3-86-89-158.compute-1.amazonaws.com:3306/myDB?useSSL=false&allowPublicKeyRetrieval=true", "onlineuser", "password");
			PreparedStatement preparedStatement = conn.prepareStatement(sqlcommand)) {
			
			preparedStatement.setString(1, Del);
			
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
