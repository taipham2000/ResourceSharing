/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.UserDao;
import dto.Role;
import dto.User;
import dto.UserError;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phamv
 */
@WebServlet(name = "SignUpController", urlPatterns = {"/SignUpController"})
public class SignUpController extends HttpServlet {

    public static final String ERROR = "SignUp.jsp";
    public static final String LOGIN = "Login.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserDao daoU = new UserDao();
        List<User> listUser = new ArrayList<User>();
        listUser = daoU.getAllUser();
        try {
            java.util.Date today = new java.util.Date();
            Date createDate = new Date(today.getTime());
            List<Role> listRole = new ArrayList<Role>();
            listRole = daoU.getNameRole();
            request.setAttribute("ListRole", listRole);

            String userID = request.getParameter("userID");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password").trim();
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            int roleID = Integer.parseInt(request.getParameter("roleID"));
            boolean status = true;
            UserError userE = new UserError();
            User ac = new User(userID, userName, password, address, phone,createDate, roleID, status);
            boolean valid = true;
            for (User u : listUser) {
                if (userName.equals(u.getUserName())) {
                    userE.setUserNameError("User Name is Exist!!");
                    valid = false;
                }
            }

            if (password.length() < 7 || password.length() > 17) {
                userE.setPasswordError("Password is less than 8 digit");
                valid = false;
            }
            if (phone.trim().matches("^[0-9]{9}$")) {
                userE.setPhoneError("Phone is 10 number");
                valid = false;
            }
            if (valid == true) {
                if (daoU.createAccount(ac)) {

                    url = LOGIN;
                }
            } else {
                request.setAttribute("userID", userID);
                request.setAttribute("userName", userName);
                request.setAttribute("phone", phone);
                request.setAttribute("address", address);
                request.setAttribute("userID", userID);
                request.setAttribute("INVALID", userE);
                url = ERROR;
            }

        } catch (Exception e) {

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
