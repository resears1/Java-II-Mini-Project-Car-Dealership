
import java.util.List;

import controller.DealerHelper;
import model.Dealer;

public class Tester {
	public static void main(String[] args) {
		Dealer stew = new Dealer("Stew Hansen");
		DealerHelper dh = new DealerHelper();
		
		dh.insertDealer(stew);
		
		List<Dealer> allDealers = dh.showAllDealers();
		for(Dealer a: allDealers) {
			System.out.println(a.toString());
		}
	}
}
