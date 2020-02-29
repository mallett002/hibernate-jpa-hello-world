package entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Friend {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	String name;
	String email;
	
	// Creates a new "friend_nickname" table with columns "nickname" and "friend_id"
	@ElementCollection // bc mapping collection of simple value types
	@CollectionTable( // storing collection values in new collection table
		name="friend_nickname",
		joinColumns=@JoinColumn(name="friend_id") // will join with friend table's id
	)
	@Column(name="nickname")
	Collection<String> nicknames = new ArrayList<String>();
	
	// Can also map collection of @Embeddable items
	/* Create new "friend_address" table with city, street, zipcode, and friend_id columns*/
	@ElementCollection
	@CollectionTable(name="friend_address", joinColumns=@JoinColumn(name="friend_id"))
	@AttributeOverrides({
		@AttributeOverride(name="zipcode", column=@Column(name="address_zipcode")),
		@AttributeOverride(name="street", column=@Column(name="address_street")),
		@AttributeOverride(name="city", column=@Column(name="address_city"))
	})
	Collection<Address> addresses = new ArrayList<Address>();

	public Friend() {}
	public Friend(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public Collection<String> getNickNames() {return nicknames;}
	
	public Collection<Address> getAddresses() {return addresses;}

	public String toString() {
		return "Friend [id=" + id + ", name=" + name + ", email=" + email + ", nicknames=" + nicknames + ", addresses=" + addresses + "]";
	}
}
