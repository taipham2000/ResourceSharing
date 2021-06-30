/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author phamv
 */
public class User {
    private String userID;
    private String userName, password, address, phone;
    private Date date;
    private int roleID;
    private boolean status;

    public User() {
    }

    public User(String userID, String userName, int roleID) {
        this.userID = userID;
        this.userName = userName;
        this.roleID = roleID;
    }

    public User(String userID, String userName, String password, String address, String phone, int roleID, boolean status) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.roleID = roleID;
        this.status = status;
    }

    public User(String userID, String userName, String password, String address, String phone, Date date, int roleID, boolean status) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.roleID = roleID;
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", userName=" + userName + ", password=" + password + ", address=" + address + ", phone=" + phone + ", roleID=" + roleID + ", status=" + status + '}';
    }
    
    
}
