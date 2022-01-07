/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameloop;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
/**
 *
 * @author kmne6
 */
public class TileMap extends JPanel {

    /**
     * @param args the command line arguments
     */
    
    public TileMap() {       
        
        /*
        getContentPane().setBackground(Color.WHITE);
        setSize(1200, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        */
    }
    
    
    /**
     * This method draws a grid comprising rectangles 
     * @param g 
     */
//    public void drawMap(Graphics g2d) {
//        
//        for (int y = 0; y < 100; y += 10) {
//            for (int x = 0; x < 100; x += 10) {
//                g2d.setColor(BLACK);
//                g2d.drawRect(x + 100, y + 100, 10, 10);
//            }
//        }        
//    }
    
    
    public void drawRectangles(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for(int y = 0; y < 1000; y+= 10) {
            for(int x = 0; x < 1000; x += 10) {
                g2d.setColor(GREEN);
                g2d.drawRect(x, y, 50, 50);
            }
        }
    }
    
    
    public void drawRectangle(Graphics g) {
        Graphics g2d = (Graphics2D) g;
        
        g2d.setColor(RED);
        g2d.drawRect(1200, 1200, 50, 50);
        g2d.fillRect(100, 100, 50, 50);
    }
    
    
    public void moveRectangle(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(BLUE);
        
        for(int i = 0; i < 1000; i += 10) {
            g2d.fillRect(i, 100, 25, 25);
        }
    }
    
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        drawRectangles(g);
        drawRectangle(g);
        moveRectangle(g);
        repaint();
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TileMap().setVisible(true);
            }
        });
    }

}
