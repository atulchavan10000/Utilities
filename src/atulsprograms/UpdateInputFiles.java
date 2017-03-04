package atulsprograms;

import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class UpdateInputFiles
{
   public static void main(String args[])
   {
      try
     {              
          File file = new File("\\D:\\destfolder");
      
          //create an array of file to store all the file references in a directory
          File[] filelist = file.listFiles();
          String line = null;
          String newtext;
          String oldtext = "";
        
          //iterate through each file in the directory,
          for(File file1 : filelist )
          {
                BufferedReader reader = new BufferedReader(new FileReader(file1));
                //get each line from the particular file
                //and copy all the text to a string variable line by line
                while((line = reader.readLine()) != null)
               {
                    oldtext += line + "\r\n";
               }
               reader.close();            
               String str = "#####";

               //this will search the annoted text "@@ReplaceText@@"
               //and replace Annoted text from oldtext with "#####"
               //and assign the modified text to another variable

               newtext = oldtext.replaceAll("@@ReplaceText@@", str);
               FileWriter writer = new FileWriter(file1);
               writer.write(newtext);
               writer.close();
          }
     }
     catch (IOException ioe)
    {
          ioe.printStackTrace();
    }
  }
}