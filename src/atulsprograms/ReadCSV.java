package atulsprograms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
	public static void main(String args[]){

		String csvFile = "\\D:\\CORPORATELOAD.csv";
		BufferedReader br = null;
		String line = "";
		String csvSplit = ",";

		try{
			br = new BufferedReader(new FileReader(csvFile));
			while((br.readLine())!=null){
				String[] corpload = line.split(csvSplit);
				System.out.println("Validation :"+corpload[0]+"  "+corpload[1]);

			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(br!=null){
				try{
					br.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
}