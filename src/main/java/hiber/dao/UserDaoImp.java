package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
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
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User ");
        return query.getResultList();
    }

    @Override
    public User getUser(String model, int series) {
        User user = sessionFactory
                .openSession().createQuery("select c from User c LEFT OUTER JOIN FETCH " +
                        "c.car cc where cc.model=:propM " +
                        "and cc.series=:propS", User.class)
                .setParameter("propM", model)
                .setParameter("propS", series)
                .uniqueResult();
        System.out.println("\n Машина Принадлежит: " + user + "\n");
        return user;
    }

}
