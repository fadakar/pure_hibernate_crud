package Model.DAO;

import Config.HibernateFactory;
import Model.TO.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;

/**
 * @author grf
 */
public class PersonDAO {

    public ArrayList<Person> all() {
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.getSessionFactory().openSession();
        ArrayList<Person> people = null;
        try {
            people = (ArrayList<Person>) session.createQuery("from Person").list(); // hql -> hibernate sql
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            session.close();
        }

        return people;
    }

    public Person find(int id) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.getSessionFactory().openSession();
        Person person = null;
        try {
            person = session.get(Person.class, id);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            session.close();
        }
        return person;
    }

    public void add(Person person) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(person);
            session.getTransaction().commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            session.close();
        }
    }

    public void update(Person person) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(person);
            session.getTransaction().commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            session.close();
        }
    }

    public void delete(Person person) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(person);
            session.getTransaction().commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            session.close();
        }
    }


}
