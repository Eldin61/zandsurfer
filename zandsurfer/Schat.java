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
    private int random = Greenfoot.getRandomNumber(1);
    private int soort;
    private String type;
    /**
     * Act - do whatever the Schat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Schat(){
        setImage(new GreenfootImage("treasure.png")); 
        
        
    }
    public Schat (String Soort) {
        type = Soort;
        setImage(new GreenfootImage("powerup.png")); 
    }
    public void act() 
    {
        if (!movement())
        {
            colission();
        }

    }   
   
    public boolean movement()
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

    public int getRandom() {
        return random;
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
