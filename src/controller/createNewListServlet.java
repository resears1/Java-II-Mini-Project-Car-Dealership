package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dealer;
import model.ListCar;
import model.ListDetails;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListCarHelper lch = new ListCarHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: "+ listName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String dealerName = request.getParameter("dealerName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch(NumberFormatException e) {
			ld = LocalDate.now();
		}
		
		String[] selectedCars = request.getParameterValues("allCarsToAdd");
		List<ListCar> selectedCarsInList = new ArrayList<ListCar>();
		
		if(selectedCars != null && selectedCars.length >0) {
			for(int i = 0; i<selectedCars.length; i++) {
				System.out.println(selectedCars[i]);
				ListCar c = lch.searchForCarById(Integer.parseInt(selectedCars[i]));
				selectedCarsInList.add(c);
			}
		}
		
		Dealer dealer = new Dealer(dealerName);
		ListDetails sld = new ListDetails(listName, ld, dealer);
		sld.setListOfCars(selectedCarsInList);
		ListDetailsHelper slh = new ListDetailsHelper();
		slh.insertNewListDetails(sld);
		
		System.out.println("Success!");
		System.out.println(sld.toString());
		
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
