package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   // @Autowired        не использую над полями, привязываюсь через конструктор
    private SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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

    //  private Session session;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getCarOwner(String model, String series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where car.model = :model and car.series= :series")
                .setParameter("model", model).setParameter("series", series);
        System.out.println("Пользователь авто " + model + ", " + series);
        return query.getResultList();
    }

}



