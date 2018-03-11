package com.edu4java.servelets;
import com.edu4java.servelets.ImportarExcel;






import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	public	static ArrayList<String> data3= ImportarExcel.data;
	public static  ArrayList<Double> data4= ImportarExcel.data2;
	
private static final long serialVersionUID = 1L;



	
	
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp )
			throws ServletException, IOException {
		
		
		ImportarExcel.ObtenerArchivos();
		
		
		
		
		String dni1 = req.getParameter("dni");
	
		
		
		
		
		for( String dni: data3) {
			int  contador3=-1;
		
			if(dni.equals(dni1)){
				 contador3 = data3.indexOf(dni);
				
				 response(resp, "El promotor con dni "+ dni1+" ha vendido " + data4.get((contador3*4))+" unidades de s8, otras  "+ data4.get((contador3*4)+1)+" unidades del modelo note 8 ,va a tener un ajuste de "+ data4.get((contador3*4)+2)+ " y va a percibir "+ data4.get((contador3*4)+3)+ " euros brutos este mes" );
			break;
		
		}
			else {
				
             continue;
             

				
				
			}
		
			
					
					
			
		}

		}
		
     

	private void response(HttpServletResponse resp, String msg)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");
	}
}