/**
 * Contient tous les élements graphiques et uniquement les élements graphiques
 * La logique de la fenêtre (evenements, appel de méthodes, etc.) est gérée dans Controller.java
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
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

/**
 *
 * @author Guillaume
 */

public class Window {
    public static void build(){
        JFrame fenetre = new JFrame();
        //Définit un titre pour notre fenêtre
        fenetre.setTitle("Ma première fenêtre Java");
        //Définit sa taille : 400 pixels de large et 100 pixels de haut
        fenetre.setSize(500, 500);
        //Nous demandons maintenant à notre objet de se positionner au centre
        fenetre.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar bar = new JMenuBar();
        JMenuItem item = new JMenuItem("Nouveau");
        JMenu menu = new JMenu("Fichier");
        menu.add(item);
        bar.add(menu);
        item.addActionListener((ActionEvent e) -> {
            Controller.importFile(e);
        });
        fenetre.setJMenuBar(bar);
        //Et enfin, la rendre visible        
        fenetre.setVisible(true);
    }
}