package org.smartcity.cityevents.entities.accounts;

import org.smartcity.cityevents.entities.BaseEntity;
import org.smartcity.cityevents.entities.accounts.Account;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "AccountPrivilege", schema = BaseEntity.MAIN_SCHEMA_NAME)
public class AccountPrivilege extends BaseEntity {

    private static final String NAME = "AccountPrivilege";

    /** ID used to specify the privilege for a ROLE_USER user */
    public static final Integer ROLE_USER_ID = 1;

    /** ID used to specify the privilege for a ROLE_INSTITUTION user */
    public static final Integer ROLE_INSTITUTION_ID = 2;

    /** ID used to specify the privilege for a ROLE_ADMIN user */
    public static final Integer ROLE_ADMIN_ID = 4;

    /** The 'ROLE_USER' authority */
    public static final String ROLE_USER_AUTHORITY = "ROLE_USER";

    /** The 'ROLE_INSTITUTION' authority */
    public static final String ROLE_INSTITUTION_AUTHORITY = "ROLE_INSTITUTION";

    /** The 'ROLE_ADMIN' authority */
    public static final String ROLE_ADMIN_AUTHORITY = "ROLE_ADMIN";

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = NAME + "_sequence")
    @SequenceGenerator(name = NAME + "_sequence", sequenceName = MAIN_SCHEMA_NAME + "." + NAME + "_ID_sequence", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name = "authority", nullable = false, insertable = false, updatable = false, length = 10, precision = 0)
    private String authority;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accountPrivilege", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Account> accounts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
