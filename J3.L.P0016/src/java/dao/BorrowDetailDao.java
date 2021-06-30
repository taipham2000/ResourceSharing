/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.History;
import dto.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import static org.apache.coyote.ContainerThreadMarker.clear;
import utils.DBUItis;

/**
 *
 * @author phamv
 */
public class BorrowDetailDao {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

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

    public int insertDetail(int BorrowDetailID, int BorrowID, boolean status, String productID, int detailQuantity) throws SQLException, ClassNotFoundException {

        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "insert BorrowDetail (BorrowDetailID,BorrowID,statusBooking,productID,quantity)\n"
                        + "values (?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, BorrowDetailID);
                ps.setInt(2, BorrowID);
                ps.setBoolean(3, status);
                ps.setString(4, productID);
                ps.setInt(5, detailQuantity);

                int rs = ps.executeUpdate();
                if (rs > 0) {
                    return rs;
                }
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return 0;
    }

    public int getLastBorrowDetail() throws SQLException, ClassNotFoundException {
        int result = 0;
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "SELECT MAX(BorrowDetailID) as BorrowDetailID\n"
                        + "FROM BorrowDetail";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                if (rs.next()) {
                    result = rs.getInt("BorrowDetailID");
                }

            }
        } finally {
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
        return result;

    }

    public int setQuantityProduct(String productID, int quantity) throws SQLException, ClassNotFoundException {
        try {
            con = DBUItis.openConnection();

            if (con != null) {
                String sql = "update Products\n"
                        + "set quantity = quantity - ?\n"
                        + "where productID = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, quantity);
                ps.setString(2, productID);
                int result = ps.executeUpdate();
                if (result > 0) {
                    return result;
                }
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return 0;
    }

   

    public List<History> loadRequestFromUserToAdmin() throws SQLException, ClassNotFoundException {
        List<History> list = new ArrayList<>();
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "select u.userName, o.date, d.quantity, b.imageUrl , b.productName, d.BorrowDetailID\n"
                        + "from Borrow o inner join BorrowDetail d on o.BorrowID = d.BorrowID, Products b, Users u\n"
                        + "where b.productID = d.productID And u.userID = o.userID And d.statusBooking = 0";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String userName = rs.getString("userName");
                    int BorrowDeatailID = rs.getInt("BorrowDetailID");
                    String date = rs.getString("date");
                    String bookName = rs.getString("productName");
                    int quantity = rs.getInt("quantity");
                    String images = rs.getString("imageUrl");
                    list.add(new History(userName, BorrowDeatailID, bookName, quantity, date, images));
                }

            }
        } finally {
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
        return list;
    }
 public static void main(String[] args) throws SQLException, ClassNotFoundException, NamingException {
        BorrowDetailDao dao = new BorrowDetailDao();
        System.out.println(dao.loadRequestFromUserToAdmin());
    }
    public boolean updateStatusAfterCheckout(int detaiID) throws SQLException, NamingException {
        
        ArrayList<Product> list = new ArrayList<>();
        

        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "UPDATE BorrowDetail SET statusBooking = 1 "
                        + "WHERE BorrowDetailID = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, detaiID);
                ps.execute();
            }
        } finally {

            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return true;
    }
}
