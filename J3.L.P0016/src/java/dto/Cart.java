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
public class Cart {
    private Product sanpham;
    private int quantities;

    public Cart() {
    }

    public Cart(Product sanpham, int quantities) {
        this.sanpham = sanpham;
        this.quantities = quantities;
    }

    public Product getSanpham() {
        return sanpham;
    }

    public void setSanpham(Product sanpham) {
        this.sanpham = sanpham;
    }

    public int getQuantities() {
        return quantities;
    }

    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }

    @Override
    public String toString() {
        return "Cart{" + "sanpham=" + sanpham + ", quantities=" + quantities + '}';
    }
    
}
