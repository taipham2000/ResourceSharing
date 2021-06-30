/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ProductDao;
import dao.UserDao;
import dto.Product;
import dto.Role;
import dto.User;
import dto.UserError;
import dto.VerifyUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author phamv
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String ERROR = "Login.jsp";
    private static final String LOAD_PRODUCT = "ProductController";
    private static final String MAIN_CONTROLLER = "MainController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(5000);
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean valid = false;
        try {
            UserDao daoU = new UserDao();
            List<Role> listRole = daoU.getNameRole();
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String gRecaptchaRespone = request.getParameter("g-recaptcha-response");
            System.out.println("ha"+gRecaptchaRespone);
            valid = VerifyUtils.verify(gRecaptchaRespone);
            
            System.out.println(valid);
            
            UserError error = new UserError();
            
            String email = request.getParameter("email");
            System.out.println("email:" + email);
            User user = daoU.check(userName, password);
            System.out.println("user:" + user);
            User emailU = daoU.checkLoginGG(email);
            if (email != null) {
                if (emailU != null) {

                    session.setMaxInactiveInterval(5000);
                    session.setAttribute("user", user);
                    url = MAIN_CONTROLLER;
                } else {
                    String errorGG = "Account not available";
                    request.setAttribute("errorGG", errorGG);
                    url = ERROR;
                }
            } else {
                if (user != null && valid == true) {

                    ProductDao daoP = new ProductDao();
                    List<Product> listProduct = new ArrayList<Product>();
                    listProduct = daoP.getAllProduct();
                    request.setAttribute("ListProduct", listProduct);
                    request.setAttribute("ListRole", listRole);

                    session.setAttribute("user", user);
                    System.out.println("userne:" + user);
                    url = LOAD_PRODUCT;
                } else {
                    request.setAttribute("userName", userName);
                    request.setAttribute("password", password);
                    url = ERROR;
                    request.setAttribute("INVALID", "User Name or Password are not correct");
                }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
