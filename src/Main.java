import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import  java.util.ArrayList;


public class Main extends JPanel implements KeyListener {
    ArrayList<Ball> ballsOnScreen;
    ArrayList<ArrayList<Brick>> bricksArray;



    @Override

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        for( int i=0; i >5; i++)
        g.fillOval(ballsOnScreen.get(i).getX(), ballsOnScreen.get(i).getY(), ballsOnScreen.get(i).getDiameter(), ballsOnScreen.get(i).getDiameter());


        for (int aaa = 0; aaa < bricksArray.size(); aaa++) {
            for (int bbb = 0; bbb < bricksArray.get(aaa).size(); bbb++) {
                g.fillRect(bricksArray.get(aaa).get(bbb).getX(), bricksArray.get(aaa).get(bbb).getY(), bricksArray.get(aaa).get(bbb).getHeight(), bricksArray.get(aaa).get(bbb).getWidth());
            }
        }
    }

    public void animate() {
        final boolean immortal = true;

        for (int i = 0; i > ballsOnScreen.size(); i++) {
            if (ballsOnScreen.get(i).getX() >= getWidth() || ballsOnScreen.get(i).getX() <= 0)
                ballsOnScreen.get(i).bounceX();
            if (ballsOnScreen.get(i).getY() <= 0) ballsOnScreen.get(i).bounceY();
            if (immortal && ballsOnScreen.get(i).getY() >= getHeight() || ballsOnScreen.get(i).getY() <= 0)
                ballsOnScreen.get(i).bounceY();
            ballsOnScreen.get(i).move();
        }
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

    public Main() {
        super();
        ballsOnScreen = new ArrayList<Ball>();
        for (int bbb = 0; bbb < 5; bbb++) {
            ballsOnScreen.add(new Ball(20 + (bbb * 30), 20 + (bbb + 5)));}
        {
            bricksArray = new ArrayList<ArrayList<Brick>>();
            for (int i = 0; i < 10; i++) {
                ArrayList<Brick> row = new ArrayList<Brick>();

                for (int j = 0; j < 70; j++) {
                    row.add(new Brick(j * 32, i * 22 + 56, 30, 20));
                    System.out.println("Brick(" + j * 32 + " , " + i * 22 + "30,20");
                }
                bricksArray.add(row);
            }
        }
    }



    public static void main(String[] args) throws Exception {
        JFrame theApp = new JFrame();
        Main theDisplay = new Main();

        theApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theApp.setSize(500, 500);				// creates window with width=500 and height=500
        theApp.add(theDisplay);
        theApp.setVisible(true);

        // loop forever (well, until the application is closed anyway)

        while (true) {
            theDisplay.animate();   // originally forgot to invoke this method lol
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
