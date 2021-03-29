import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.*;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
//        String url = "jdbc:mysql://localhost:3306/skillbox";
//        String user = "root";
//        String password = "glebas94";
//
//        Connection connection = DriverManager.getConnection(url, user, password);
//        Statement statement = connection.createStatement();
//
//        ResultSet resultSet = statement.executeQuery("SELECT course_name, " +
//            "COUNT(MONTH(subscription_date)) / COUNT(DISTINCT MONTH(subscription_date)) AS count_per_month " +
//            "FROM purchaselist GROUP BY course_name")
//        printResult(resultSet, "Среднее количество покупок за год: ");
//
//        connection.close();

        Session session = HibernateUtil.getSessionFactory().openSession();

        String allPurchasesHQL = "From " + PurchaseList.class.getSimpleName();
        List<PurchaseList> purchaseLists = session.createQuery(allPurchasesHQL).getResultList();

        purchaseLists.forEach(s -> {
            printPurchaseData(s);
            session.save(new LinkedPurchaseList(
                    new LinkedPurchaseListPK(s.getStudent().getId(), s.getCourse().getId()),
                    s.getStudent(),
                    s.getCourse(),
                    s.getStudent().getName(),
                    s.getCourse().getName(),
                    s.getPrice(),
                    s.getSubscriptionDate()
            ));
        });

        session.close();
    }

    private static void printPurchaseData(PurchaseList purchase) {
        System.out.printf("student_id: %s%ncourse_id: %s%nstudent_name: %s%ncourse_name: %s%nprice: %s%n" +
                        "subscription_date:  %s%n-----------------------------------------%n",
                purchase.getStudent().getId(),
                purchase.getCourse().getId(),
                purchase.getStudent().getName(),
                purchase.getCourse().getName(),
                purchase.getPrice(),
                purchase.getSubscriptionDate()
        );
    }

}
