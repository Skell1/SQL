import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PurchaseList")
public class Purchase {
    @EmbeddedId
    private Key1 id;

    @ManyToOne
    @MapsId("studentName")
    @JoinColumn(name = "student_name",insertable = false, updatable = false)
    Student student;

    @ManyToOne
    @MapsId("courseName")
    @JoinColumn(name = "course_name",insertable = false, updatable = false)
    Course course;

    @Column(name = "price")
    private int purchasePrice;

    @Column(name = "subscription_date")
    private Date purchaseDate;

    public Key1 getId() {
        return id;
    }

    public void setId(Key1 id) {
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

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getSubscriptionDate() {
        return purchaseDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.purchaseDate = subscriptionDate;
    }
}
