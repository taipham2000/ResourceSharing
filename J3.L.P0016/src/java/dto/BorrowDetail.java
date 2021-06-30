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
public class BorrowDetail {
    private int borrowDetailID, borrowID, quantity;
    private String productID;

    public BorrowDetail() {
    }

    public BorrowDetail(int borrowDetailID, int borrowID, int quantity, String productID) {
        this.borrowDetailID = borrowDetailID;
        this.borrowID = borrowID;
        this.quantity = quantity;
        this.productID = productID;
    }

    public int getBorrowDetailID() {
        return borrowDetailID;
    }

    public void setBorrowDetailID(int borrowDetailID) {
        this.borrowDetailID = borrowDetailID;
    }

    public int getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(int borrowID) {
        this.borrowID = borrowID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "BorrowDetail{" + "borrowDetailID=" + borrowDetailID + ", borrowID=" + borrowID + ", quantity=" + quantity + ", productID=" + productID + '}';
    }
    
}
