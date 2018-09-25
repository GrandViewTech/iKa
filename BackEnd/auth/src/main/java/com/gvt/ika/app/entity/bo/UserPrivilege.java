package com.gvt.ika.app.entity.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "USER_PRIVILEGE")
public class UserPrivilege extends Base{

    @Column(name="USER_ID")
    private Long userId;


}
