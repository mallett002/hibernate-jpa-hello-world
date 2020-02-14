package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Actor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy="actors")
	Set<Movie> movies = new HashSet<Movie>();
	
	public Actor() {}
	public Actor(String name) {
		this.name = name;
	}
	
	public Set<Movie> getMovies() {return movies;}
}
