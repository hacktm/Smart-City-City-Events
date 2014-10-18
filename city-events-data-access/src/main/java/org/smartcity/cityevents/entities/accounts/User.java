package org.smartcity.cityevents.entities.accounts;

import javax.persistence.*;

@Entity
@DiscriminatorValue("1")
public class User extends Account {

    @Column(name = "firstName", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    private String firstName;

    @Column(name = "lastName", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Integer getAccountType() {
        return USER_ACCOUNT_TYPE_ID;
    }
}
