package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.onlinemediclestore.Classes.Medicine;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.utils.GenericCRUD;

import java.io.IOException;
import java.util.Optional;


@WebServlet("/orderProcessing")
public class OrderProcessingServlet extends HttpServlet {

    private  final  String FILEPATH = Config.ORDERS.getPath();


    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession()
;
        
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String medicineId= request.getParameter("medicineId");

        if( medicineId == null ||  medicineId.isEmpty()){

            request.setAttribute("error", "medicine not found");


        }
        GenericCRUD<Medicine> medicineGenericCRUD= new GenericCRUD<>(Medicine.class, FILEPATH);






    }
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{


    }
}
