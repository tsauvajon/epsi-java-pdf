/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

/**
 *
 * @author thomas.sauvajon, loic.thiawwingkai
 */
public class PDFWindow extends javax.swing.JFrame {

    /**
     * Creates new form PDFWindow
     */
    public PDFWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPanelBody = new javax.swing.JPanel();
        jButtonPreviousPage = new javax.swing.JButton();
        jButtonNextPage = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Ouvrir = new javax.swing.JButton();
        Enregistrer = new javax.swing.JButton();
        jButtonExtract = new javax.swing.JButton();
        jButtonJoin = new javax.swing.JButton();
        toPage = new javax.swing.JTextField();
        fromPage = new javax.swing.JTextField();
        jScrollPaneImageContainer = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemSaveAs = new javax.swing.JMenuItem();
        jMenuItemClose = new javax.swing.JMenuItem();
        jMenuItemQuit = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemJoin = new javax.swing.JMenuItem();
        jMenuItemExtract = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonPreviousPage.setText("Page précedente");
        jButtonPreviousPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousPageActionPerformed(evt);
            }
        });

        jButtonNextPage.setText("Page suivante");
        jButtonNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextPageActionPerformed(evt);
            }
        });

        jToolBar1.setRollover(true);
        jToolBar1.setFocusable(false);

        jLabel1.setText("zoom");
        jLabel1.setToolTipText("");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jSlider1, org.jdesktop.beansbinding.ELProperty.create("${value}%"), jLabel2, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        Ouvrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pdf/ouvrir.jpg"))); // NOI18N
        Ouvrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OuvrirActionPerformed(evt);
            }
        });

        Enregistrer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pdf/enregistrer.png"))); // NOI18N
        Enregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnregistrerActionPerformed(evt);
            }
        });

        jButtonExtract.setText("Extraire");

        jButtonJoin.setText("Joindre un autre PDF ...");
        jButtonJoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJoinActionPerformed(evt);
            }
        });

        toPage.setToolTipText("à");

        fromPage.setToolTipText("De");
        fromPage.setName(""); // NOI18N
        fromPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromPageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(Ouvrir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Enregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(fromPage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(toPage, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonExtract)
                .addGap(115, 115, 115)
                .addComponent(jButtonJoin)
                .addContainerGap(304, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Enregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Ouvrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonExtract, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonJoin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(toPage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fromPage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        jToolBar1.add(jPanel1);

        jScrollPaneImageContainer.setEnabled(false);

        javax.swing.GroupLayout jPanelBodyLayout = new javax.swing.GroupLayout(jPanelBody);
        jPanelBody.setLayout(jPanelBodyLayout);
        jPanelBodyLayout.setHorizontalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelBodyLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPaneImageContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelBodyLayout.createSequentialGroup()
                                .addComponent(jButtonPreviousPage)
                                .addGap(93, 93, 93)
                                .addComponent(jButtonNextPage)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelBodyLayout.setVerticalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBodyLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(jScrollPaneImageContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 575, Short.MAX_VALUE)
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPreviousPage)
                    .addComponent(jButtonNextPage)))
        );

        jMenuFile.setText("Fichier");

        jMenuItemOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemOpen.setText("Ouvrir ...");
        jMenuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemOpen);

        jMenuItemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSave.setText("Enregistrer");
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSave);

        jMenuItemSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSaveAs.setText("Enregistrer sous ...");
        jMenuItemSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveAsActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSaveAs);

        jMenuItemClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemClose.setText("Fermer");
        jMenuItemClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCloseActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemClose);

        jMenuItemQuit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemQuit.setText("Quitter");
        jMenuItemQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemQuitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemQuit);

        jMenuBar1.add(jMenuFile);

        jMenuEdit.setText("Editer");

        jMenuItemJoin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemJoin.setText("Joindre ...");
        jMenuEdit.add(jMenuItemJoin);

        jMenuItemExtract.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemExtract.setText("Extraire ...");
        jMenuItemExtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExtractActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemExtract);

        jMenuBar1.add(jMenuEdit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBody, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenActionPerformed
        openDocument = importFile(evt);
        images = getImages(openDocument);
        JPanel canvas = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(images.get(0), 0, 0, null);
            }
        };
        canvas.setPreferredSize(new Dimension(images.get(0).getWidth(), images.get(0).getHeight()));
        canvas.repaint();
        jScrollPaneImageContainer.setViewportView(canvas);
        jScrollPaneImageContainer.revalidate();
        System.out.println("finished - " + images.get(0).getWidth() + ' ' + images.get(0).getHeight());
    }//GEN-LAST:event_jMenuItemOpenActionPerformed

    private void jMenuItemQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemQuitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItemQuitActionPerformed

    private void jMenuItemExtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExtractActionPerformed
        // TODO add your handling code here:
        // TODO : demander page de début, page de fin (ou nb de pages ?), le chemin de destination, puis sauver le fichier.
    }//GEN-LAST:event_jMenuItemExtractActionPerformed

    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        if (openDocument != null && openDocumentPath != null) {
            try {
                openDocument.save(openDocumentPath);
            } catch (IOException ex) {
                Logger.getLogger(PDFWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItemSaveActionPerformed

    private void jButtonPreviousPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousPageActionPerformed
        if (images != null && !images.isEmpty() && currentPage > 0) {
            currentPage--;
            //todo : afficher image(currentPage)
        }
    }//GEN-LAST:event_jButtonPreviousPageActionPerformed

    private void jButtonNextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextPageActionPerformed
        if (images != null && !images.isEmpty() && images.size() > currentPage + 1) {
            currentPage++;
            //todo : afficher image(currentPage)
        }
    }//GEN-LAST:event_jButtonNextPageActionPerformed

    private void jMenuItemSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveAsActionPerformed
        // TODO add your handling code here:
        if (openDocument != null) {
            try {
                // todo : prompt path => openDocumentPath
                openDocument.save(openDocumentPath);
            } catch (IOException ex) {
                Logger.getLogger(PDFWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItemSaveAsActionPerformed

    private void jMenuItemCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCloseActionPerformed
        if (openDocument != null) {
            try {
                openDocument.close();
            } catch (IOException ex) {
                Logger.getLogger(PDFWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        openDocumentPath = null;
        images = null;
        // ne plus afficher d'image dans le panel
    }//GEN-LAST:event_jMenuItemCloseActionPerformed

    private void OuvrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OuvrirActionPerformed
        // TODO add your handling code here:
//        openDocument = importFile(evt);
//        if (openDocument != null) {
//            images = getImages(openDocument);
//            jScrollPaneImageContainer.setEnabled(true);
//        }
        jMenuItemOpenActionPerformed(evt);
    }//GEN-LAST:event_OuvrirActionPerformed

    private void EnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnregistrerActionPerformed
        // TODO add your handling code here:
        if (openDocument != null && openDocumentPath != null) {
            try {
                openDocument.save(openDocumentPath);
            } catch (IOException ex) {
                Logger.getLogger(PDFWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_EnregistrerActionPerformed

    private void fromPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromPageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromPageActionPerformed

    private void jButtonJoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJoinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonJoinActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PDFWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PDFWindow().setVisible(true);
        });
    }

    private PDDocument openDocument;
    private ArrayList<BufferedImage> images;
    boolean hasChanged = false;
    int currentPage = 0;
    String openDocumentPath;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Enregistrer;
    private javax.swing.JButton Ouvrir;
    private javax.swing.JTextField fromPage;
    private javax.swing.JButton jButtonExtract;
    private javax.swing.JButton jButtonJoin;
    private javax.swing.JButton jButtonNextPage;
    private javax.swing.JButton jButtonPreviousPage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemClose;
    private javax.swing.JMenuItem jMenuItemExtract;
    private javax.swing.JMenuItem jMenuItemJoin;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemQuit;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JMenuItem jMenuItemSaveAs;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBody;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPaneImageContainer;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField toPage;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    PDDocument importFile(ActionEvent e) {
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
                openDocumentPath = chosen.getPath();
                return document;
            } catch (IOException ex) {
                Logger.getLogger(PDFWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    ArrayList<BufferedImage> getImages(PDDocument doc) {
        PDFRenderer pdfRenderer = new PDFRenderer(doc);
        ArrayList<BufferedImage> pdfFiles = new ArrayList();
        try {
            for (int page = 0; page < doc.getNumberOfPages(); ++page) {
                BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);;
                pdfFiles.add(bim);
            }
            doc.close();
        } catch (IOException ex) {
            Logger.getLogger(PDFWindow.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return pdfFiles;
    }
}
