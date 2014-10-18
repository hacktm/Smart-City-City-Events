package org.smartcity.cityevents.service.accounts;

import org.smartcity.cityevents.dao.accounts.UserDAO;
import org.smartcity.cityevents.entities.accounts.User;
import org.smartcity.cityevents.service.transport.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = IllegalArgumentException.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO usersDAO;

    @Autowired
    private JSONSerializer jsonSerializer;

    @Override
    public String getById(Integer id) {
        User user = usersDAO.get(id);
        if (user == null) {
            throw new IllegalArgumentException("There is no user with the ID " + id);
        }

        return jsonSerializer.serialize(user);
    }

    @Override
    public String getByUserName(String userName) {
        User user = usersDAO.getByUserName(userName);
        if (user == null) {
            throw new IllegalArgumentException("There is no user with the userName " + userName);
        }

        return jsonSerializer.serialize(user);
    }

    @Override
    public String getByEmail(String email) {
        User user = usersDAO.getByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("There is no user with the email " + email);
        }

        return jsonSerializer.serialize(user);
    }
}
