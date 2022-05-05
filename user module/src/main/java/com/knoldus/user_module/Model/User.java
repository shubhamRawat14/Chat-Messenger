package com.knoldus.user_module.Model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.Date;

/**
 * User data model.
 */
@Entity
@Table(name = "User")
public class User {
    @Id @GeneratedValue
    @Column(name = "Id")
    private int id;
    @NotNull
    @Column(name = "Name")
    private String name;
    @NotNull
    @Column(name = "Mobile", unique = true)
    private long mobile;
    @NotNull
    @Column(name = "Password")
    private String password;
    @NotNull
    @Column(name = "Active")
    private boolean active;
    @NotNull
    @Column(name = "createdDate")
    private Date createdDate;
    @NotNull
    @Column(name = "updatedDate")
    private Date updatedDate;
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setMobile(final long mobile) {
        this.mobile = mobile;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setActive(final boolean active) {
        this.active = active;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(final Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
