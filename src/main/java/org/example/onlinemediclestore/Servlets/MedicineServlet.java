package org.example.onlinemediclestore.Servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.example.onlinemediclestore.FileConfig.Config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


// annotation for file size
@MultipartConfig(fileSizeThreshold=1024*1024*2,  // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50)   // 50MB
@WebServlet("/addMedicine")
public class MedicineServlet extends HttpServlet {
        private static  final String UPLOAD_DIR = Config.UPLOAD_DIR.getPath();// dir to save images


    protected  void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {

        // Set encoding to handle UTF-8
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        //get FORM fields
        String name  = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));



        //handle missing /invalid values
        if( name == null || description== null  || name.isBlank() || description.isBlank()){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,"All fields are  required");
            return;
        }

        //get upload file
        Part filePart = request.getPart("image");
        String fileName = getFileName(filePart);


        if( fileName == null || fileName.isBlank())
        {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,"image is reqiured");
            return;
        }


        // save uploaded image to disk
        String uploadPath =  UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        String savedFilePath = uploadPath + File.separator + fileName;
        try (InputStream fileContent = filePart.getInputStream();
             FileOutputStream fos = new FileOutputStream(savedFilePath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileContent.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }

        // Save medicine data
        System.out.println("Medicine added: " + name + " | $" + price + " | " + fileName);

        // Redirect or show confirmation

        response.sendRedirect(request.getContextPath() + "/addMedicine?success=true");












    }

    // Utility method to extract filename from Part
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        if (contentDisp == null) return null;

        for (String cd : contentDisp.split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    protected  void doGet ( HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException{
            String successParam = request.getParameter("success");


            if( "true".equals(successParam)){
                request.setAttribute("successMessage","Item added successfully");

            }
            // forward  to jsp
            request.getRequestDispatcher("viewMedicine.jsp").forward(request, response);




    }
}
