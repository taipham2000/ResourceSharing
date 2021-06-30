/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author phamv
 */
public class History {
    private String userName;
    private int borrowDetailID;
    private String productName;
    private int quantity;
    private String date;
    private String imageUrl;
    private boolean statusBooking;

    public History() {
    }
     public History(String productName, int quantity, String date, String imageUrl) {
        this.productName = productName;
        this.quantity = quantity;
        this.date = date;
        this.imageUrl = imageUrl;
    }
    public History(String userName, int BorrowDetailID, String productName, int quantity, String date, String imageUrl) {
        this.userName = userName;
        this.borrowDetailID = BorrowDetailID;
        this.productName = productName;
        this.quantity = quantity;
        this.date = date;
        this.imageUrl = imageUrl;
    }

    public int getBorrowDetailID() {
        return borrowDetailID;
    }

    public void setBorrowDetailID(int BorrowDetailID) {
        this.borrowDetailID = BorrowDetailID;
    }

    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public History(String productName, int quantity, String date, String imageUrl, boolean statusBooking) {
        this.productName = productName;
        this.quantity = quantity;
        this.date = date;
        this.imageUrl = imageUrl;
        this.statusBooking = statusBooking;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

   

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isStatusBooking() {
        return statusBooking;
    }

    public void setStatusBooking(boolean statusBooking) {
        this.statusBooking = statusBooking;
    }

    @Override
    public String toString() {
        return "History{" + "userName=" + userName + ", BorrowDetailID=" + borrowDetailID + ", productName=" + productName + ", quantity=" + quantity + ", date=" + date + ", imageUrl=" + imageUrl + ", statusBooking=" + statusBooking + '}';
    }

    
    

    
    
}
