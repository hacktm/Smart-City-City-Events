package org.smartcity.cityevents.dao.accounts;

import org.smartcity.cityevents.dao.BaseDAO;
import org.smartcity.cityevents.entities.accounts.User;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class UserDAOImpl extends BaseDAO implements UserDAO {

    @Override
    public Integer save(User user) {
        return saveEntity(user);
    }

    @Override
    public User get(Integer primaryKey) {
        return (User) get(User.class, primaryKey);
    }

    @Override
    public void update(User user) {
        updateEntity(user);
    }

    @Override
    public void delete(Integer primaryKey) {
        deleteEntity(User.class, primaryKey);
    }

    @Override
    public User getById(Integer id) {
        return get(id);
    }

    @Override
    public User getByUserName(String userName) {
        return (User) getByProperty(User.class, "userName", userName);
    }

    @Override
    public User getByEmail(String email) {
        return (User) getByProperty(User.class, "email", email);
    }
}
