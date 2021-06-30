/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Role;
import dto.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUItis;

/**
 *
 * @author phamv
 */
public class UserDao {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<Role> listRole = new ArrayList<Role>();
    List<User> listUser = new ArrayList<User>();
    

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

    public List<Role> getNameRole() throws SQLException {
        listRole.clear();
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "Select * from Roles where roleID > 1 ";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int roleID = rs.getInt("roleID");
                    String roleName = rs.getString("roleName");
                    listRole.add(new Role(roleID, roleName));
                }
            }
        } catch (Exception e) {

        } finally {
            Closefinally();
        }
        return listRole;
    }

    public User checkLoginGG(String userID) throws SQLException {
        Connection conn = null;
        User result = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT userName, roleID FROM Users WHERE status='True' AND userID=?";
        try {
            conn = DBUItis.openConnection();
            if (conn != null) {
                ps = conn.prepareStatement(sql);
                ps.setString(1, userID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String userName = rs.getString("userName");
                    int roleID = rs.getInt("roleID");
                    result = new User(userID, userName, roleID);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public List<User> getAllUser() throws SQLException {
        listUser.clear();
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "Select * from Users where roleID > 1 ";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String userName = rs.getString("userName");
                    String password = rs.getString("password");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    int roleID = rs.getInt("roleID");
                    boolean status = rs.getBoolean("status");
                    listUser.add(new User(userID, userName, password, address, phone, roleID, status));
                }
            }
        } catch (Exception e) {

        } finally {
            Closefinally();
        }
        return listUser;
    }

    public Role getRoleIDByRoleName(String Name) throws SQLException {
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "Select * from Roles where roleName = ? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, Name);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int roleID = rs.getInt("roleID");
                    String roleName = rs.getString("roleName");
                    Role role = new Role(roleID, roleName);
                    return role;
                }
            }
        } catch (Exception e) {

        } finally {
            Closefinally();
        }
        return null;
    }
java.util.Date today = new java.util.Date();
    Date createDate = new Date(today.getTime());
    public boolean createAccount(User ac) throws SQLException {
        try {

            boolean status = true;
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "Insert Users values(?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, ac.getUserID());
                ps.setString(2, ac.getUserName());
                ps.setString(3, ac.getPassword());
                ps.setString(4, ac.getAddress());
                ps.setString(5, ac.getPhone());
                ps.setDate(6, createDate);
                ps.setInt(7, ac.getRoleID());
                ps.setBoolean(8, status);
                ps.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            Closefinally();
        }
        return true;
    }

    public static void main(String[] args) throws SQLException {
        java.util.Date today = new java.util.Date();
        Date createDate = new Date(today.getTime());
        UserDao dao = new UserDao();
        User user = new User("Tram@gmail.com", "Tram","12345678", "Linh Trung", "0898124578",createDate , 2, true);
        System.out.println(dao.createAccount(user));
        System.out.println("Day:"+createDate);
    }

    public User check(String user, String password) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "Select * from Users where userName=? and password=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, user);
                ps.setString(2, password);
                rs = ps.executeQuery();
                while (rs.next()) {
                    return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getBoolean(8));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Closefinally();
        }
        return null;
    }

}
