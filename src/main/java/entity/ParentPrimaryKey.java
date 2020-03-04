package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ParentPrimaryKey implements Serializable {
	
	private String firstName;
	private String lastName;
	
	public ParentPrimaryKey() {}
	public ParentPrimaryKey(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public int hashCode() {
		int result = firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ParentPrimaryKey parentPrimaryKey = (ParentPrimaryKey) o;
		if (!firstName.equals(parentPrimaryKey.firstName)) return false;
		if (!lastName.equals(parentPrimaryKey.lastName)) return false;
		return true;
	}
}
