package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.onlinemediclestore.Classes.User;
import org.example.onlinemediclestore.Classes.VerifiedReview;
import org.example.onlinemediclestore.utils.ReviewManager;

import java.io.IOException;

@WebServlet("/admin/reviewAction")
public class AdminReviewAction extends HttpServlet {

private ReviewManager reviewManager;


public void init( ) throws ServletException{
    super.init();
    reviewManager= ReviewManager.getInstance();

}

protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    HttpSession session = request.getSession();
    User admin = (User) session.getAttribute("user");

    String reviewId = request.getParameter("reviewId");
    String action = request.getParameter("action"); // "approve" or "reject"

    if ("approve".equals(action)) {
        // Verify the review
        VerifiedReview verifiedReview = reviewManager.verifyReview(reviewId, admin.getUserID());
        if (verifiedReview != null) {
            session.setAttribute("adminMessage", "Review approved successfully");
        } else {
            session.setAttribute("adminError", "Review not found");
        }
    } else if ("reject".equals(action)) {
        // Reject the review
        boolean rejected = reviewManager.rejectReview(reviewId);
        if (rejected) {
            session.setAttribute("adminMessage", "Review rejected and removed");
        } else {
            session.setAttribute("adminError", "Review not found");
        }


    }

    // Redirect back to admin panel
    response.sendRedirect(request.getContextPath() + "pendingReviews.jsp");
}

}
