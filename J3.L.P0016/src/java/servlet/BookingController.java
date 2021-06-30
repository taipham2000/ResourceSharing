
package servlet;

import dao.BorrowDao;
import dao.BorrowDetailDao;
import dto.Cart;
import dto.User;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "BookingController", urlPatterns = {"/BookingController"})
public class BookingController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        BorrowDao daoB = new BorrowDao();
        BorrowDetailDao daoDB = new BorrowDetailDao();
        String year =request.getParameter("year");   
        String month =request.getParameter("month");
        String day =request.getParameter("day");
        String sDate = year + "-" + month + "-" + day;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            Date date = formatter.parse(sDate);
            System.out.println("Date:"+formatter.format(date));
            System.out.println("Year: " + year);
            System.out.println("Month: " + month);
            System.out.println("Day: " + day);
            int lastBorrowId = daoB.getLastBorrow();
            int BorrowID = lastBorrowId + 1;
            int borrowDetailID = daoDB.getLastBorrowDetail();
            int BorrowDetailID = borrowDetailID + 1;
            List<Cart> listCart = (List<Cart>) session.getAttribute("cart");
            if (user != null) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDateTime now = LocalDateTime.now();
                String dateNow = dtf.format(now);
                int insert = daoB.insertBorrow(BorrowID, user.getUserID(), formatter.format(date));
                if (insert > 0) {
                    boolean statusBooking = false;
                    int insertOrderDetail;
                    for (Cart cart : listCart) {
                        insertOrderDetail = 0;
                        System.out.println("Cart:" + cart);
                        if (cart.getSanpham().getQuantity() < cart.getQuantities()) {
                            request.setAttribute("SUCCESS", " Product is not enought");
                            request.getRequestDispatcher("ShowCart.jsp").forward(request, response);
                        }
                        else if(dateNow.compareTo(formatter.format(date)) > 0){
                            request.setAttribute("SUCCESS", " Invalid date !!!");
                            request.getRequestDispatcher("ShowCart.jsp").forward(request, response);
                            
                        }else {

                            insertOrderDetail = daoDB.insertDetail(BorrowDetailID, BorrowID, statusBooking, cart.getSanpham().getProductID(), cart.getQuantities());

                            if (insertOrderDetail > 0) {
                                System.out.println("liscart 1:" + listCart);
                                daoDB.setQuantityProduct(cart.getSanpham().getProductID(), cart.getQuantities());
                                BorrowDetailID++;
                                System.out.println("Cart:" + cart);

                            }
                            request.setAttribute("SUCCESS", " Request sent to admin!");
                            request.getRequestDispatcher("CheckOutSuccess.jsp").forward(request, response);
                            request.removeAttribute("cart");
                            listCart.clear();
                        }

                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
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
        } catch (ParseException ex) {
            Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
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
