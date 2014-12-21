import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boat extends Actor
{
    private int speed = 3;
    public void act() 
    {
        movement();
        colission();
    }    
    public Boat()
    {
        setImage();
    }
    public void setImage()
    {
        setImage(new GreenfootImage("Boat1.png"));
    }
    public void movement()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - speed, getY());
        }
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + speed, getY());
        }
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - speed);
        }
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + speed);
        }
    }
    public void colission()
    {
        Actor rock = getOneIntersectingObject(Rock.class);
        if (rock != null)
        {
            getWorld().removeObject(this);
        }
    }
}
