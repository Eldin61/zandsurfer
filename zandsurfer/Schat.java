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
        if (!movement())
        {
            colission();
        }
    }    

    

    private boolean movement()
    {
        setLocation(getX(), getY() + speed);
        if(getY() == getWorld().getHeight() - 10)
        {
            getWorld().removeObject(this);
            return true;
        } else {
            return false;
        }
    }
    public void colission()
    {
        Actor rock = getOneIntersectingObject(Rock.class);
        if(rock != null)
        {
            int newSpawn = Greenfoot.getRandomNumber(800);
            Schat schat = new Schat();
            getWorld().addObject(schat, newSpawn, 0);
            getWorld().removeObject(this);
        }
    }
}
