import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dina Zeng
 */
public class problem5 {
    //2d array that the player can see/manipulate
    String [][] playerView ={ {" ","1","2","3","4","5","6","7","8","9","10"},
                              {"1","-","-","-","-","-","-","-","-","-","-",},
                              {"2","-","-","-","-","-","-","-","-","-","-",},
                              {"3","-","-","-","-","-","-","-","-","-","-",},
                              {"4","-","-","-","-","-","-","-","-","-","-",},
                              {"5","-","-","-","-","-","-","-","-","-","-",},
                              {"6","-","-","-","-","-","-","-","-","-","-",},
                              {"7","-","-","-","-","-","-","-","-","-","-",},
                              {"8","-","-","-","-","-","-","-","-","-","-",},
                              {"9","-","-","-","-","-","-","-","-","-","-",},
                              {"10","-","-","-","-","-","-","-","-","-","-",}};
    //2d array with the ships 
    String [][] answerKey = {{" ","1","2","3","4","5","6","7","8","9","10"},
                              {"1","-","-","-","-","-","-","-","-","-","-",},
                              {"2","-","-","-","-","-","-","-","-","-","-",},
                              {"3","-","-","-","-","-","-","-","-","-","-",},
                              {"4","-","-","-","-","-","-","-","-","-","-",},
                              {"5","-","-","-","-","-","-","-","-","-","-",},
                              {"6","-","-","-","-","-","-","-","-","-","-",},
                              {"7","-","-","-","-","-","-","-","-","-","-",},
                              {"8","-","-","-","-","-","-","-","-","-","-",},
                              {"9","-","-","-","-","-","-","-","-","-","-",},
                              {"10","-","-","-","-","-","-","-","-","-","-",}};
    Scanner guess = new Scanner (System.in);
    //keeps the coords of the ships that the player guesses correctly
    int[][] correctCoords = new int [14][2];
    int xCoord;
    int yCoord;
    
 //spawns new ships  
public String [][] spawningShips()
{
    //for 5 block ship
    spawnShips (5);

    //for 4 block ship
    spawnShips (4);
    
    //for 3 block ship
    spawnShips (3);
    
    //for 2 block ship
    spawnShips (2);
    //print (answerKey);
    return answerKey;
}
//spawn ships in accordance to desired size
public void spawnShips (int size)
{
    //spawns a random x and y coordinate from 1 to 10
        xCoord = (int) (Math.random()*9) + 1;
        yCoord = (int) (Math.random()*9) + 1;
        
    // if ship is horizontal
    if (horiVerti())
    {       
        //continues to spawn rest of ship in accordance to its size
        for (int n = 0; n < size; n ++)
        {
            //if the ships goes over the limits of the world
            //translates the ship size spaces left
            if (xCoord + size > 10)
            {
                xCoord -= size;
                n = -1;
            }
            //if the ship runs into an existing ship, new x and y coordinates
            //will be generated randomly to move the ship elsewhere on the map
            //deletes what has been spawned already
            //then starts building the ship elsewhere
            else if (answerKey [xCoord + n] [yCoord].equals ("O"))
            {
                for (int r = 1; r <= n; r ++)
                {
                    answerKey [xCoord + n - r] [yCoord] = "-";
                }
                xCoord = (int) (Math.random()*9) + 1;
                yCoord = (int) (Math.random()*9) + 1; 
                n = -1; 
            }
            //if the previous instances can be ignored, ship of size size
            //will be spawned from left to right unless it runs into another ship
            else
            {
            answerKey [xCoord + n] [yCoord] = "O";
            }
        }
    }
    // if ship is vertical
    else
    {
        //continues to spawn rest of ship in accordance to its size
        for (int i = 0; i < size; i ++)
        {
             //if the ships goes over the limits of the world
            //translates the ship size spaces upwards
            if (yCoord + size > 10)
            {
                i = -1;
                yCoord -= size;
            }
            //if the ship runs into an existing ship, new x and y coordinates
            //will be generated randomly to move the ship elsewhere on the map
            //deletes what has been spawned already
            //then starts building the ship elsewhere
            else if (answerKey [xCoord] [yCoord + i].equals ("O"))
            {
                for (int r = 1; r <= i; r ++)
                {
                    answerKey [xCoord] [yCoord + i - r] = "-";
                }
                xCoord = (int) (Math.random()*9) + 1;
                yCoord = (int) (Math.random()*9) + 1; 
                i = -1; 
            }
            //if the previous instances can be ignored, ship of size size
            //will be spawned from top to bottom unless it runs into another ship
            else
            {
            answerKey [xCoord][yCoord + i] = "O";
            }
        }
    }
}
public boolean horiVerti ()
{
    //calls for a random number that is rounded to 0 or 1
    //1 returns true which means the ship will be horizontal
    //otherwise, if the result is 0, then ship will be vertical
    //there is a 12.5% chance that all ships will be vertical or horizontal
    int coinFlip = (int) (Math.random() + 0.5);
    boolean hori = coinFlip == 1;
    return hori;
}

public void playerGuess ()
{
    System.out.println ("Welcome to Battleship!!");
    System.out.println ("X represents a hit while O represents a miss \nGood Luck~!");
    //prints world
    //print (answerKey);
    print (playerView);
    //keeps track of how many guesses player makes
    int counter = 0;
    //once player guesses all ship coords correctly, game ends
    int correctGuess = 0;
    while (correctGuess < 14)
    {
        //asks player to guess a row and column
        System.out.println ("please guess a column");
        int y = guess.nextInt();
        System.out.println ("please guess a row");
        int x = guess.nextInt();
        xCoord = x;
        yCoord = y;
        //if coords guess are out of bounds or have already sunk part of a ship
        //asks player to guess again
        if (!validCoord() || alreadyGuessed())
        {
            System.out.println ("Invalid guess. Please try again.");
            //counter is neutralized to prevent an invalid guess to be added
            //to the counter
            counter--;
        }
        //if player guesses a correct coord, a "X" will replace the dash,
        //which represents a part of a ship has been struck
        //correctGuess counter adds 1 and the coords are added to the 
        //correctCoords array to prevent the coords from being reguessed
        else if (answerKey[x][y].equals ("O"))
        {
            playerView [x][y] = "X";
            correctCoords [correctGuess] [0] = x;
            correctCoords [correctGuess] [1] = y;
            correctGuess++;
        }
        //if player misses, "O" will replace the dash
        else
        {
            playerView [x][y] = "O";
        }
        //increases with every valid guess the player makes
        counter++;
        //prints what the world/player has guessed
        print (playerView);
    }
    //when player finds all the ships
    System.out.println ("Congratulations!");
    System.out.println ("It took " + counter + " guesses to beat the game");
}
//returns false if the player guesses coords that are out of bounds
public boolean validCoord()
{
    boolean valid = xCoord < 11 && yCoord < 11 && xCoord > 0 && yCoord > 0;
    return valid;
}
//to keep the correctGuess counter on tract, boolean returns true if the
//coords (that contain part of the ship) have already been guess before
public boolean alreadyGuessed()
{
     for (int row = 0; row < correctCoords.length; row ++)
     {
         if (xCoord == correctCoords [row][0] && yCoord == correctCoords [row][1])
         {
             return true;
         }
     }
     return false;
}
//prints 2d array
public static void print(String[][] array)
    {
        for(String[] row: array)
        {
            //deletes the extra space after a "10" to make up for extra digit
            //and space loss
            for(String thing: row)
            {
                if (!thing.equals ("10"))
                {
                System.out.print(thing + "  ");
                }
                else
                {
                System.out.print (thing + " ");
                }
            }
            System.out.println();
        }
    }
}
