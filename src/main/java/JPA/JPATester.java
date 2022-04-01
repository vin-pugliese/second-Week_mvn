package JPA;

import utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class JPATester {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction etx;

    public static void main(String[] args) {
        JPATester jpaTester = new JPATester();
        jpaTester.createTransaction();
    }
    public void init() {
        emf = JPAUtils.getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    public void createTransaction() {
        this.init();
        etx =  em.getTransaction();
        etx.begin();

        Family family;
        Person person;

        Query q = em.createQuery("select m from Person m");


    }

    public void print() {

    }

}
