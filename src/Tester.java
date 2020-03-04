
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.DealerHelper;
import controller.ListDetailsHelper;
import model.Dealer;
import model.ListCar;
import model.ListDetails;

public class Tester {
	public static void main(String[] args) {
		Dealer stew = new Dealer("Stew Hansen");
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		//I got lazy with the names
		ListCar test = new ListCar("testMake", "testModel", 2000);
		ListCar test2 = new ListCar("Test2Make", "test2Model", 2001);
		List<ListCar> stewsCars = new ArrayList<ListCar>();
		stewsCars.add(test);
		stewsCars.add(test2);
		
		ListDetails stewList = new ListDetails("Stew's List", LocalDate.now(),stew);
		stewList.setListOfCars(stewsCars);
		
		ldh.insertNewListDetails(stewList);
		
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a: allLists) {
			System.out.println(a);
		}
	}
}
