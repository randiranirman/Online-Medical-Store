package org.example.onlinemediclestore.FileHandlers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


// annotation for file size
@MultipartConfig(fileSizeThreshold=1024*1024*2,  // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50)   // 50MB
@WebServlet("/addMedicine")
public class MedicineServlet {


    protected  void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {


        String name  = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));








    }
}
