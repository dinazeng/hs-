/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dina Zeng
 */
public class problem2 {
    public String [] addElement (String [] arr, int index, String addString)
    {
        String[] newArray = new String [arr.length + 1];
        //loops from start of arr to one index before the index 
        //that the string will be added at
        for (int n = 0; n < arr.length - (arr.length - index); n++)
        {
            newArray [n] = arr [n];
            System.out.println (newArray [n]);
        }
        //adds the desired string to the new array
            newArray [index] = addString;
            System.out.println (newArray [index]);
        //loops from one index after the added string to the end
        for (int i = index + 1; i < arr.length + 1; i ++)
        {
            newArray [i] = arr [i - 1];
            System.out.println (newArray [i]);
        }
        return newArray;
    }
    public String [] removeElement (String [] arr, int index)
    {
        String[] newArray = new String [arr.length - 1];
        //loops from start of arr to one index before the index 
        //that will be removed
        for (int n = 0; n < arr.length - (arr.length - index); n++)
        {
            newArray [n] = arr[n];
            System.out.println (newArray [n]);
        }
        //skips the removed index and continues until the end of initial array
        for (int i = index; i < arr.length - 1; i ++)
        {
            newArray [i] = arr [i + 1];
            System.out.println (newArray [i]);
        }
        return newArray;
    }
    
    public String [] replaceAll (String [] arr, String remove, String replaceWith)
    {
       String[] newArray = new String [arr.length];
       //loops through array to find string that will be removed and replaced
       for (int n = 0; n < arr.length; n ++)
       {
           // if the unwanted String is found the new array will be set
           //with the replacement string
           if (arr[n].equals(remove))
           {
               newArray [n] = replaceWith;
               System.out.println (newArray [n]);
           }
           //otherwise the new array is set with the initial array value
           else 
           {
               newArray [n] = arr [n];
               System.out.println (newArray [n]);
           }
       }
       return newArray;   
    }
    public String[] removeAll (String [] arr, String remove )
    {
        //loops through initial array and counts the number of times 
        //the unwatned String appears
        int removeCounter = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr [i].equals (remove))
            {
               removeCounter ++;
            }
        }
        //the new array will be initilized with a length thats x smaller
        //than the inital array in accordance to how many times the
        //unwanted string appears
        String[] newArray = new String [arr.length - removeCounter];
        int numRemove = 0;
        //loops through initial array
        for (int n = 0; n < arr.length; n ++)
       {
           //when the value of the initial array at index n is 
           //the unwanted string it increases a counter that will help with
           //managing the indexes of the new array
           if (arr[n].equals(remove))
           {
               numRemove++;
           }
           //when value is acceptable, the newArray at index xvalues smaller
           //(in accordance with how many times the unwanted String has appeared)
           //is set as the initial array at index n
           else
           {
               newArray [n - numRemove] = arr [n];
               System.out.println (newArray [n - numRemove]);
           }
       }
        return newArray;
    }
}
