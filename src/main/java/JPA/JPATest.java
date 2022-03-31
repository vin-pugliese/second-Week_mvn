package JPA;

import utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class JPATest {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;

    public void init(){
        emf = JPAUtils.getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    public void createTransaction(){
        this.init();
        et = em.getTransaction();
        et.begin();

        Family family;
        Person person;

        Query q = em.createQuery("select m from Person m");
    }

}
