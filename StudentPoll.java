// StudentPoll.java
// Read poll results from a file and output ratings.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.IllegalFormatException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentPoll
{
   public void displayData()
   {
      int[] frequency = new int[11];
      
      Formatter writer = null;
      Scanner pollNumbers = null;
      
      try
      {
         pollNumbers = new Scanner(new File("numbers.txt"));
         
         writer = new Formatter("output.txt");
         
         writer.format("%-12s%-12s\n", "Rating", "Frequency");
         
         //for each answer, use that value as subscript to determine element to increment
         
         while(pollNumbers.hasNext())
            ++frequency[pollNumbers.nextInt()];
            
         //append frequencies to String output
         for(int rating = 1; rating < frequency.length; rating++)
         writer.format("%-12d%-12d\n", rating, frequency[rating]);
      }//end try
      catch(Exception ex)
      {
      System.err.println("Error: Exception");
      }//end catch
      
      if(writer != null)
      writer.close();
      
   }//end displayData
 
} // end class StudentPoll

