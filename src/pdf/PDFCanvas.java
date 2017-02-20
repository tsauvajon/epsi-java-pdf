/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Guillaume
 */
public class PDFCanvas extends JPanel {
    
    private BufferedImage image  = null;
    PDFCanvas(BufferedImage image){
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0,
            Math.round(image.getWidth() * PDFWindow.zoom),
            Math.round(image.getHeight() * PDFWindow.zoom), null);
    }
    
}
