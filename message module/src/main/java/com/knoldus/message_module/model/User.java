package com.knoldus.message_module.model;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * User data model.
 */
@Component
public class User {
    private int id;
    private String name;
    private long mobile;
    private String password;
    private boolean active;
    private Date createdDate;
    private Date updatedDate;
    public long getId() {
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
