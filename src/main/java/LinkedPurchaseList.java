import javax.persistence.*;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {

    @EmbeddedId
    private Key3 id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id",insertable = false, updatable = false)
    Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id",insertable = false, updatable = false)
    Course course;

    public Key3 getId() {
        return id;
    }

    public void setId(Key3 id) {
        this.id = id;
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

    public LinkedPurchaseList(Key3 id) {
        this.id = id;
    }
}
