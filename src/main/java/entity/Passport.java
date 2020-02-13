package entity;

import javax.persistence.*;

@Entity
public class Passport {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="passport_number")
	private String passportNumber;
	
	// Not owner. Mapped by Customer.passport
	@OneToOne(mappedBy="passport") // Stored in customer table as "passport_id"
	private Customer customer;
	
	public Passport() {}
	public Passport(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	
	public Customer getCustomer() {return customer;}
}
