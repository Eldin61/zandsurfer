import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class game3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class game3 extends World
{
    private int spawnX = 0;
    private int spawnX2 = 0;
    private int spawnCounter = 0;
    private int spawnTreasure = 0;
    /**
     * Constructor for objects of class game3.
     * 
     */
    public game3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 900, 1); 

        prepare();
    }
    private Counter theCounter;
    public Counter getCounter()
    {
        return theCounter;
    }
    public void act()
    {
        addObjects();
    }
    
    private void prepare()
    {
        Boat boat = new Boat();
        addObject(boat, 409, 797);
        boat.setLocation(464, 791);
        boat.setLocation(453, 765);
        theCounter = new Counter();
        addObject(theCounter, 810, 20);
    }

    public void addObjects()
    {
        spawnCounter++;
        spawnTreasure++;
        spawnX = Greenfoot.getRandomNumber(900);
        spawnX2 = Greenfoot.getRandomNumber(900);
        if (spawnCounter == 150)
        {
            Rock rock = new Rock();
            Rock rock2 = new Rock();
            addObject(rock, spawnX, 0);
            addObject(rock2, spawnX2, 0);
            spawnCounter = 0;
            spawnX = 0;
            spawnX2 = 0;          
        }
        if(spawnTreasure == 310)
        {
            Schat schat = new Schat();
            addObject(schat, spawnX, 0);
            spawnX = 0;
            spawnTreasure = 0;
        }
    }
}
