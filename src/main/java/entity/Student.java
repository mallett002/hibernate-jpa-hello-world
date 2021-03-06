// Student Class: Many Students have one Guide
package entity;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="enrollment_id", nullable=false)
    private String enrollmentId;

    private String name; // doesn't need @Column bc column name is "name" as well

    // Owner of relationship: Has ManyToOne, and holds primary key of guide (guide's foreign key) in DB
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE}) // many Students have one Guide
    @JoinColumn(name="guide_id") // In student table, use guide_id (the primary key from guide table) as foreign key
    private Guide guide;
    
    public Guide getGuide() {return this.guide;}
    
    public void setGuide(Guide guide) {
    	this.guide = guide;
    }

    public Student() {}

    public Student(String enrollmentId, String name, Guide guide) {
        this.enrollmentId = enrollmentId;
        this.name = name;
        this.guide = guide;
    }
}