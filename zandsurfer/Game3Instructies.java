import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Game3Instructies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game3Instructies extends World
{

    /**
     * Constructor for objects of class Game3Instructies.
     * 
     */
    public Game3Instructies()
    {    
        super(700, 600, 1); 
        //BackButton button1 = new BackButton("win");
        //addObject(button1,30,30);
    }

    public void act() {
        if (Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new game3());
        }

    }

}
