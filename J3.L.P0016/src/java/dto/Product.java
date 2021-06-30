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
public class Product {
    private String productID, productName, description, imageUrl, categoryID;
    private int quantity, levelID;

    public Product() {
    }

    public Product(String productID, String productName, int quantity, String description, int levelID, String imageUrl, String categoryID) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.categoryID = categoryID;
        this.quantity = quantity;
        this.levelID = levelID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLevelID() {
        return levelID;
    }

    public void setLevelID(int levelID) {
        this.levelID = levelID;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", description=" + description + ", imageUrl=" + imageUrl + ", categoryID=" + categoryID + ", quantity=" + quantity + ", levelID=" + levelID + '}';
    }
    
}
