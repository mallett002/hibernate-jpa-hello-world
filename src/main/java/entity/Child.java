package entity;

import javax.persistence.*;

/*
 	child table:
 		-columns: id, name, firstname_fk, lastname_fk
*/

@Entity
public class Child {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	// Has composite foreign key that references Parent primary key
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="firstname_fk", referencedColumnName="firstname"),
		@JoinColumn(name="lastname_fk", referencedColumnName="lastname")
	})
	private Parent parent;
	
	public Child() {}
	public Child(String name) {
		this.name = name;
	}
}
