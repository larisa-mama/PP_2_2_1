package hiber.dao;

import hiber.model.Car;

import javax.transaction.Transactional;
import java.util.List;

public interface CarDao {
    void addCar(Car car);

    @Transactional
    List<Car> listCar();
}
