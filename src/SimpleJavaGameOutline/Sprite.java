package SimpleJavaGameOutline;

//Allow panel drawing.

//Collision detection.

//Used for setting sprite image.

//Used for panel drawing.


import javax.swing.*;
import java.awt.*;

/**
 * ABSTRACT: Class that holds data about a 'sprite' object.
 */
public class Sprite {

    //Hold sprite location.
    private int x, y;

    //Hold sprite velocity. (Value that increments location value.)
    private int vx, vy;

    //The image of the sprite.
    private ImageIcon image;

    //Set to display sprite.
    private boolean show = true;



    /*
     * Default constructor.
     */
    protected Sprite(){

        x = 0;
        y = 0;
        vx = 0;
        vy = 0;
    }



    /*
     * Setters.
     */
    protected void setX(int x) { this.x = x; }

    protected void setY(int y) { this.y = y; }

    protected void setVx(int vx) { this.vx = vx; }

    protected void setVy(int vy) { this.vy = vy; }

    //Method to set the image variable.
    protected void setImage(String filename){
        try{
            this.image = new ImageIcon(getClass().getResource(filename));
        }
        catch(Exception e){
            image = null;
        }
    }



    /*
     * Getters.
     */
    protected int getX() { return x; }

    protected int getY() { return y; }

    protected int getVx() { return vx; }

    protected int getVy() { return vy; }

    // Returns the width, else 20.
    public int getWidth(){
        if(image == null){
            return 20;
        }
        return image.getIconWidth();
    }

    // Returns height, else 20.
    public int getHeight(){
        if(image == null){
            return 20;
        }
        return image.getIconHeight();
    }




    /*
     * Methods.
     */
    //Update location based on velocity.
    protected void move(){

        x += vx;
        y += vy;
    }

    //Method to check for collisions.
    public boolean isCollision(Sprite o){

        Rectangle you = new Rectangle(x, y, getWidth(), getHeight());
        Rectangle other = new Rectangle(o.getX(), o.getY(), o.getWidth(), o.getHeight());

        return you.intersects(other);
    }


    //Method to put graphic onto panel.
    public void paint(Graphics g, JPanel panel){
        if(show){
            if(image == null){
                g.drawRect(x, y, 20, 20);
            }
            else{
                image.paintIcon(panel, g, x, y);
            }
        }
    }

/////
}