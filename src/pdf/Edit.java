/*
 * Contient toutes les méthodes d'édition du pdf
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

public class Edit {

    public static void main(String[] args) {
//        createMockPdf();
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
            Logger.getLogger(Edit.class.getName()).log(Level.SEVERE, null, ex);
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
