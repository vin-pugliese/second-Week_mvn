package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import utils.Log;

import javax.imageio.spi.ServiceRegistry;

public class HibernateRunner {



    public void run() {

        SessionFactory sessionFactory = null;
        Session session = null;
        Log L = Log.getInstance();
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();

        try{
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        session = sessionFactory.openSession();
        persistPerson(session);



        } catch(Exception e){
                L.info(e.getMessage());
        }
    }

    public void persistPerson(Session session){
        try{
            Transaction transaction = session.getTransaction();
            transaction.begin();

            Person person = new Person();
            person.setFirstName("vincenzo");
            person.setLastName("Pugliese");

            session.save(person);
            transaction.commit();


        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
