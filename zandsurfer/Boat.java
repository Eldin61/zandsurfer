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
        if(!hitTreasure())
        {
            colission();
        }
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
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(), getY());
            getWorld().removeObject(rock);
            getWorld().removeObject(this);
        }
    }

    private boolean hitTreasure()
    {
        Actor schat = getOneIntersectingObject(Schat.class);
        if (schat != null)
        {
            game3 gameWorld = (game3) getWorld();
            Counter counter = gameWorld.getCounter();
            counter.bumpCount(1);
            getWorld().removeObject(schat);
            return true;
        } else 
        {
            return false;
        }

    }
}
