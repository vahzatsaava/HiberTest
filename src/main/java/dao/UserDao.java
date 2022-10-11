package dao;

import model.Developer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class UserDao {
    public Developer findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Developer.class, id);
    }

    public void save(Developer developer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(developer);
        t.commit();
        session.close();
    }
    public void update(Developer developer){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(developer);
        t.commit();
        session.close();
    }
    public void delete(Developer developer){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(developer);
        t.commit();
        session.close();
    }
}
