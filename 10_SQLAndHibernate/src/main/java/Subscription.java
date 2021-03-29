import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscription {

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "courses_id",
            referencedColumnName = "id")
    private Course course;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id",
            referencedColumnName = "id")
    private Student student;

}