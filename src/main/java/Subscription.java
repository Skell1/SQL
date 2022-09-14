import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Subscriptions")
public class Subscription {
    @EmbeddedId
    private Key id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id",insertable = false, updatable = false)
    Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id",insertable = false, updatable = false)
    Course course;


    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
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

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
