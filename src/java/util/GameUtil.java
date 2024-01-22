/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author User
 */
public class GameUtil {

    static List<String> sentences;
//    static String sentence="";
//    public static StringBuilder sentenceToShow=new StringBuilder("");
//    public static int numOfTryings;

    static {
        sentences = new ArrayList<>();
        sentences.add("hello everyone");
        sentences.add("ruthy klein");
        sentences.add("I want to win");
        sentences.add("game over");

        //chooseSentence();
        //initSentenceToShow();

    }

    public static String chooseSentence() {
        Random rand = new Random();
        int index = rand.nextInt(sentences.size());
        return sentences.get(index);
    }

    public static String initSentenceToShow(String sentence) {
        StringBuilder sentenceToShow = new StringBuilder("");
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                sentenceToShow.append(' ');
            } else {
                sentenceToShow.append('-');
            }
        }
        return sentenceToShow.toString();
    }

    public static String updateSentenceToShow(char letter, String sentenceToShow, String sentence) {
        StringBuilder sb = new StringBuilder(sentenceToShow);
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == letter) {
                sb.setCharAt(i, letter);
            }
        }
        return sb.toString();

    }

    public static String increaseNumOfTryings(String numOfTryings) {
        int num = Integer.parseInt(numOfTryings);
        num++;
        return Integer.toString(num);
    }

    public static boolean checkWinning(String sentenceToShow) {
        return !sentenceToShow.contains("-");
    }

    public static String getCookieValueByName(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

  
}
