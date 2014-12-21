import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
    private int speed = 2;
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
    }   
    public Rock()
    {
        setImage();
    }
    public void movement()
    {
        setLocation(getX(), getY() + speed);
        if(getY() == getWorld().getHeight() - 10)
        {
            getWorld().removeObject(this);
        }
    }
    public void setImage()
    {
        setImage(new GreenfootImage("rock.png"));
    }
}
