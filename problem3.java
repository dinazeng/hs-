
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
public class problem3 {
    //new ArrayLists
    ArrayList<Integer> arr = new ArrayList<Integer>();
    ArrayList<String> array = new ArrayList<String>();
    
    public ArrayList orderedInt (int num)
    {
        //add int to arraylist
        arr.add (num);
        //loops and sorts arraylist
        for (int n = 0; n < arr.size()-1; n++)
       {
           int temp = arr.get (n + 1);
           //compares int at index n and n + 1 to determine the larger int
           //switches them if int at index n is larger than int at index n + 1
           if (arr.get (n) > arr.get(n+1))
           {
               arr.add(n, temp);
               arr.remove( n + 2);
               n = -1;
           }
       }
        printArr(arr);
         return arr;
    }
    public ArrayList orderedString (String str)
    {
        //adds string to arraylist
        array.add (str);
        
        //loops and sorts arrayList
        for (int n = 0; n < array.size()-1; n++)
       {
           String temp = array.get (n + 1);
            //compares String at index n and n + 1 to determine the larger String
           //switches them if String at index n is larger than String at index n + 1
           if (array.get (n).compareTo(array.get(n + 1)) > 0)
           {
               array.add(n, temp);
               array.remove( n + 2);
               n = -1;
           }
       }
        printArray(array);
         return array;
    }
    //prints arraylist <String>
     public static void printArray(ArrayList<String> array)
    {
        for(String elem: array)
        {
            System.out.print(elem+ " ");
        }
        System.out.println();
    }
     //prints arraylist <Integer>
        public static void printArr(ArrayList<Integer> array)
    {
        for(Integer elem: array)
        {
            System.out.print(elem+ " ");
        }
        System.out.println();
    }
    }
