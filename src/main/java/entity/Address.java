/* Address Class, Component for DB with no primary key */
package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable // @Embeddable: to be persisted in DB, but won't have primary key in DB
public class Address {
	@Column(name="street")
    private String street;

	@Column(name="city")
    private String city;
	
	@Column(name="zipcode")
    private String zipcode;

    public Address() {}
    public Address(String street, String city, String zipcode) {
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
    }
}