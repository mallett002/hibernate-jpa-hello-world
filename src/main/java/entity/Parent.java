package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Parent {
	@EmbeddedId
	private ParentPrimaryKey parentPrimaryKey;
	
	// Not the owner of relationship: mappedBy Child.parent
	@OneToMany(mappedBy="parent", cascade= {CascadeType.PERSIST})
	private Set<Child> children = new HashSet<Child>();
	
	public void addChild(Child child) {
		children.add(child);
	}

	public Parent() {}
	public Parent(ParentPrimaryKey parentPrimaryKey) {
		super();
		this.parentPrimaryKey = parentPrimaryKey;
	}
	
}
