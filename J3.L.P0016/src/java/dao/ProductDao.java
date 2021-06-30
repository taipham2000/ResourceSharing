/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Category;
import dto.Product;
import dto.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import utils.DBUItis;

/**
 *
 * @author phamv
 */
public class ProductDao {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<Product> listProduct = new ArrayList<Product>();
    List<Category> listCategory = new ArrayList<Category>();

    public void Closefinally() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public ProductDao() {
        try {
            this.listProduct = getAllProduct();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Category> getAllCategory() throws SQLException {
        try {
            con = DBUItis.openConnection();
            String sql = "Select * from Category";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listCategory.add(new Category(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
        } finally {
            Closefinally();
        }
        return listCategory;
    }

    public int getTotalProduct() {
        String sql = "Select count(*) from Products";
        try {
            con = DBUItis.openConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public static void main(String[] args) throws SQLException {
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDateTime now = LocalDateTime.now();
                String date = dtf.format(now);
                System.out.println("Date:"+now);
    }

    public List<Product> pagingAccount(int index) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Products \n"
                + " where status = 1 And quantity > 0\n"
                + "Order By productID \n"
                + "OFFSET ? Rows FeTCH NEXT 5 ROWS ONLY ";
        try {
            con = DBUItis.openConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();

            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                int quantity = rs.getInt("quantity");
                String description = rs.getString("description");
                int levelID = rs.getInt("levelID");
                String imageUrl = rs.getString("imageUrl");
                boolean status = rs.getBoolean("status");
                String categoryID = rs.getString("categoryID");
                list.add(new Product(productID, productName, quantity, description, levelID, imageUrl, categoryID));

            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<Product> getQuantityProduct() {
        listProduct.clear();
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "Select productID, quantity From Products ";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    int quantity = rs.getInt("quantity");
                   
                }
            }
        } catch (Exception e) {

        }
        return listProduct;
    }

    public List<Product> getAllProduct() throws SQLException {
        listProduct.clear();
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "Select * From Products Where status = 1 and quantity > 0";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    int levelID = rs.getInt("levelID");
                    String imageUrl = rs.getString("imageUrl");
                    boolean status = rs.getBoolean("status");
                    String categoryID = rs.getString("categoryID");
                    listProduct.add(new Product(productID, productName, quantity, description, levelID, imageUrl, categoryID));
                }
            }
        } catch (Exception e) {

        } finally {
            Closefinally();
        }
        return listProduct;
    }

    public boolean createProduct(String productID, String productName, int quantity, String description, int levelID, String imageurl, String categoryID) throws SQLException {
        try {
            boolean status = true;
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "Insert Products values(?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, productID);
                ps.setString(2, productName);
                ps.setInt(3, quantity);
                ps.setString(4, description);
                ps.setInt(5, levelID);
                ps.setString(6, imageurl);
                ps.setBoolean(7, status);
                ps.setString(8, categoryID);
                ps.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            Closefinally();
        }
        return true;
    }

    public Product find(String id) {
        for (Product product : this.listProduct) {
            if (product.getProductID().equalsIgnoreCase(id)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProductNameSearch(String search) throws SQLException {
        List<Product> list = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "Select * \n"
                        + "from Products\n"
                        + "Where productName like ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + search + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String ProductId = rs.getString("productID");
                    String Productname = rs.getString("productName");
                    int Quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    int levelID = rs.getInt("levelID");
                    String imageUrl = rs.getString("imageUrl");
                    boolean status = rs.getBoolean("status");
                    String categoryId = rs.getString("categoryID");//"******";
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(new Product(ProductId, Productname, Quantity, description, levelID, imageUrl, categoryId));
                }

            }
        } catch (Exception e) {

        } finally {
            Closefinally();
        }
        return list;
    }
    List<Role> listRole = new ArrayList<Role>();

    public List<Role> getNameUser() throws SQLException {
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "Select roleName from Roles where roleID > 1";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {

                    listRole.add(new Role(rs.getInt(1), rs.getString(2)));
                }
            }
        } catch (Exception e) {

        } finally {
            Closefinally();
        }
        return listRole;
    }

}
