package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.onlinemediclestore.Classes.Medicine;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.utils.GenericCRUD;

import javax.print.attribute.standard.MediaName;
import java.io.IOException;
import java.util.List;



@WebServlet("/showProducts")
public class ShowProductServlet extends HttpServlet {
    private final String  FILEPATH = Config.UPLOAD_DIR.getPath();




    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{


        // post method go here
    }

    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

     GenericCRUD<Medicine> medicineGenericCRUD= new GenericCRUD<>(Medicine.class,Config.MEDICINES.getPath());
        List<Medicine> medicineList= medicineGenericCRUD.readAll();
        request.setAttribute("medicines", medicineList);
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);








    }


}
