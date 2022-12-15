package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private SessionFactory sessionFactory;


    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }
    @Override
    @Transactional
    public List<Car> listCar() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car ");
        return query.getResultList();
    }
}
