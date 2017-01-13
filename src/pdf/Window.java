/**
 * Contient tous les élements graphiques et uniquement les élements graphiques
 * La logique de la fenêtre (evenements, appel de méthodes, etc.) est gérée dans Controller.java
 */
package pdf;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Guillaume
 */

public class Window {
    public static void build(){
        JFrame fenetre = new JFrame();
        //Définit un titre pour notre fenêtre
        fenetre.setTitle("On fait PDF ?");
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
            Controller.onClickOpenFile();
        });
        fenetre.setJMenuBar(bar);
        //Et enfin, la rendre visible        
        fenetre.setVisible(true);
    }
}