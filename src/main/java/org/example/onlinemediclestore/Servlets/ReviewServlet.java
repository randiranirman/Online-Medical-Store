package org.example.onlinemediclestore.Servlets;

import com.sun.net.httpserver.HttpsServer;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.onlinemediclestore.Classes.Review;
import org.example.onlinemediclestore.Classes.User;
import org.example.onlinemediclestore.utils.ReviewManager;

import java.io.IOException;


@WebServlet("/submitReviews")
public class ReviewServlet extends HttpServlet {

    private ReviewManager reviewManager;

    public void init( ) throws ServletException{
        super.init();
        reviewManager= ReviewManager.getInstance();

    }

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{


        HttpSession session= request.getSession();
        User currentUser=  ( User) session.getAttribute("user");
        // check if the user is null

            if(currentUser == null){
                response.sendRedirect("login.jsp");
                return;
            }

            // get form parameters
        String productId = request.getParameter("productId");
        String content = request.getParameter("content");
        int rating = 5; // Default value

        try {
            rating = Integer.parseInt(request.getParameter("rating"));
            // Validate rating range
            if (rating < 1 || rating > 5) {
                rating = 5;
            }
        } catch (NumberFormatException e) {
            // Use default if parsing fails
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        // add the review
        Review review = reviewManager.addReview(currentUser.getUserID(), productId, content, rating);


        // Redirect back to product page with success message

        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        System.out.println("review added succssfully");

    }


}
