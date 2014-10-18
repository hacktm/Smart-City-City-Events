package org.smartcity.cityevents.entities.accounts;

import org.smartcity.cityevents.entities.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Account", schema = BaseEntity.MAIN_SCHEMA_NAME, uniqueConstraints = {@UniqueConstraint(columnNames = {"userName", "email"})})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER, length = 1)
@NamedQueries({
    @NamedQuery(
        name = "Account.getByUserName",
        query = "SELECT account FROM Account account WHERE account.userName = :userName"
    ),

    @NamedQuery(
        name = "Account.getByEmail",
        query = "SELECT account FROM Account account WHERE account.email = :email"
    )
})
public abstract class Account extends BaseEntity {

    private static final String NAME = "account";

    /** The ID used to specify an {@link User} account type */
    public static final Integer USER_ACCOUNT_TYPE_ID = 1;

    /** The ID used to specify an {@link org.smartcity.cityevents.entities.accounts.Institution} account type */
    public static final Integer CULTURAL_INSTITUTION_ACCOUNT_TYPE_ID = 2;

    /** The ID used to specify a {@link Club} account type */
    public static final Integer CLUB_ACCOUNT_TYPE_ID = 3;

    /** The ID used to specify a {@link org.smartcity.cityevents.entities.accounts.Admin} account type */
    public static final Integer ADMIN_ACCOUNT_TYPE_ID = 4;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = NAME + "_sequence")
    @SequenceGenerator(name = NAME + "_sequence", sequenceName = MAIN_SCHEMA_NAME + "." + NAME + "_ID_sequence", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name = "userName", nullable = false, insertable = true, updatable = false, length = 30, precision = 0)
    private String userName;

    @Column(name = "password", nullable = false, insertable = true, updatable = false, length = 30, precision = 0)
    private String password;

    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    private String email;

    @Column(name = "status", nullable = false, insertable = true, updatable = true, length = 35, precision = 0)
    private String status;

    @Column(name = "failedLoginAttempts", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer failedLoginAttempts;

    @Column(name = "registrationDate", nullable = false, insertable = true, updatable = true, length = 13, precision = 0)
    private Timestamp registrationDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = AccountPrivilege.class)
    @JoinColumn(name = "privilegeId", referencedColumnName = "id", nullable = false)
    private AccountPrivilege accountPrivilege;

    @Column(name = "country", nullable = false, insertable = true, updatable = true, length = 2, precision = 0)
    private String country;

    @Column(name = "county", nullable = false, insertable = true, updatable = true, length = 2, precision = 0)
    private String county;

    @Column(name = "language", nullable = false, insertable = true, updatable = true, length = 2, precision = 0)
    private String language;

    @Transient
    public abstract Integer getAccountType();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(Integer failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public AccountPrivilege getAccountPrivilege() {
        return accountPrivilege;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setAccountPrivilege(AccountPrivilege accountPrivilege) {
        this.accountPrivilege = accountPrivilege;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (!id.equals(account.id)) return false;
        if (!email.equals(account.email)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;

        if (id != null) {
            result += result * 31 + id.hashCode();
        }

        if (email != null) {
            result = 31 * result + email.hashCode();
        }

        return result;
    }

    public boolean isAdmin() {
        return getAccountType().equals(Account.ADMIN_ACCOUNT_TYPE_ID);
    }
}
