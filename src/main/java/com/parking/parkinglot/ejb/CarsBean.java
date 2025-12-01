package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.entities.Car;
import com.parking.parkinglot.entities.User;

import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CarsBean {

    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    // -------------------------------------------------------
    // FIND ALL CARS
    // -------------------------------------------------------
    public List<CarDto> findAllCars() {
        LOG.info("findAllCars");
        try {
            TypedQuery<Car> typedQuery =
                    entityManager.createQuery("SELECT c FROM Car c", Car.class);

            List<Car> cars = typedQuery.getResultList();

            return copyCarsToDto(cars);

        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<CarDto> copyCarsToDto(List<Car> cars) {
        List<CarDto> dtoList = new ArrayList<>();

        for (Car car : cars) {
            dtoList.add(new CarDto(
                    car.getId(),
                    car.getLicensePlate(),
                    car.getParkingSpot(),
                    car.getOwner() != null ? car.getOwner().getUsername() : null
            ));
        }

        return dtoList;
    }

    public void createCar(String licensePlate, String parkingSpot, Long ownerId) {
        LOG.info("createCar");

        try {
            Car car = new Car();
            car.setLicensePlate(licensePlate);
            car.setParkingSpot(parkingSpot);


            User owner = entityManager.find(User.class, ownerId);
            car.setOwner(owner);

            entityManager.persist(car);

        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public CarDto findCarById(Long carId) {
        LOG.info("findCarById");

        try {
            Car car = entityManager.find(Car.class, carId);

            return new CarDto(
                    car.getId(),
                    car.getLicensePlate(),
                    car.getParkingSpot(),
                    car.getOwner().getUsername()
            );

        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public void updateCar(Long id, String licensePlate, String parkingSpot, Long ownerId) {
        LOG.info("updateCar");

        try {
            Car car = entityManager.find(Car.class, id);

            car.setLicensePlate(licensePlate);
            car.setParkingSpot(parkingSpot);

            User owner = entityManager.find(User.class, ownerId);
            car.setOwner(owner);

        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public void deleteCar(Long carId) {
        LOG.info("deleteCar");

        try {
            Car car = entityManager.find(Car.class, carId);
            if (car != null) {
                entityManager.remove(car);
            }
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

}
