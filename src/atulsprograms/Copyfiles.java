package atulsprograms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


public class Copyfiles
{
	public static void main(String args[])
	{
	   try
	   {
		   File srcFolder = new File("\\D:\\srcfolder");
		   File destFolder = new File("\\D:\\destfolder");
		   if(srcFolder.isDirectory());
		   { 
			   // dest.delete();
			   //if directory not exists, create it
			   if(!destFolder.exists())
			   {
				   destFolder.mkdir();
			   }
			   
			   //list all the directory contents
			   String[] files = srcFolder.list();
			   for (String file : files)
			   {
				   //construct the srcFolder and destFolder file structure
				   File srcFolderFile = new File(srcFolder, file);
				   File destFolderFile = new File(destFolder, file);
				   
				   InputStream in = new FileInputStream(srcFolderFile);
				   OutputStream out = new FileOutputStream(destFolderFile);
	  
				   byte[] buffer = new byte[1024];
				   int length;
	                       
				   //copy the file content in byte buffer 
				   while ((length = in.read(buffer)) > 0)
				   {
					   out.write(buffer, 0, length);
				   }

				   in.close();
				   out.close();
			   	}
	          }
	       }catch(Exception e)
	       {
	    	   e.printStackTrace();
	       }
	}	
}
	 
