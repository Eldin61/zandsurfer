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
        setImage(new GreenfootImage("Score: 0", 20, Color.WHITE, Color.BLACK));
    }
    public void bumpCount(int score)
    {
        totalCount += score;
        setImage(new GreenfootImage("Score: " + totalCount, 20, Color.WHITE, Color.BLACK));
    }
}
