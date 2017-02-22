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
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

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
    
    public static PDDocument addText(PDDocument in, int begin, int xPos, int yPos, String text) throws IOException{
        // Start a new content stream which will "hold" the to be created content
        System.out.println(xPos + ":" + yPos);
        PDPageContentStream contentStream = new PDPageContentStream(in, in.getPage(begin), PDPageContentStream.AppendMode.APPEND, false, true);
        PDFont font = PDType1Font.TIMES_ROMAN;
        // Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
        contentStream.beginText();
        contentStream.setFont( font, 12 );
        contentStream.newLineAtOffset(xPos, in.getPage(begin).getBBox().getHeight() - yPos);
        contentStream.showText(text);
        contentStream.endText();
        
        // Make sure that the content stream is closed:
        contentStream.close();
        
        return in;
    }
}
