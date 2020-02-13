package entity;

import javax.persistence.*;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	@OneToOne(cascade= {CascadeType.PERSIST})
	@JoinColumn(name="passport_id", unique=true) // use passport_id as foreign key
	private Passport passport;

	public Customer() {}

	public Customer(String name, Passport passport) {
		this.name = name;
		this.passport = passport;
	}
	
	public Passport getPassport() { return passport;}
}
