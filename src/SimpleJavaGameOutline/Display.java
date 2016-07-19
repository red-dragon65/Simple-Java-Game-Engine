package SimpleJavaGameOutline;

//Allow drawing to panel.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

//For game loop.
//Keyboard input listener.
//Panel that goes into JFrame.


/**
 * Class that creates a custom panel to go into
 * a window (JFrame). Holds main gameloop.
 */
public class Display extends JPanel implements ActionListener{


    //Gameloop
    Timer gameLoop;

    //Hero sprite.
    private Sprite hero = new Sprite();

    //Random gen to set enemy location.
    Random rand = new Random();


    /*
     * Default constructor. 
     */
    public Display(){

        //Initialize keyboard input.
        addKeyListener(new KeyPressing());

        //Sets the focus to the JPanel (this).
        setFocusable(true);

        //Makes the movement smooth.
        setDoubleBuffered(true);

        //Set panel size. (Set to same size as window).
        setSize(1920, 1080);

        //Set sprite data.
        initializeSprites();

        //Create the game loop at 20 milliseconds intervals.
        //1,000 milliseconds in a second. 1,000 / 20 = 50 intervals. A.K.A 50fps.
        gameLoop = new Timer(20, this);
        gameLoop.start();
    }



    /*
     * Method to set sprite data.
     */
    private void initializeSprites(){

        //Set hero image.
        hero.setImage("link.png");

        //Set hero starting location.
        hero.setX(500);
        hero.setY(500);
    }



    /*
     * Game loop timer. Runs at 50 intervals a second.
     */
    public void actionPerformed(ActionEvent e){

        //Makes the hero move.
        hero.move();

        //refreshes the screen.
        repaint();
    }



    /*
     * Draw graphics onto screen using sprite paint method.
     * NOTE: Whatever is painted last will be on top of the other sprites.
     */
    public void paintComponent(Graphics g){
        //Erases the previous screen.
        super.paintComponent(g);

        //Draw hero.
        hero.paint(g, this);
    }






    /**
     * Class that reads keyboard input for moving.
     */
    public class KeyPressing extends KeyAdapter{

        /*
         * Event that occurs when the user presses a key.
         * Used to move hero.
         */
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_RIGHT:
                    hero.setVx(10);
                    break;
                case KeyEvent.VK_LEFT:
                    hero.setVx(-10);
                    break;
                case KeyEvent.VK_UP:
                    hero.setVy(-10);
                    break;
                case KeyEvent.VK_DOWN:
                    hero.setVy(10);
                    break;
            }
            repaint();
        }



        /*
         * Event that occurs when the user releases a key.
         * Used to stop the hero.
         */
        public void keyReleased(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_RIGHT:
                    hero.setVx(0);
                    break;
                case KeyEvent.VK_LEFT:
                    hero.setVx(0);
                    break;
                case KeyEvent.VK_UP:
                    hero.setVy(0);
                    break;
                case KeyEvent.VK_DOWN:
                    hero.setVy(0);
                    break;
            }
        }
    }
/////
}