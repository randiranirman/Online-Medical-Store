package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.onlinemediclestore.Classes.Medicine;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.utils.GenericCRUD;

import java.io.IOException;
import java.rmi.ServerException;


@WebServlet("/deleteMedicine")
public class DeleteMedicine extends HttpServlet
{

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException , ServerException{

        String id =  request.getParameter("medicineId");


        GenericCRUD<Medicine> medicineGenericCRUD=  new GenericCRUD<>(Medicine.class, Config.MEDICINES.getPath())
;
        medicineGenericCRUD.deleteById( medicine ->  medicine.getId().equals(id));



    }
}
