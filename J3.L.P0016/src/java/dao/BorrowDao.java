/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUItis;

/**
 *
 * @author phamv
 */
public class BorrowDao {
    
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
   
    
      public int getLastBorrow() throws SQLException, ClassNotFoundException {
        int result = 0;
        try {        
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "SELECT MAX(BorrowID) as BorrowID\n"
                        + "FROM Borrow";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                
                if(rs.next()){
                    result = rs.getInt("BorrowID");
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
      public int insertBorrow(int borrowID, String userID, String date) throws SQLException, ClassNotFoundException {
        try {
            //get Current Date
          //  java.util.Date date = new java.util.Date();
          //  java.sql.Date beginDate = new java.sql.Date(date.getTime());

            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "insert into Borrow\n"
                        + "values (?,?,?)";
                ps = con.prepareStatement(sql);
                
                ps.setString(2, userID);
                ps.setInt(1, borrowID);
                ps.setString(3, date);
                int r = ps.executeUpdate();
                if (r > 0) {
                    return r;
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
      
}
