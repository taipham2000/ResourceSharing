/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dto.User;
import java.io.IOException;
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
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String LOAD_PRODUCT = "ProductController";
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogoutController";
    private static final String SEARCH_PRODUCT = "SearchController";
    private static final String SIGNUP = "SignUpController";
    private static final String ADD_PRODDUCT = "AddProductController";
    private static final String BOOKING_PRODUCT = "BookingController";
    private static final String VIEW_REQUEST = "ViewRequestController";
    private static final String HISTORY = "HistoryController";
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(5000);
        String action = request.getParameter("action");
        String url = ERROR;
        
        User user = (User) session.getAttribute("user");
        
        try{
            if(action == null){
                session.setMaxInactiveInterval(5000);
                url = LOAD_PRODUCT;
            }
            else if("Login".equals(action)){
                System.out.println("login");
                url = LOGIN;
            }
            else if("search".equals(action)){
                url = SEARCH_PRODUCT;
                System.out.println("search1");
            }
            else if("Logout".equals(action)){
                url = LOGOUT;
            }
            else if("SignUp".equals(action)){
                url = SIGNUP;
            }
            else if("AddProduct".equals(action))
            {
                url = ADD_PRODDUCT;
            }
            else if("Borrow".equals(action)){
                url = BOOKING_PRODUCT;
            }
            else if("ViewRequest".equals(action)){
                url = VIEW_REQUEST;
            }
            else if("History".equals(action)){
                url = HISTORY;
            }
            
        }catch(Exception e){
            
        }finally{
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
