package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="vl_admin")
public class Admin {
    
    @Id
    @SequenceGenerator(name="admin_sequence",initialValue=10100,allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="admin_sequence")
    int adminId;
    String userName;
    String userPassword;
    
    public int getUserId() {
        return adminId;
    }
    public void setUserId(int userId) {
        this.adminId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    
}