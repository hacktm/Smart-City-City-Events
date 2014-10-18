package org.smartcity.cityevents.dao.accounts;

import org.smartcity.cityevents.dao.AbstractRepository;
import org.smartcity.cityevents.entities.accounts.User;

public interface UserDAO extends AbstractRepository<Integer, User> {

    public User getById(Integer id);

    public User getByUserName(String userName);

    public User getByEmail(String email);
}
