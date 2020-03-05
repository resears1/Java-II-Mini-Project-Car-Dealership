package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dealer;
import model.ListCar;
import model.ListDetails;

/**
 * Servlet implementation class EditExistingListServlet
 */
@WebServlet("/editExistingListServlet")
public class EditExistingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditExistingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListCarHelper lch = new ListCarHelper();
		DealerHelper dh = new DealerHelper();
		
		int idToEdit = Integer.parseInt(request.getParameter("id"));
		ListDetails toEdit = ldh.searchForListById(idToEdit);
		
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		toEdit.setListName(listName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		toEdit.setPostDate(ld);
		
		String dealerName = request.getParameter("dealerName");
		Dealer dealer;
		
		try {
			dealer = dh.searchForDealerByName(dealerName);
		} catch (NoResultException ex) {
			dealer = new Dealer(dealerName);
		} catch (Exception ex) {
			dealer = new Dealer(dealerName);
		}
		
		toEdit.setDealer(dealer);
		
		List<ListCar> previousListOfCars = toEdit.getListOfCars();
		
		String[] selectedCars = request.getParameterValues("carsToAdd");
		List<ListCar> selectedCarsInList = new ArrayList<ListCar>();
		
		if (selectedCars != null && selectedCars.length > 0) {
			for (int i = 0; i < selectedCars.length; i++) {
				System.out.println(selectedCars[i]);
				ListCar c = lch.searchForCarById(Integer.parseInt(selectedCars[i]));
				selectedCarsInList.add(c);
			}
			
			previousListOfCars.addAll(selectedCarsInList);
		}
		
		toEdit.setListOfCars(previousListOfCars);
		
		ldh.updateList(toEdit);
		
		System.out.println("Success!");
		System.out.println(toEdit.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
