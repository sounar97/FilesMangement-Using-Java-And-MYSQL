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
 * Servlet implementation class DeleteData
 */
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteData() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        try {  
            String fileName = request.getParameter("file_name"); // Get the file name from the request
                  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/files?characterEncoding=utf8", "root", "root");  
                  
            PreparedStatement ps = con.prepareStatement("DELETE FROM files WHERE file_name = ?"); // Update the table and column names as necessary
            ps.setString(1, fileName); 
            int rowsAffected = ps.executeUpdate();

            // Include Bootstrap CSS
            out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
            out.println("<div class='container mt-4'>");
            
            // Bootstrap styled confirmation message
            if (rowsAffected > 0) {
                out.println("<div class='alert alert-success' role='alert'>");
                out.println("<strong>Success!</strong> File deleted successfully.");
            } else {
                out.println("<div class='alert alert-warning' role='alert'>");
                out.println("<strong>Warning!</strong> File not found.");
            }
            out.println("</div>"); // Close alert div
            out.println("</div>"); // Close container div
        } catch (Exception e) {
            e.printStackTrace();
            // Bootstrap styled error message
            out.println("<div class='alert alert-danger' role='alert'>");
            out.println("<strong>Error!</strong> An error occurred while deleting the file.");
            out.println("</div>");
        } finally {
            out.close();  
        }  
    }


	}




