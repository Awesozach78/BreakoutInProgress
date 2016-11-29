import javax.swing.*;

import java.awt.Graphics;
import  java.util.ArrayList;

public class Main extends JPanel {
    Ball ballsOnScreen;
    ArrayList<ArrayList<Brick>> bricksArray;


    @Override

    protected void paintComponent(Graphics g) {


        super.paintComponent(g);
        for (int ii = 0; ii > bricksArray.size(); ii++) {
            g.fillRect(bricksArray.get(ii).getX(), bricksArray.get(ii).getY(), bricksArray.get(ii).getHeight(), bricksArray.get(ii).getWidth());
        }
    }

    public void animate() {
        ballsOnScreen.move();
    }

    public Main() {

        super();
        ballsOnScreen = new Ball(170, 190);
        bricksArray = new ArrayList<ArrayList<Brick>>();
        for (int i = 0; i < 3; i++) {
            ArrayList<Brick> row = new ArrayList<Brick>();
            for (int j = 0; j < 700; j++) {
                row.add(new Brick(j * 32, i * 22 + 56, 30, 20));
                System.out.println("Brick(" + j * 32 + " , " + i * 22 + "30,20");
            }
            bricksArray.add(row);
        }
    }


    public void update(Ball ba) {
        collision(ba);
    }


    public void collision(Ball ba) {
        int bX = ba.getX();
        int bY = ba.getY();
        int bHeight = ba.getHeight();
        int bWidth = ba.getWidth();
        for (int x = 0; x <= 600; x += 55) {
            for (int y = 0; y <= 100; y += 25) {
                if (bX - bWidth <= x && bX + bWidth >= x && bY - bHeight <= y && bY + bHeight >= y) {
                    ba.setXVel(6);
                }
            }
        }
    }

    public void paint(Graphics g) {
        for (int x = 0; x <= 800; x += 55) {
            for (int y = 0; y <= 100; y += 25) {
                g.fillRect(x, y, 50, 20);
            }
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

            theDisplay.animate();    // originally forgot to invoke this method lol

            theApp.repaint();        // trigger the JPanel paintComponent() method to be called

            Thread.sleep(20);        // go to sleep for 20 milliseconds

        }
    }
}