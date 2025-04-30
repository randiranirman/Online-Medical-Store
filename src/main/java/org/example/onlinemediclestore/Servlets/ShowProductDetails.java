package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.onlinemediclestore.Classes.Medicine;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.utils.GenericCRUD;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.Optional;


@WebServlet("/showProductDetails")
public class ShowProductDetails extends HttpServlet {

    private final String FILEPATH = Config.MEDICINES.getPath();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // This method could be used for actions like adding to cart, etc.
        // For now, redirect to doGet to view the product
        doGet(request, response);
    }


    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String medicineID= request.getParameter("medicineId");


        if( medicineID == null || medicineID.isEmpty()) {
            request.setAttribute("error","invalid medicine ID");
            request.getRequestDispatcher(request.getContextPath() +     "viewProduct.jsp").forward(request, response);

        }


        try{
            GenericCRUD<Medicine>  medicineGenericCRUD= new GenericCRUD<>(Medicine.class, Config.MEDICINES.getPath());
            Optional<Medicine> medicineOptional= medicineGenericCRUD.findOneById(medicineID);


            if( medicineOptional.isPresent()){
                    // check if the medicine is available
                Medicine medicine= medicineOptional.get();
                request.setAttribute("medicine",medicine);
                System.out.println("medicine found");
                request.getRequestDispatcher( "viewProduct.jsp").forward(request, response);


            }else{
                request.setAttribute("error", "Medicine not found");
                request.getRequestDispatcher("viewProduct.jsp").forward(request, response);
            }
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("error", "System error " +  e.getMessage());
            request.getRequestDispatcher("viewProduct.jsp").forward(request, response);

        }



    }

}
