/*
 * Contient toute la logique de la fenêtre et de l'application : main, appel de la méthode de création de la fenêtre,
 * initialisations, evenements, appel des méthodes d'IO / d'édition etc.
 */
package pdf;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

/**
 *
 * @author thomas.sauvajon
 */
public class Controller {

    PDDocument openDocument = null;
    boolean hasChanged = false;

    public void onClickOpenFile() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PDF Documents", "pdf");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File chosen = chooser.getSelectedFile();
            try {
                openDocument = PDDocument.load(chosen);
                PDFRenderer pdfRenderer = new PDFRenderer(openDocument);
                for (int page = 0; page < openDocument.getNumberOfPages(); ++page) {
                    BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
                }
            } catch (IOException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        hasChanged = false;
    }

    public void onClickCloseFile() {
        // TODO : fermer proprement le document

        openDocument = null;
    }

    public void onClickSaveAs() {
        // récupérer nom fichier
        String fileName = "";
        try {
            // TODO : fermer fichier en cours (pour éviter erreur d'écriture)

            openDocument.save(fileName);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onClickSplit() {
        if (openDocument != null) {
            // récupérer page début
            int startPage = 2;
            // récupérer page fin
            int endPage = 4;
            openDocument = Edit.split(openDocument, startPage, endPage);
            hasChanged = true;
        }
    }

    public void onClickJoinFiles() throws IOException {
        // TODO : récupérer document à joindre
        PDDocument toJoin = new PDDocument();
        openDocument = Edit.join(openDocument, toJoin);
        hasChanged = true;
    }

    // tous les appels à toutes les méthodes + gestion des événements se fait ici
    public ArrayList<BufferedImage> importFile(ActionEvent e) {

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PDF Documents", "pdf");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File chosen = chooser.getSelectedFile();
            PDDocument document;
            try {
                document = PDDocument.load(chosen);
                PDFRenderer pdfRenderer = new PDFRenderer(document);
                ArrayList<BufferedImage> pdfFiles = new ArrayList();
                for (int page = 0; page < document.getNumberOfPages(); ++page) {
                    BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
                    pdfFiles.add(bim);
                }
                document.close();
                return pdfFiles;
            } catch (IOException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
