package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.UsersDto;
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
public class UsersBean {

    private static final Logger LOG = Logger.getLogger(UsersBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public static List<UsersDto> findAllUsers() {
        try {
            LOG.info("findAllUsers");

            TypedQuery<User> query =
                    entityManager.createQuery("SELECT u FROM User u", User.class);

            List<User> users = query.getResultList();
            return copyUsersToDto(users);

        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<UsersDto> copyUsersToDto(List<User> users) {
        List<UsersDto> usersDto = new ArrayList<>();

        for (User u : users) {
            usersDto.add(new UsersDto(
                    u.getId(),
                    u.getUsername(),
                    u.getEmail()
            ));
        }

        return usersDto;
    }
}
