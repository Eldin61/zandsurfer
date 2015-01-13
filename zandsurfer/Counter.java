import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    private int totalCount = 0;
    
    public Counter()
    {
        setImage(new GreenfootImage("Score: 0", 28, Color.BLACK, null));
    }
    public void bumpCount(int scoré)
    {
        totalCount += scoré;
        setImage(new GreenfootImage("Score: " + totalCount, 28, Color.BLACK, null));
        if (scoré == 1)
        {
        }
    }
}
