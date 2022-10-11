import dao.UserDao;
import model.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Runner {
    private static SessionFactory sessionFactory;
    public static void main(String[] args) {
        SessionFactory sf = buildSessionFactory();
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        Developer developer = new Developer("Alex","Gre","wewe",4);
        session.save(developer);

        t.commit();


    }

    private static SessionFactory buildSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Developer.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Throwable e) {
                System.err.println("Failed");

            }
        }
        return sessionFactory;
    }
}
