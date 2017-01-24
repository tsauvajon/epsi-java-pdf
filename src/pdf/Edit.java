/*
 * Contient toutes les méthodes d'édition du pdf
 */
package pdf;

/**
 *
 * @author thomas.sauvajon, loic.thiawwingkai
 */
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class Edit {

    public static PDDocument join(PDDocument a, PDDocument b) throws IOException {

        PDDocument doc = new PDDocument();
//        int pageNb = 1;
//        PDFont font;
//        Encoding ec = Encoding.getInstance(COSName.WIN_ANSI_ENCODING);
//        font = PDTrueTypeFont.load(doc, new File("Roboto-Regular.ttf"), ec);

        for (PDPage page : a.getPages()) {
//            PDPageContentStream content;
//            content = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true);
//            content.beginText();
//            content.setFont(font, 12);
//            content.showText("Page " + pageNb);
//            pageNb++;
//            content.endText();
//            content.close();
            doc.addPage(page);
        }

        for (PDPage page : b.getPages()) {
//            PDPageContentStream content;
//            content = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true);
//            content.beginText();
//            content.setFont(font, 12);
//            content.showText("Page " + pageNb);
//            pageNb++;
//            content.endText();
//            content.close();
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
