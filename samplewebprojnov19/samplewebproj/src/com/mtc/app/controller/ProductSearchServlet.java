package com.mtc.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtc.app.dao.ProductDAOImpl;
import com.mtc.app.vo.Product;

/**
 * Servlet implementation class ProductSearchServlet
 */
@WebServlet("/searchproduct")
public class ProductSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int pid = Integer.parseInt(request.getParameter("productid"));
		
		ProductDAOImpl daoImpl = new ProductDAOImpl();
		
		Product product = daoImpl.findById(pid);
		
		PrintWriter out =  response.getWriter();
		
		out.println("<html><body>");
		
		out.println("<h2 align=center>Product Record</h2>");
		out.println("<div align=center>");
		out.println("<table border=2>");
		
		out.println("<tr>");
		out.println("<th>Id</th><th>Name</th><th>Price</th><th>Description</th><th>Quantity</th>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>"+product.getId()+"</td>");
		out.println("<td>"+product.getName()+"</td>");
		out.println("<td>"+product.getPrice()+"</td>");
		out.println("<td>"+product.getDescription()+"</td>");
		out.println("<td>"+product.getQuantity()+"</td>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("</div>");
		out.println("</body></html>");
		
	}

}
