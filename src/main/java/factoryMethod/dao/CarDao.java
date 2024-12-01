package factoryMethod.dao;

import factoryMethod.Car;

public interface CarDao {
    void saveCar(Car car);
    Car loadCar();
}
