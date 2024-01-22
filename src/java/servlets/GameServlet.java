/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.GameUtil;

/**
 *
 * @author User
 */
@WebServlet(name = "GameServlet", urlPatterns = {"/game"})
public class GameServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param response servlet response
     * @param sentenceToShow
     * @param numOfTryings
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void showPage(HttpServletResponse response, String sentenceToShow, String numOfTryings)
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
                    + "        <h1>Try to guess the letters</h1>\n"
                    + "        <h1>Sentence:"
                    + sentenceToShow
                    + "</h1>"
                    + "<h2>You have "
                    + numOfTryings
                    + "        attempts left </h2>\n"
                    + "        <div>choose another letter:</div>\n"
                    + "        <form >\n"
                    + "        <input type=\"text\" name=\"letter\" placeholder=\"Enter a letter\">\n"
                    + "        <input type=\"submit\" value=\"Guess\">\n"
                    + "        </form>\n"
                    + "    </body>\n"
                    + "</html>"
                    + "";
            out.print(PageContext);
        }
    }

    private void doFirstTimeCall(HttpServletResponse response) {
        String sentence = GameUtil.chooseSentence();
        String sentenceToShow = GameUtil.initSentenceToShow(sentence);
        response.addCookie(new Cookie("sentence",sentence));
        response.addCookie(new Cookie("sentenceToShow",sentenceToShow ));
        response.addCookie(new Cookie("numOfTryings", GameUtil.increaseNumOfTryings("0")));

    }

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
        String sentence = GameUtil.getCookieValueByName(request, "sentence");
        String sentenceToShow = GameUtil.getCookieValueByName(request, "sentenceToShow");
        String numOfTryings = GameUtil.getCookieValueByName(request, "numOfTryings");
        if (sentence == null && sentenceToShow == null && numOfTryings == null) {
            doFirstTimeCall(response);
            showPage(response, sentenceToShow,"0");

        } else {
            String letter = request.getParameter("letter");
            if (letter != null) {
                sentenceToShow=GameUtil.updateSentenceToShow(letter.charAt(0), sentenceToShow, sentence);
                numOfTryings=GameUtil.increaseNumOfTryings(numOfTryings);
                if (GameUtil.checkWinning(sentenceToShow)) {
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/win");
                    if (dispatcher != null) {
                        dispatcher.include(request, response);
                    }
                } else {
                    response.addCookie(new Cookie("sentenceToShow",sentenceToShow));
                    response.addCookie(new Cookie("numOfTryings",numOfTryings));
                    showPage(response, sentenceToShow, numOfTryings);
                }
            } else {
                showPage(response, sentenceToShow, numOfTryings);
            }
            showPage(response, sentenceToShow, numOfTryings);
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
