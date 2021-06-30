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
public class Borrow {
    private int borrowID, userID;
    private String date;

    public Borrow() {
    }

    public Borrow(int borrowID, int userID, String date) {
        this.borrowID = borrowID;
        this.userID = userID;
        this.date = date;
    }

    public int getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(int borrowID) {
        this.borrowID = borrowID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Borrow{" + "borrowID=" + borrowID + ", userID=" + userID + ", date=" + date + '}';
    }
    
}
