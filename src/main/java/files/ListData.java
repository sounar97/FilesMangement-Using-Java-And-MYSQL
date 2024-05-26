package files;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListData
 */
public class ListData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    try {  
	        Class.forName("com.mysql.cj.jdbc.Driver");  
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/files?characterEncoding=utf8", "root", "root");  
	              
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM files");  
	        ResultSet rs = ps.executeQuery();  
	              
	        // Include Bootstrap CSS
	        out.print("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
	        out.print("<div class='container mt-4'>");
	        out.print("<h2 class='mb-4'>Files List</h2>");
	        out.print("<table class='table table-bordered'>");  
	        out.print("<thead class='thead-dark'><tr>");  
	        
	        // Printing column names with Bootstrap classes
	        ResultSetMetaData rsmd = rs.getMetaData();  
	        int total = rsmd.getColumnCount();  
	        for (int i = 1; i <= total; i++) {  
	            out.print("<th>" + rsmd.getColumnName(i) + "</th>");  
	        }  
	        out.print("</tr></thead><tbody>");  
	              
	        // Printing file records with Bootstrap classes
	        while (rs.next()) {  
	            out.print("<tr>");
	            for (int i = 1; i <= total; i++) {
	                out.print("<td>" + rs.getString(i) + "</td>");  
	            }
	            out.print("</tr>");
	        }  
	        out.print("</tbody></table>");  
	        out.print("</div>"); // Close container div
	    } catch (Exception e) {
	        e.printStackTrace();  
	    } finally {
	        out.close();  
	    }  
	}

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListData() {
        super();
        // TODO Auto-generated constructor stub
    }
   
}
