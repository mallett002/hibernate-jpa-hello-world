package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="guide")
public class Guide {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="staff_id", nullable=false)
    private String staffId;

    private String name;
    private Integer salary;
    
    // one guide has many students
    // "guide" in Student class sets "students" here
    @OneToMany(mappedBy="guide", cascade={CascadeType.PERSIST}) // Not the owner. mappedBy "guide" in Student class
    private Set<Student> students = new HashSet<Student>();
    
    public Set<Student> getStudents() {return this.students;}

    public Guide() {}

    public Guide(String staffId, String name, Integer salary) {
        this.staffId = staffId;
        this.name = name;
        this.salary = salary;
    }
    
    public void addStudent(Student student) {
    	// Bi-directional flow:
    	students.add(student); // Add student to list of Guide's students
    	student.setGuide(this); // Associate the guide to that student as well
    }
}