
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dina Zeng
 */
public class problem4 {
    ArrayList <ArrayList <String>> arr = new ArrayList <> ();
   
//adds an ArrayList <String> to the ArrayList <ArrayList <String>>, arr
public void addArray(ArrayList <String> array)
{
    arr.add (array); 
}
//loops through then sorts arraylist largest to smallest
public void sortArray()
{
    for (int n = 0; n < arr.size() - 1; n++)
    {
       //if arraylist at index n is smaller than arraylist at index n + 1
       //switch arraylists
        ArrayList<String> temp = arr.get(n);
       if (arr.get (n).size() < arr.get(n+1).size())
           {
               arr.set(n, arr.get(n + 1));
               arr.set( n + 1, temp);
               n = -1;
           }
    }
    //prints results
    printArr(arr);
}
//removes all arraylists that are smaller than int size
//prints/returns results
public void listLength(int size)
{
    for (int n = 0; n < arr.size(); n ++)
    {
        if (arr.get(n).size() < size)
        {
            arr.remove(arr.get(n));
            n--;
        }
    }
    printArr(arr);
}
//adds all arraylists above int size to a new arraylist
//prints/returns results
public ArrayList <ArrayList<String>> listSize (int size)
{
    ArrayList <ArrayList <String>> array = new ArrayList<>();
    for (int n = 0; n < arr.size(); n ++)
    {
        if (arr.get(n).size() > size)
        {
            array.add (arr.get(n));
        }
    }
    printArr (array);
    return array;
}
//prints arraylist
 public static void printArr(ArrayList<ArrayList<String>> array)
    {
        for(ArrayList<String> elem: array)
        {
            System.out.print(elem+ " ");
        }
        System.out.println();
    }
}