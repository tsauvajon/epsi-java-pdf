/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

/**
 *
 * @author Floriane
 */
import org.apache.pdfbox.pdmodel.*;
//import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import java.io.*;
 
public class JPG{
    
     //Marche avec les images de types JPG, TIFF (only G4 compression), PNG, BMP and GIF
 /*   public static void main(String[] args) {
        PDDocument doc = null;
        try{

         doc = new PDDocument();
         PDPage page = new PDPage();
         doc.addPage(page);
         
         PDImageXObject image = null;
         
         image = PDImageXObject.createFromFile("image.jpg", doc);
         
         PDPageContentStream content = new PDPageContentStream(doc, page);
 

         content.drawImage(image,20,20);
         content.close();
        
        doc.save("ImageNowPdf.pdf");
       
        } catch (Exception e){
             System.out.println("Exception");
        }
    }*/
}