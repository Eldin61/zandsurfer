import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Schat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Schat extends Actor
{
    private int speed = 2;
    /**
     * Act - do whatever the Schat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        colission();
        movement();        
    }    
    public void colission()
    {
        Actor rock = getOneIntersectingObject(Rock.class);
        if(rock != null)
        {
            getWorld().removeObject(rock);
        }
    }
    public void movement()
    {
        setLocation(getX(), getY() + speed);
        if(getY() == getWorld().getHeight() - 10)
        {
            getWorld().removeObject(this);
        }
    }
}
