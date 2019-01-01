package com.gvt.ika.app.entity.bo;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Table(name="CREDENTIAL")
@Entity
public class Credential extends Base
{

    @Column(name="USER_ID",unique = true)
    private Long userId;

    @Column(name="USERNAME",unique = true)
    private String username;


    @Column(name="PASSWORD")
    private String password;

    @Column(name="CREATED_ON")
    private Date createdOn ;

    @Column(name="LAST_MODIFIED_ON")
    private Date lastModifiedOn ;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @PrePersist
    public void prepersist()
    {
        Date date= new Date();
        setCreatedOn(date);
        setLastModifiedOn(date);
    }

    @PreUpdate
    public void preupdate()
    {
        Date date= new Date();
        setLastModifiedOn(date);
    }
}
