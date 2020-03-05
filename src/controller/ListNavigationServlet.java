package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListCar;
import model.ListDetails;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListDetailsHelper ldh = new ListDetailsHelper();
		String act = request.getParameter("doThisToCar");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			
		} else if (act.equals("delete")) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				ListDetails listToDelete = ldh.searchForListById(id);
				ldh.deleteItem(listToDelete);

			} catch (NumberFormatException e) {
				System.out.println("No button selected.");
				
			} finally {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
				
			}
		} else if (act.equals("edit")) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				ListDetails listToEdit = ldh.searchForListById(id);
				ListCarHelper lch = new ListCarHelper();
				List<ListCar> allCars = lch.showAllCars();
				List<ListCar> currentListCars = listToEdit.getListOfCars();

				for (int i = 0; i < allCars.size(); i++) {
					for (int j = 0; j < currentListCars.size(); j++) {
						if (allCars.get(i).getId() == currentListCars.get(j).getId()) {
							allCars.remove(i);
						}
					}
				}

				request.setAttribute("listToEdit", listToEdit);
				request.setAttribute("allCarsToAdd", allCars);
				
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
				
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
				
			}

		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/addCarsForListServlet").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
