package files;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertData
 */
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    try { 
	        // Database connection and insert logic
	        Class.forName("com.mysql.cj.jdbc.Driver"); 
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/files?characterEncoding=utf8", "root", "root"); 
	        PreparedStatement st = con.prepareStatement("INSERT INTO files (file_name, file_date, file_type, file_size) VALUES (?, ?, ?, ?)");
	        st.setString(1, request.getParameter("file_name")); 
	        st.setString(3, request.getParameter("file_type")); 
	        String dateString = request.getParameter("file_date"); 
	        java.sql.Date date = java.sql.Date.valueOf(dateString);
	        st.setDate(2, date);
	        // Get the file size from the request and parse it as a long
	        long fileSize = Long.parseLong(request.getParameter("file_size"));
	        st.setLong(4, fileSize);
	        
	        // Execute the update
	        st.executeUpdate();
	        
	        // Close resources
	        st.close();
	        con.close(); 
	        
	        // Bootstrap CSS link
	        out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
	        
	        // Bootstrap styled confirmation message
	        out.println("<div class='container mt-4'>");
	        out.println("<div class='alert alert-success' role='alert'>");
	        out.println("<strong>Success!</strong> File was successfully inserted.");
	        out.println("</div>");
	        out.println("</div>");
	    } catch(Exception e) {
	        e.printStackTrace();
	        out.println("<div class='alert alert-danger' role='alert'>");
	        out.println("<strong>Error!</strong> An error occurred while inserting the file.");
	        out.println("</div>");
	    } finally {
	        out.close();  
	    } 
	}


		

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertData() {
        super();
        // TODO Auto-generated constructor stub
    }

}
