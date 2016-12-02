import javax.swing.*;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import  java.util.ArrayList;

public class Main extends JPanel implements KeyListener {
    Ball ballsOnScreen;
    ArrayList<ArrayList<Brick>> bricksArray;
    Ball theBall;
    Brick theBrick;


    @Override

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void animate() {
        ballsOnScreen.move();
    }


    public void update() {
        collision(ballsOnScreen);

}
    public void collision(Ball ba) {
        int bX = ba.getX();
        int bY = ba.getY();
        int bHeight = ba.getHeight();
        int bWidth = ba.getWidth();
        for (int x = 0; x <= 600; x += 55) {
            for (int y = 0; y <= 100; y += 25) {
                if (bX - bWidth <= x && bX + bWidth >= x && bY - bHeight <= y && bY + bHeight >= y) ;
            }
        }
    }

    public Main(){
        super();
    ballsOnScreen = new Ball(170, 190);
    bricksArray = new ArrayList<ArrayList<Brick>>();
        for (int i = 0; i < 3; i++) {
        ArrayList<Brick> row = new ArrayList<Brick>();
            ArrayList<ArrayList<Brick>> bricksArray = new ArrayList<ArrayList<Brick>>();

        for (int j = 0; j < 700; j++) {
            row.add(new Brick(j * 32, i * 22 + 56, 30, 20));
            System.out.println("Brick(" + j * 32 + " , " + i * 22 + "30,20");
        }
        bricksArray.add(row);
    }
}


    public static void main(String[] args) throws Exception {

        JFrame theApp = new JFrame();

        Main theDisplay = new Main();

        theApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        theApp.setSize(500, 500);                // creates window with width=500 and height=500 yeah but no we need GLORIOUS 16X9!!!

        theApp.add(theDisplay);

        theApp.setVisible(true);


        // loop forever (well, until the application is closed anyway)

        while (true) {

            theDisplay.animate();   // originally forgot to invoke this method lol

            theDisplay.update();

            theApp.repaint();        // trigger the JPanel paintComponent() method to be called

            Thread.sleep(20);        // go to sleep for 20 milliseconds

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_0) {
            /* go to this website to find out what you need to do for the panel.... it actually looks easier than the
             bricks in all honesty https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
             */

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
