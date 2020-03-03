package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListCar;
import controller.ListCarHelper;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListCarHelper dao = new ListCarHelper();
		String act = request.getParameter("doThisToCar");
		String path = "/viewAllCarsServlet";
		
		if (act.equals("delete"))
		{//delete does not work: gives me the error "No transaction is currently active"
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ListCar carToDelete = dao.searchForCarById(tempId);
			dao.deleteCar(carToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a car");
			}
		} 
		else if (act.equals("edit"))
		{
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListCar carToEdit = dao.searchForCarById(tempId);
				request.setAttribute("carToEdit", carToEdit);
				path = "/edit-car.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a car");
			}
		} 
		else if (act.equals("add"))
		{
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
