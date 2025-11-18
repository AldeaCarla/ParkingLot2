package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.UsersDto;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.parkinglot.entities.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());
    @PersistenceContext
    EntityManager EntityManager;

    public List<UsersDto.CarDto> findAllCars() {
        LOG.info("findAllCars");
        try {
            TypedQuery<Car> typedQuery = EntityManager.createQuery("SELECT c FROM Car c", Car.class);

            List<Car> cars = typedQuery.getResultList();

            return copyCarsToDto(cars);

        } catch (Exception ex) {
            throw new EJBException(ex);
        }

    }

    private List<UsersDto.CarDto> copyCarsToDto(List<Car> cars) {
        List<UsersDto.CarDto> CarDto = new ArrayList<>();
        for (Car car : cars) {

        }
        return CarDto;
    }

}