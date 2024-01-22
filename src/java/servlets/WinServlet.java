/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.GameUtil;

/**
 *
 * @author User
 */
@WebServlet(name = "WinServlet", urlPatterns = {"/win"})
public class WinServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            String PageContext = "<html>\n"
//                    + "    <head>\n"
//                    + "        <title>TODO supply a title</title>\n"
//                    + "        <meta charset=\"UTF-8\">\n"
//                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
//                    + "    </head>\n"
//                    + "    <body>\n"
//                    + "        <h2>Dear player -</h2>\n"
////                    + "        <h1>Wow you won into" + GameUtil.numOfTryings + "  turns!!!!!!!!!</h1>\n"
//                    + "    </body>\n"
//                    + "</html>\n"
//                    + "";
//            out.print(PageContext);
//
//        }
//    }

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String PageContext = "<html>\n"
                    + "    <head>\n"
                    + "        <title>TODO supply a title</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <h2>Dear player -</h2>\n"
                    + "        <h1>Wow you won into" + GameUtil.getCookieValueByName(request, "numOfTryings") + "  turns!!!!!!!!!</h1>\n"
                    + "    </body>\n"
                    + "</html>\n"
                    + "";
            out.print(PageContext);

        }
//        processRequest(request, response);
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
//        processRequest(request, response);
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
