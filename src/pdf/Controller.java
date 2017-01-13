/*
 * Contient toute la logique de la fenêtre et de l'application : main, appel de la méthode de création de la fenêtre,
 * initialisations, evenements, appel des méthodes d'IO / d'édition etc.
 */
package pdf;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author thomas.sauvajon
 */
public class Controller {

    static PDDocument openDocument = null;
    static boolean hasChanged = false;

    public static void main(String[] args) {
        // création de la fenêtre
        Window.build();
    }

    public static void onClickOpenFile() {
        hasChanged = false;
    }

    public static void onClickCloseFile() {
        // TODO : fermer proprepement le documentt

        openDocument = null;
    }

    public static void onClickSaveAs() {
        // récupérer nom fichier
        String fileName = "";
        try {
            // fermer fichier en cours (pour éviter erreur d'écriture)écriture
            
            openDocument.save(fileName);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void onClickSplit() {
        if (openDocument != null) {
            // récupérer page début
            int startPage = 2;
            // récupérer page fin
            int endPage = 4;
            openDocument = Edit.split(openDocument, startPage, endPage);
            hasChanged = true;
        }
    }

    public static void onClickJoinFiles() {
        // récupérer document à joindre
        PDDocument toJoin = new PDDocument();
        openDocument = Edit.join(openDocument, toJoin);
        hasChanged = true;
    }
    // tous les appels à toutes les méthodes + gestion des événements se fait ici
}
