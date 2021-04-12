/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dina Zeng
 */
public class problem1 {
   
    public problem1 ()
    {
        
    }
    public String[] toString (int n)
    {
        //converts int to String
        String numInt = String.valueOf(n);
        //length of array must be length of string
        String[] stringArray = new String [numInt.length()];
        //loops through int (string) and adds to array
        for (int i = 0; i < numInt.length(); i++)
        {
            //finds the character at index i 
            //then converts to String and added to array
            stringArray [i] = intToString (numInt.charAt(i));
        }
        return stringArray;
    }
    public String intToString (int num)
    {
        // converts character at index n of int (converted to String) to String
        String returnString;
        switch (num) {
            case '1': returnString = "one";
                    break;
            case '2': returnString = "two";
                    break;
            case '3': returnString = "three";
                    break;
            case '4': returnString = "four";
                    break;
            case '5': returnString = "five";
                    break;
            case '6': returnString = "six";
                    break;
            case '7': returnString = "seven";
                    break;
            case '8': returnString = "eight";
                    break;
            case '9': returnString = "nine";
                    break;
            default: returnString = "zero";
                    break;
        }
        return returnString;
    }
    //compares to String arrays
    public boolean inefficientComparer (String[] one, String[] two)
    {
        //only returns true if both array lengths are equal
        if (one.length == two.length)
        {
            //loops through each array and compares each String at index n
            for (int n = 0; n < one.length; n++)
            {
                //if any comparison is false method returns false
                if (!(one [n].equals(two[n])))
                {
                    return false;
                }
            }
            //else returns true
            return true;
        }
        else
        {
            return false;
        }
    }
}
