/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;

/**
 *
 * @author Guillaume
 */
public class PDFfile extends JComponent {
    private Image image;
    public PDFfile(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
