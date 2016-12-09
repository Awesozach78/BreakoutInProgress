import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;


public class Paddle{
    public int xPosition = 0;
    public int yPosition = 0;
    // dx is the distance to travel each time in pixels
    int dx = 5;
    int minx = 0;
    int maxx = 1000;

    int width = 100;
    int height = 20;
    public boolean leftPressed = false;
    public boolean rightPressed = false;

    // constructor
    public Paddle(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;

    }

    // painting the paddle to the screen



    // when the moveLeft method is called by the keyPressed method, the paddle should move to the left
    public void moveLeft() {
        if (xPosition - dx > minx) {
            xPosition -= dx;
        } else {
            xPosition = minx;
        }
    }

    // when the moveRight method is called by the keyPressed method, the paddle should move to the left
    public void moveRight() {
        if (xPosition - dx > minx) {
            xPosition += dx;
        } else {
            xPosition = minx;
        }
    }

    // to set the location of the paddle manually
    public void setLocation(int i, int j) {
        xPosition = i;
        yPosition = j;
    }

    public int getWidth() {
        return width;
    } // return the current x-axis coordinate of the top left corner of the ball
    public int getX() {
        return xPosition;
    }

    // return the current y-axis coordinate of the top left corner of the ball
    public int getY() {
        return yPosition;
    }

    public  int getHeight() {
        return dx;
    }


}