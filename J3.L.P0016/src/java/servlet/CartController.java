/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ProductDao;
import dto.Cart;
import dto.User;
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
@WebServlet(name = "CartController", urlPatterns = {"/CartController"})
public class CartController extends HttpServlet {

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
        HttpSession httpSession = request.getSession();
        httpSession.setMaxInactiveInterval(5000);
        ProductDao dao= new ProductDao();
        
        String action = request.getParameter("action");
        try{
            if (action == null) {
           
            displayCart(request, response);
            
        } else {
            if (action.equals("buy")) {
                System.out.println("mua hang");
                User user = (User) httpSession.getAttribute("user");
                if (user == null) {
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
               
                buyItem(request, response);
                
            } else if (action.equals("remove")) {
                removeItem(request, response);
            }
        }
        }catch(Exception e){
            
        }
    }
     protected void displayCart(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
        request.getRequestDispatcher("ShowCart.jsp").forward(request, respone);
    }

    protected void removeItem(HttpServletRequest request, HttpServletResponse respone) throws IOException {
        HttpSession session = request.getSession();

        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        int index = isExisting(request.getParameter("productID"), cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        respone.sendRedirect("CartController");
    }

    protected int isExisting(String productID, List<Cart> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getSanpham().getProductID().equalsIgnoreCase(productID)) {
                return i;
            }
        }
        return -1;
    }

    protected void buyItem(HttpServletRequest request, HttpServletResponse respone) throws IOException {
        ProductDao proDao = new ProductDao();
        HttpSession session = request.getSession();
        String productID=request.getParameter("productID");
        String productName=request.getParameter("productName");
        if (session.getAttribute("cart") == null) {
            List<Cart> cart = new ArrayList<Cart>();
            cart.add(new Cart(proDao.find(request.getParameter("productID")), 1));
            session.setAttribute("cart", cart);
        } else {
            List<Cart> cart = (List<Cart>) session.getAttribute("cart");
            int index = isExisting(request.getParameter("productID"), cart);

            if (index == -1) {
                cart.add(new Cart(proDao.find(request.getParameter("productID")), 1));

            } else {
                int quantity = cart.get(index).getQuantities() + 1;
                cart.get(index).setQuantities(quantity);
            }
            session.setAttribute("cart", cart);
        }
        respone.sendRedirect("CartController");
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
