package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    private CarDao carDao;

    @Transactional
    @Override
    public void addCar (Car car) {carDao.addCar(car);}

    @Override
    public List<Car> listCar() {
        return  carDao.listCar();
    }

}

