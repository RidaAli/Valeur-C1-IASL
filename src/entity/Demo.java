package entity;

import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Demo {

    public static void main(String args[]) {
        Person p = new Person();
        //p.setFirstName("Hendro Steven");
        //p.setLastName("Salatiga, Indonesia");

       // Demo demo = new Demo();
       // demo.persist(p);
       Demo demo = new Demo();
      System.out.println(demo.select().getFirstName());
    }

    public void persist(Object object) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JavaApplication1PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    
       public Person select() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JavaApplication1PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
         Person person= new Person();
        try {
      person= em.find(Person.class, 1l);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return person;
    }
}
