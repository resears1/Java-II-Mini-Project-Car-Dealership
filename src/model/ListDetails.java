package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="list_details")
public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@Column(name="POST_DATE")
	private LocalDate postDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="DEALER_ID")
	private Dealer dealer;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
		@JoinTable
		(
			name = "cars_on_list", joinColumns= {@JoinColumn(name="LIST_ID",referencedColumnName="LIST_ID")},
			inverseJoinColumns= {@JoinColumn(name="CAR_ID",referencedColumnName="ID", unique=true)}
		)
	private List<ListCar> listOfCars;
	
	public ListDetails() {
		super();
	}
	
	public ListDetails(int id, String listName, LocalDate postDate, Dealer dealer, List<ListCar> listOfCars) {
		super();
		this.id = id;
		this.listName = listName;
		this.postDate = postDate;
		this.dealer = dealer;
		this.listOfCars = listOfCars;
	}

	public ListDetails(String listName, LocalDate postDate, Dealer dealer, List<ListCar> listOfCars) {
		super();
		this.listName = listName;
		this.postDate = postDate;
		this.dealer = dealer;
		this.listOfCars = listOfCars;
	}

	public ListDetails(String listName, LocalDate postDate, Dealer dealer) {
		super();
		this.listName = listName;
		this.postDate = postDate;
		this.dealer = dealer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public List<ListCar> getListOfCars() {
		return listOfCars;
	}

	public void setListOfCars(List<ListCar> listOfCars) {
		this.listOfCars = listOfCars;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", postDate=" + postDate + ", dealer=" + dealer
				+ ", listOfCars=" + listOfCars + "]";
	}
}
