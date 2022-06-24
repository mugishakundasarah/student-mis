package school.studentmis.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course_assignment")
public class CourseAssignment implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 14578578345763457L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String assignedOn;
    private String lastUpdtedBy;
    @Enumerated(EnumType.STRING)
    private AssignementStatus status;
    private String lastStatusChangedOn;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;

    public CourseAssignment() {
    }
    public CourseAssignment(String assignedBy, AssignementStatus status) {
        this.assignedOn = LocalDateTime.now().toString();
        this.lastUpdtedBy = assignedBy;
        this.status = status;
        this.lastStatusChangedOn = LocalDateTime.now().toString();
    }
    public CourseAssignment(Long id, String lastUpdtedBy, AssignementStatus status) {
        this.id = id;
        this.lastUpdtedBy = lastUpdtedBy;
        this.status = status;
        this.lastStatusChangedOn = LocalDateTime.now().toString();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAssignedOn() {
        return assignedOn;
    }
    public void setAssignedOn(String assignedOn) {
        this.assignedOn = assignedOn;
    }

    public String getLastUpdtedBy() {
        return lastUpdtedBy;
    }
    public void setLastUpdtedBy(String lastUpdtedBy) {
        this.lastUpdtedBy = lastUpdtedBy;
    }
    public AssignementStatus getStatus() {
        return status;
    }
    public void setStatus(AssignementStatus status) {
        this.status = status;
    }
    public String getLastStatusChangedOn() {
        return lastStatusChangedOn;
    }
    public void setLastStatusChangedOn(String lastStatusChangedOn) {
        this.lastStatusChangedOn = lastStatusChangedOn;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
}