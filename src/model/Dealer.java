package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dealer")
public class Dealer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DEALER_ID")
	private int id;
	@Column(name="DEALER_NAME")
	private String dealerName;
	
	public Dealer() {
		super();
	}
	
	public Dealer(int id, String dealerName) {
		super();
		this.id = id;
		this.dealerName = dealerName;
	}
	
	public Dealer(String dealerName) {
		super();
		this.dealerName = dealerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	@Override
	public String toString() {
		return "Dealer [id=" + id + ", dealerName=" + dealerName + "]";
	}
}
