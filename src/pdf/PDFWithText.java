/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

/**
 *
 * @author thomas.sauvajon
 */
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;

public class PDFWithText {

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

    public static void main(String[] args) {
//        createMockPdf();
//Create a file chooser
        final JFileChooser fc = new JFileChooser();

//In response to a button click:
        int returnVal = fc.showOpenDialog(aComponent);

        PDDocument joined;
        PDDocument split;
        int begin = 2;
        int end = 4;
        try {
            joined = join(PDDocument.load(new File("1.pdf")), PDDocument.load(new File("2.pdf")));
            joined.save("output.pdf");
            joined.close();
            split = split(PDDocument.load(new File("output.pdf")), begin, end);
            split.save("splittedpages" + (begin + 1) + "to" + (end + 1) + ".pdf");
            split.close();

        } catch (IOException ex) {
            Logger.getLogger(PDFWithText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static PDDocument join(PDDocument a, PDDocument b) throws IOException {

        PDDocument doc = new PDDocument();
        int pageNb = 1;
        PDFont font;
        Encoding ec = Encoding.getInstance(COSName.WIN_ANSI_ENCODING);
        font = PDTrueTypeFont.load(doc, new File("Roboto-Regular.ttf"), ec);

        for (PDPage page : a.getPages()) {
            PDPageContentStream content;
            content = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true);
            content.beginText();
            content.setFont(font, 12);
            content.showText("Page " + pageNb);
            pageNb++;
            content.endText();
            content.close();
            doc.addPage(page);
        }

        for (PDPage page : b.getPages()) {
            PDPageContentStream content;
            content = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true);
            content.beginText();
            content.setFont(font, 12);
            content.showText("Page " + pageNb);
            pageNb++;
            content.endText();
            content.close();
            doc.addPage(page);
        }

        return doc;
    }

    public static PDDocument split(PDDocument in, int begin, int end) {
        PDDocument doc = new PDDocument();

        for (int i = begin; i <= end && i < in.getPages().getCount(); i++) {
            doc.addPage(in.getPage(i));
        }

        return doc;
    }
}
