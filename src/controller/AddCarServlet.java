package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListCar;

/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/addCarServlet")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		int year = Integer.parseInt(request.getParameter("year"));
		
		ListCar lc = new ListCar(make, model, year);
		ListCarHelper dao = new ListCarHelper();
		dao.insertCar(lc);
		
		// This all works thank god
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
