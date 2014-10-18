package org.smartcity.cityevents.entities.accounts;

import javax.persistence.*;

@Entity
@DiscriminatorValue("4")
public class Admin extends Account {

    @Column(name = "firstName", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    private String firstName;

    @Column(name = "lastName", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    private String lastName;

    @Column(name = "phoneNumber", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    private String phoneNumber;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Integer getAccountType() {
        return ADMIN_ACCOUNT_TYPE_ID;
    }
}
