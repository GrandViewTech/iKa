package com.gvt.ika.app.entity.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AUTH_TOKEN" ,
        uniqueConstraints ={ @UniqueConstraint(name = "UK_AUTH_KEY" , columnNames = {"COMPANY_ID","APPLICATION_ID","USER_ID","TOKEN"})} )
public class AuthToken extends Base
{
    @Column(name="TOKEN")
    private String token;

    @Column(name="USER_ID")
    private Long userId ;

    @Column(name="APPLICATION_ID")
    private Long applicationId;

    @Column(name="COMPANY_ID")
    private Long companyId;

    // IN MINUTE
    @Column(name="EXPIRE_ON")
    private Long expireOn ;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EXPIRY")
    private Date expiry ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="TOKEN_LAST_ACCESSED_ON")
    private Date lastAccessedOn ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="GENERATED_ON")
    private Date generatedOn ;




    @JsonIgnore
    @Transient
    private AuthTokenStatus authTokenStatus;

    public AuthTokenStatus getAuthTokenStatus() {
        return authTokenStatus;
    }

    public void setAuthTokenStatus(AuthTokenStatus authTokenStatus) {
        this.authTokenStatus = authTokenStatus;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }


    public Long getExpireOn() {
        return expireOn;
    }

    public void setExpireOn(Long expireOn) {
        this.expireOn = expireOn;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public Date getLastAccessedOn() {
        return lastAccessedOn;
    }

    public void setLastAccessedOn(Date lastAccessedOn) {
        this.lastAccessedOn = lastAccessedOn;
    }

    public Date getGeneratedOn() {
        return generatedOn;
    }

    public void setGeneratedOn(Date generatedOn) {
        this.generatedOn = generatedOn;
    }



    @JsonIgnore
    public AuthToken update(Integer expireOn)
    {

        Date date = new Date();
        this.setLastAccessedOn(date);
        DateTime dateTime = DateTime.now().plusMinutes(expireOn);
        dateTime.plusMinutes(expireOn);
        this.setExpiry(dateTime.toDate());

        return this;
    }

    @JsonIgnore
    public void generate(Integer expireOn)
    {
        Date date = new Date();
        this.setLastAccessedOn(date);
        this.setGeneratedOn(date);
        //
        DateTime dateTime = DateTime.now().plusMinutes(expireOn);
        this.setExpireOn(dateTime.getMillis());
        this.setExpiry(dateTime.toDate());
    }

    public AuthToken(  Long companyId,Long applicationId, Long userId,String token)
    {
        super();
        this.token = token;
        this.userId = userId;
        this.applicationId = applicationId;
        this.companyId = companyId;
    }

    public AuthToken()
    {
        super();
    }


    public enum AuthTokenStatus
    {
        VALID , INVALID , EXIPRED;
    }
}
