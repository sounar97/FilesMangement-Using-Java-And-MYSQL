package files;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;



/**
 * Servlet implementation class DispData
 */
public class DispData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispData() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 
        try { 
            String fileName = request.getParameter("file_name"); // Get the file name from the request
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/files?characterEncoding=utf8", "root", "root"); 
            PreparedStatement ps = con.prepareStatement("SELECT * FROM files WHERE file_name LIKE ?"); // Adjusted for file name search
            ps.setString(1, "%" + fileName + "%"); // Use LIKE for partial matches
            
            // Include Bootstrap CSS
            out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
            out.println("<div class='container mt-4'>");
            out.println("<h2>File Search Results:</h2>");
            out.println("<table class='table table-striped'>"); // Use Bootstrap table classes
            
            ResultSet rs = ps.executeQuery(); 
            ResultSetMetaData rsmd = rs.getMetaData(); 
            int total = rsmd.getColumnCount(); 
            out.println("<thead class='thead-dark'><tr>"); // Use Bootstrap classes for table header
            for (int i = 1; i <= total; i++) { 
                out.println("<th>" + rsmd.getColumnName(i) + "</th>"); 
            } 
            out.println("</tr></thead><tbody>");
            
            while (rs.next()) { 
                out.println("<tr>");
                for (int i = 1; i <= total; i++) {
                    out.println("<td>" + rs.getString(i) + "</td>"); // Adjusted to handle string data
                }
                out.println("</tr>");
            } 
            out.println("</tbody></table>"); 
            out.println("</div>"); // Close container div
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close(); 
        } 
    }




}
