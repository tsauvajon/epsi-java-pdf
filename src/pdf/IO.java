/*
 * 
 * Contient toutes les fonctionnalités d'entrée / sortie
 * (open, close, save...)
 * 
 * 
 */
package pdf;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;

/**
 *
 * @author thomas.sauvajon, loic.thiawwingkai
 */
public class IO {
 
    // méthode open()
    
    // méthode save()
    
    public static void createMockPdf() {
        PDDocument doc;
        PDPage page;

        try {
            doc = new PDDocument();
            page = new PDPage();

            doc.addPage(page);
            PDFont font;
            Encoding ec = Encoding.getInstance(COSName.WIN_ANSI_ENCODING);
            font = PDTrueTypeFont.load(doc, new File("Roboto-Regular.ttf"), ec);

            PDPageContentStream content;
            content = new PDPageContentStream(doc, page);
            content.beginText();
            content.setFont(font, 12);
            content.showText("BONJOUR !");
            content.endText();
            content.setNonStrokingColor(Color.PINK);
            content.setStrokingColor(Color.BLACK);
            content.addRect(50, 50, 150, 200);
            content.addRect(500, 500, 100, 80);
            content.fillAndStroke();
            content.close();
            doc.save("PDFWithText.pdf");
            doc.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
