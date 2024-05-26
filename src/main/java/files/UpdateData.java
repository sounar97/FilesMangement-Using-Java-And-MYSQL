package files;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateData
 */
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    try {  
	        String fileName = request.getParameter("file_name"); // Get the file name from the request
	        String newFileType = request.getParameter("newFileType"); // Get the new file type from the request
	              
	        Class.forName("com.mysql.cj.jdbc.Driver");  
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/files?characterEncoding=utf8", "root", "root");  
	              
	        PreparedStatement st = con.prepareStatement("UPDATE files SET file_type = ? WHERE file_name = ?");  
	        st.setString(1, newFileType);
	        st.setString(2, fileName);
	        int rowsAffected = st.executeUpdate();
	        
	        // Include Bootstrap CSS
	        out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
	        out.println("<div class='container mt-4'>");
	        
	        // Bootstrap styled confirmation message
	        if (rowsAffected > 0) {
	            out.println("<div class='alert alert-success' role='alert'>");
	            out.println("<strong>Success!</strong> File type updated successfully.");
	        } else {
	            out.println("<div class='alert alert-warning' role='alert'>");
	            out.println("<strong>Warning!</strong> No file found with the given name to update.");
	        }
	        out.println("</div>"); // Close alert div
	        out.println("</div>"); // Close container div
	        
	        st.close();
	        con.close();
	    } catch(Exception e) {
	        e.printStackTrace();
	        // Bootstrap styled error message
	        out.println("<div class='alert alert-danger' role='alert'>");
	        out.println("<strong>Error!</strong> An error occurred while updating the file type.");
	        out.println("</div>");
	    } finally {
	        out.close();  
	    }  
	}



    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateData() {
        super();
        // TODO Auto-generated constructor stub
    }

}
