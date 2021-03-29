import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class PurchaseID implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Course course;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Student student;

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }
}
