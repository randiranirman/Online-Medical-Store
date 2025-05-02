package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.management.jfr.RecordingInfo;
import org.example.onlinemediclestore.Classes.Review;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.utils.GenericCRUD;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@WebServlet(name ="ReviewServlet" , urlPatterns = {"/review","/submitReview","/viewReview",})
public class ReviewServlet extends HttpServlet {


    GenericCRUD<Review> reviewCrud;
    public void init()  throws ServletException{
        super.init();
       reviewCrud = new GenericCRUD<>(Review.class, Config.REVIEWS.getPath());

    }


    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


        String path = request.getServletPath();

        switch (path){
            case "/submitReview":
                // show the review submission form
                String medicineID = request.getParameter("medicineId");
                String medicineName = request.getParameter("medicineName");


                if( medicineID != null && medicineName != null){
                    request.setAttribute("medicineID",medicineID);
                    request.setAttribute("medicineName", medicineName);
                    request.getRequestDispatcher("/submitReview.jsp").forward(request, response);
                }else{
                    response.sendRedirect("index.jsp");
                }

                break;

            case "/viewReviews":

                // display reviews for a specific id

                medicineID= request.getParameter("medicineID");
                if( medicineID != null){
                    List<Review> allreviews  = reviewCrud.getAll();
                    List<Review>  medicineReview = allreviews.stream().filter( review -> review.getMedicineId().equals(medicineID)).collect(Collectors.toList());
                    request .setAttribute("reviews",medicineReview);
                    request.getRequestDispatcher("/viewReviews.jsp").forward(request, response);



                }else {
                    response.sendRedirect("dashboard.jsp");
                }
                break;

            case "/editReview" :
                // show the review edit form

                String reviewID =  request.getParameter("id");
                if( reviewID != null) {
                    Predicate<Review> reviewPredicate = review -> review.getId().equals(reviewID);
                    reviewCrud.get(reviewPredicate).ifPresent(review -> {
                        request.setAttribute("review", review);
                        try {
                            request.getRequestDispatcher("/editReview.jsp").forward(request, response);
                        } catch (ServletException | IOException e) {
                            e.printStackTrace();
                        }
                    });

                } else {
                    response.sendRedirect("index.jsp");
                }
                break;

        }
    }
}
