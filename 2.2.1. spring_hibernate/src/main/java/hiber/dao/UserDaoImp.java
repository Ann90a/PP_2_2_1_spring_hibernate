package hiber.dao;

import hiber.model.User;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public List<User> getUserCar(String model, int series) {
        Session ses = sessionFactory.getCurrentSession();
        Query q = ses.createQuery("from User as u where " +
                "" + "u.userCar.model=:model and u.userCar.series=:series");
        q.setParameter("model", model);
        q.setParameter("series", series);
        return q.getResultList();
    }


}
