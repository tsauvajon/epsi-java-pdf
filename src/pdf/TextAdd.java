/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import java.awt.Graphics;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import static pdf.PDFWindow.panels;

/**
 *
 * @author Guillaume
 */
public class TextAdd extends JTextArea{
    public int prevPosX = 0;
    public int newPosX = 0;
    public int prevPosY = 0;
    public int newPosY = 0;
    @Override
    public void paint(Graphics g) {
        SpringLayout layout = (SpringLayout) panels.get(1).getLayout();
                layout.putConstraint(SpringLayout.WEST, this,
                     newPosX,
                     SpringLayout.WEST, panels.get(1));
                layout.putConstraint(SpringLayout.NORTH, this,
                     newPosY,
                     SpringLayout.NORTH, panels.get(1));
       this.setLocation(newPosX, newPosY);
       super.paint(g);
       this.setLocation(newPosX, newPosY);
    }
}
