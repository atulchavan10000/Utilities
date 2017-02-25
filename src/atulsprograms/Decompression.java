package atulsprograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import javax.xml.bind.DatatypeConverter;

 public class Decompression 
{                
 public static void main(String args[]) throws IOException
 {
  String s = null;
  String path = "C:\\Users\\atul\\Desktop\\compressed.xml";
  
  //read the file and store in a variable in String format
  BufferedReader br = new BufferedReader(new FileReader(path));
  try 
  {
   StringBuilder sb = new StringBuilder();
   String line = br.readLine();
   while (line != null) 
   {
    sb.append(line);
    sb.append("\n");
    line = br.readLine();
   }
   s = sb.toString();
   System.out.println("Read Compressed data");
  }
  finally 
  {
   br.close();
  }
  
  //covert the String data which is received from file to an array of bytes
  byte[] b = DatatypeConverter.parseBase64Binary(s);;
  InputStream in = new ByteArrayInputStream(b);
  ByteArrayOutputStream OutputStream = null;
  byte[] decompressedBytes = null;
  try
  {
   OutputStream = new ByteArrayOutputStream();
   GZIPInputStream gzipStream = null;
   try 
   {
    //create a new input stream with a default buffer size, reads the compressed data in the GZIP file format. This decompresses the data.
    gzipStream = new GZIPInputStream(in);
    byte[] buffer = new byte[16000];
    int len = -1;
    //read uncompressed data into an array of bytes, if len is not zero, the method will block until some input can be decompressed.
    while ((len = gzipStream.read(buffer)) > 0)
    {
     //writes len bytes from the specified byte array starting at offset 0 to this output stream. This writes the decompressed contents in OutputStream
     OutputStream.write(buffer, 0, len);
    }
   }
   catch(Exception e)
   {
    e.printStackTrace();
   }
   finally
   {
    if (gzipStream != null)
    {
     try
     {
      gzipStream.close();
     }
     catch(Exception e)
     {
      e.printStackTrace();
     } 
    }
   }
   decompressedBytes = OutputStream.toByteArray();
  } 
  catch(Exception e)
  {
   e.printStackTrace();
  }
  finally
  {
   if (OutputStream != null)
   {
    try
    {
     OutputStream.close();
    }
    catch(Exception e)
    {
     e.printStackTrace();
    }
   }
  }
  File file = new File(path);
  System.out.println(path);
  if (file.exists())
  {
   file.delete();
  }
  //creates a new file with the same name. Convert the decompressed byte data to String format and writes to the new file.
  if (!file.exists())
  {
   try
   {
    file.createNewFile();
    FileWriter fw = new FileWriter(file.getAbsoluteFile());
    BufferedWriter bw=new BufferedWriter(fw);
    bw.write(new String(decompressedBytes));
    bw.close();
    fw.close();
   }
   catch (IOException e)
   {
    e.printStackTrace();
   }            
  }
 }
}