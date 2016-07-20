/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.factorizor.factorizor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apprentice
 */
@WebServlet(name = "Factorizor", urlPatterns = {"/Factorizor", "/Results"})
public class Factorizor extends HttpServlet {

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
        RequestDispatcher forwarder = request.getRequestDispatcher("index.html");
        forwarder.forward(request, response);
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

        // Store the number entered by the user.
        int number = Integer.parseInt(request.getParameter("numToFactor"));

        // list for the factors
        List<String> factors = new ArrayList();
        
        // loop over the factors and add their value as a string.
        for (Integer factor : getFactors(number)) { 
            factors.add(String.valueOf(factor)); 
        }

        // set the factors collection for the view.
        request.setAttribute("factors", factors);

        // set a flag to let us know if there are any factors of the number.
        // account for 1 and itself.
        request.setAttribute("hasFactors", factors.size() > 2);
        
        // set the isPerfect value for the view.
        request.setAttribute("isPerfect", isPerfect(number));

        // set the isPrime value for the view.
        request.setAttribute("isPrime", isPrime(number));

        // set the number value for the view.
        request.setAttribute("number", number);

        // let the response handle things from here.
        RequestDispatcher forwarder = request.getRequestDispatcher("response.jsp");
        forwarder.forward(request, response);

    }

    // Function to determine if number is prime.
    public static boolean isPrime(int number) {

        // Get the factors of the passed number.
        List<Integer> factors = getFactors(number);

        // Because a prime number will always have the factorial length of 2.
        // Attempt to invalidate based off factorial length.
        if (factors.size() != 2) {
            return false;
        }

        // Determine if the list contains 1 ( a requirement for a true result ).
        boolean containsOne = factors.contains(1);

        // Determine if the list contains the passed number ( a requirement for a true result ).
        boolean containsSelf = factors.contains(number);

        // If the 2 factors were 1 and the passed number, it is a prime... else not prime.
        return containsOne && containsSelf;
    }

    // Function accepts a number, and determines if it is a perfect 
    // number ( all factorials sum to the same value as the number ),
    // a boolean represintation is returned.
    public static boolean isPerfect(int number) {
        // Get the factors of the passed number.
        List<Integer> factors = getFactors(number);

        // initialize the sum.
        int sum = 0;

        // Add each factor to the sum.
        for (int factor : factors) {
            // Add the value of the factor to the sum.
            sum += factor;
        }

        // check if all the factors added up to the number ( making it perfect )... returning the comparison result.
        return sum == number;
    }

    // Function accepts a number as a parameter
    // From the passed number, the factorials are collected
    // The collected factorials are returned.
    public static List<Integer> getFactors(int number) {
        List<Integer> factorList = new ArrayList();

        // Added one because a whole number is always divisible by one.
        factorList.add(1);

        // For values 2 through half the passed number.
        for (int i = 2; i <= number / 2; i++) {

            // If there is no remainder..
            if (number % i == 0) {

                // Add the factor.
                factorList.add(i);
            }
        }

        // Whole numbers are always divisble by themselves. Added last because it is always the largest factorial.
        factorList.add(number);

        // Return the results.
        return factorList;
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
