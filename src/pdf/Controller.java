/*
 * Contient toute la logique de la fenêtre et de l'application : main, appel de la méthode de création de la fenêtre,
 * initialisations, evenements, appel des méthodes d'IO / d'édition etc.
 */
package pdf;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

/**
 *
 * @author thomas.sauvajon
 */
public class Controller {
    //TODO : mettre le main ici
    
    // dans le main : appel à la fonction de création de la fenêtre (contenue dans Window.java)
    // tous les appels à toutes les méthodes + gestion des événements se fait ici
    public static void importFile(ActionEvent e){
            
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "PDF Documents", "pdf");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                File chosen = chooser.getSelectedFile();
                PDDocument document;
                try {
                    document = PDDocument.load(chosen);
                    PDFRenderer pdfRenderer = new PDFRenderer(document);
                    ArrayList<BufferedImage> pdfFiles = new ArrayList();
                    for (int page = 0; page < document.getNumberOfPages(); ++page)
                    {
                        BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
                        pdfFiles.add(bim);
                    }
                    document.close();
                } catch (IOException ex) {
                    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
}
