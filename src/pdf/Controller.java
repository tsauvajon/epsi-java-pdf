/*
 * Contient toute la logique de la fenêtre et de l'application : main, appel de la méthode de création de la fenêtre,
 * initialisations, evenements, appel des méthodes d'IO / d'édition etc.
 */
package pdf;

/**
 *
 * @author thomas.sauvajon
 */
public class Controller {
    public static void main(String[] args) {
//        PDDocument joined;
//        PDDocument split;
//        int begin = 2;
//        int end = 4;
//        try {
//            joined = join(PDDocument.load(new File("1.pdf")), PDDocument.load(new File("2.pdf")));
//            joined.save("output.pdf");
//            joined.close();
//            split = split(PDDocument.load(new File("output.pdf")), begin, end);
//            split.save("splittedpages" + (begin + 1) + "to" + (end + 1) + ".pdf");
//            split.close();
//
//        } catch (IOException ex) {
//            Logger.getLogger(Edit.class.getName()).log(Level.SEVERE, null, ex);
//        }
        Window.build();
    }
    
    public static void onClickOpenFile(){
        
    }
    
    public static void onClickCloseFile(){
        
    }
    
    public static void onClickSaveFile(){
        
    }
    
    public static void onClickSplitFile(){
        
    }
    
    public static void onClickJoinFiles(){
        
    }
    // dans le main : appel à la fonction de création de la fenêtre (contenue dans Window.java)
    // tous les appels à toutes les méthodes + gestion des événements se fait ici
}
