/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameloop;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author kmne6
 */
public class GamePanel extends JPanel
   {
      float interpolation;
      float ballX, ballY, lastBallX, lastBallY;
      int ballWidth, ballHeight;
      float ballXVel, ballYVel;
      float ballSpeed;
      
      int fps = 60;         // TODO make this private and provide a setter
      int frameCount = 0;   // TODO make this private and provide a setter
      
      int lastDrawX, lastDrawY;
      
      public GamePanel()
      {
         ballX = lastBallX = 100;
         ballY = lastBallY = 100;
         ballWidth = 25;
         ballHeight = 25;
         ballSpeed = 25;
         ballXVel = (float) Math.random() * ballSpeed*2 - ballSpeed;
         ballYVel = (float) Math.random() * ballSpeed*2 - ballSpeed;
      }
      
      public void setInterpolation(float interp)
      {
         interpolation = interp;
      }
      
      public void update()
      {
         lastBallX = ballX;
         lastBallY = ballY;
         
         ballX += ballXVel;
         ballY += ballYVel;
         
         if (ballX + ballWidth/2 >= getWidth())
         {
            ballXVel *= -1;
            ballX = getWidth() - ballWidth/2;
            ballYVel = (float) Math.random() * ballSpeed*2 - ballSpeed;
         }
         else if (ballX - ballWidth/2 <= 0)
         {
            ballXVel *= -1;
            ballX = ballWidth/2;
         }
         
         if (ballY + ballHeight/2 >= getHeight())
         {
            ballYVel *= -1;
            ballY = getHeight() - ballHeight/2;
            ballXVel = (float) Math.random() * ballSpeed*2 - ballSpeed;
         }
         else if (ballY - ballHeight/2 <= 0)
         {
            ballYVel *= -1;
            ballY = ballHeight/2;
         }
      }
      
      public void paintComponent(Graphics g)
      {
         //BS way of clearing out the old rectangle to save CPU.
         g.setColor(getBackground());
         g.fillRect(lastDrawX-1, lastDrawY-1, ballWidth+2, ballHeight+2);
         g.fillRect(5, 0, 75, 30);
         
         g.setColor(Color.RED);
         int drawX = (int) ((ballX - lastBallX) * interpolation + lastBallX - ballWidth/2);
         int drawY = (int) ((ballY - lastBallY) * interpolation + lastBallY - ballHeight/2);
         g.fillOval(drawX, drawY, ballWidth, ballHeight);
         
         lastDrawX = drawX;
         lastDrawY = drawY;
         
         g.setColor(Color.BLACK);
         g.drawString("FPS: " + fps, 5, 10);
         
         frameCount++;
      }
    
}
