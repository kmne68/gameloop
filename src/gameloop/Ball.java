/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameloop;

/**
 *
 * @author kmne6
 */
public class Ball {

    float x, y, lastX, lastY;
    int width, height;
    float xVelocity, yVelocity;
    float speed;

    float panelWidth = 0;
    float panelHeight = 0;
    GamePanel gamePanel = null; // new GamePanel();

    public Ball(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        width = (int) (Math.random() * 50 + 10);
        height = (int) (Math.random() * 50 + 10);
        x = (float) (Math.random() * (gamePanel.getWidth() - width) + width / 2);
        y = (float) (Math.random() * (gamePanel.getHeight() - height) + height / 2);
        
        lastX = x;
        lastY = y;
        lastX = panelWidth;
        lastY = panelHeight;

        xVelocity = (float) Math.random() * speed * 2 - speed;
        yVelocity = (float) Math.random() * speed * 2 - speed;
    }

    public void update() {
        lastX = x;
        lastY = y;

        x += xVelocity;
        y += yVelocity;

        if (x + width / 2 >= gamePanel.getWidth()) {
            xVelocity *= -1;
            x = gamePanel.getWidth() - width / 2;
            yVelocity = (float) Math.random() * speed * 2 - speed;
        } else if (x - width / 2 <= 0) {
            xVelocity *= -1;
            x = width / 2;
        }

        if (y + height / 2 >= gamePanel.getHeight()) {
            yVelocity *= -1;
            y = gamePanel.getHeight() - height / 2;
            xVelocity = (float) Math.random() * speed * 2 - speed;
        } else if (y - height / 2 <= 0) {
            yVelocity *= -1;
            y = height / 2;
        }
    }

}
