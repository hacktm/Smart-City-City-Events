package org.smartcity.cityevents.entities.accounts;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Institution extends Account {

    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this)
                .append("email", getEmail())
                .append("userName", getUserName())
                .append("name", getName())
                ;

        return builder.toString();
    }

    @Override
    public Integer getAccountType() {
        return CULTURAL_INSTITUTION_ACCOUNT_TYPE_ID;
    }
}
