/*
 * Contient toutes les méthodes d'édition du pdf
 */
package pdf;

/*
 *
 * @author thomas.sauvajon, loic.thiawwingkai
 */
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class Edit {
    
    static PDDocument joinDoc = null;
    static int JoinSelectedOption;
    static int joinStart;

    public static PDDocument join() {

        PDDocument doc = new PDDocument();
        PDDocument a = PDFWindow.actualFile;
        PDDocument b = joinDoc;
        
        switch(JoinSelectedOption){
            case 1 :
                //début
                for (PDPage page : b.getPages()) {
                    doc.addPage(page);
                }
                for (PDPage page : a.getPages()) {
                    doc.addPage(page);
                }
                break;
            case 2 :
                //fin
                for (PDPage page : a.getPages()) {
                    doc.addPage(page);
                }
                for (PDPage page : b.getPages()) {
                    doc.addPage(page);
                }
                break;
            case 3 :
                //index
                for(int i = 0; i < joinStart; i++){
                    doc.addPage(a.getPage(i));
                }
                for (PDPage page : b.getPages()) {
                    doc.addPage(page);
                }
                for(int i = joinStart; i < a.getNumberOfPages(); i++){
                    doc.addPage(a.getPage(i));
                }
                break;
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
