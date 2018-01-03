

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
	public static void main(String[] args)  {
		System.out.println(System.getProperty("line.separator"));
	}
	
	public static void print2File(String fileName,String outData) {
		 File file =new File(fileName);
		 try {
			if(!file.exists()){
				 file.createNewFile();    
			 }
			 
			  FileWriter fileWritter = new FileWriter(file.getName(),true);
			  BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			  bufferWritter.write(outData);
			  bufferWritter.newLine();
			  bufferWritter.close();
			  fileWritter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	
}
