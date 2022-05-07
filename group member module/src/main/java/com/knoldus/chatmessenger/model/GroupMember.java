package com.knoldus.chatmessenger.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class GroupMember {
    @Id @GeneratedValue @Column ( name = "ID")
    private int id;
    @NotNull
    @Column (name = "GroupID")
    private int groupId;
    @NotNull
    @Column (name = "UserID", unique = true)
    private int userId;
    @NotNull
    @Column (name = "JoinedOn")
    private Date joinedOn;
    @NotNull
    @Column (name = "Active")
    private boolean active;
    @NotNull
    @Column (name = "CreatedDate")
    private Date createdDate;
    @NotNull
    @Column (name = "UpdatedDate")
    private Date updatedDate;

    public int getId() {
        return id;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getUserId() {
        return userId;
    }

    public Date getJoinedOn() {
        return joinedOn;
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

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setJoinedOn(Date joinedOn) {
        this.joinedOn = joinedOn;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
