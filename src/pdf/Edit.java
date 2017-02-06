/*
 * Contient toutes les méthodes d'édition du pdf
 */
package pdf;

/*
 *
 * @author thomas.sauvajon, loic.thiawwingkai
 */
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class Edit {

    public static PDDocument join(PDDocument a, PDDocument b) throws IOException {

        PDDocument doc = new PDDocument();
        
        for (PDPage page : a.getPages()) {
            doc.addPage(page);
        }

        for (PDPage page : b.getPages()) {
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
