import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("/n/n/n/n/n");
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        loadLinkedP(session);
        Course course = session.get(Course.class, 1);
        sessionFactory.close();
    }

    public static void loadLinkedP(Session session) {
        String hql = "From " + Subscription.class.getSimpleName();
        List<Subscription> subscriptions = session.createQuery(hql).getResultList();
        for (Subscription sub : subscriptions) {
            LinkedPurchaseList linkedPurchase = new LinkedPurchaseList(new Key3(sub.student.getId(),sub.course.getId()));
            linkedPurchase.setCourse(sub.getCourse());
            linkedPurchase.setStudent(sub.getStudent());
            session.getTransaction().begin();
            session.replicate(linkedPurchase, ReplicationMode.OVERWRITE);
            session.getTransaction().commit();
        }

    }
}
