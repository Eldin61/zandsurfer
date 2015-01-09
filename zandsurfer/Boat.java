import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boat extends Actor
{
    private int speed;
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
        setImage(new GreenfootImage("bootgame3.png"));
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int i) {
        speed = i;  
    }

    public void movement()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - getSpeed(), getY());
        }
        if (Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + getSpeed(), getY());
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
