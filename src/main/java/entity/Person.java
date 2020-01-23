/* Person Class, which is an Entity with Primary Key in DB */
package entity;

import javax.persistence.*;

@Entity // Entity: has primary key in DB
@Table(name="Person")
public class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name", nullable=false)
    private String name;

    @Embedded // Component to be persisted in DB, no primary key
    @AttributeOverrides({
    	@AttributeOverride(name="street", column=@Column(name="home_street")), // street field mapped to billing_street column
    	@AttributeOverride(name="city", column=@Column(name="home_city")),
    	@AttributeOverride(name="zipcode", column=@Column(name="home_zipcode"))
    })
    private Address homeAddress;
    
    @Embedded // Component to be persisted in DB, no primary key
    @AttributeOverrides({
    	@AttributeOverride(name="street", column=@Column(name="billing_street")), // street field mapped to billing_street column
    	@AttributeOverride(name="city", column=@Column(name="billing_city")),
    	@AttributeOverride(name="zipcode", column=@Column(name="billing_zipcode"))
    })
    private Address billingAddress;

    public Person() {}
    public Person(String name, Address homeAddress, Address billingAddress) {
        this.name = name;
        this.homeAddress = homeAddress;
        this.billingAddress = billingAddress;
    }
}