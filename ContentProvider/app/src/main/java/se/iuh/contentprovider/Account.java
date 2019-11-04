package se.iuh.contentprovider;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {
    private String accountid, credential, role;

    public Account(String accountid, String credential, String role) {
        this.accountid = accountid;
        this.credential = credential;
        this.role = role;
    }

    public Account() {
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountid.equals(account.accountid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountid);
    }

    @Override
    public String toString() {
        return this.accountid + "-" + this.credential + "-" + this.role;
    }
}
