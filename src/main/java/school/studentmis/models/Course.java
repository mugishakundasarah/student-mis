package school.studentmis.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "course")
public class Course implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String title;
    private Long numHours;
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    //@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<CourseAssignment> students = new HashSet<>();
    public Course() {}
    public Course(String title,Long numHours) {

        this.title=title;
        this.numHours=numHours;

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Long getNumHours() {
        return numHours;
    }
    public void setNumHours(Long numHours) {
        this.numHours = numHours;
    }
    public Set<CourseAssignment> getStudents() {
        return students;
    }
    public void setStudents(Set<CourseAssignment> students) {
        this.students = students;
    }



}