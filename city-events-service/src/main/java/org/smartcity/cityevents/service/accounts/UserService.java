package org.smartcity.cityevents.service.accounts;

public interface UserService {
    public String getById(Integer id);

    public String getByUserName(String userName);

    public String getByEmail(String email);
}
