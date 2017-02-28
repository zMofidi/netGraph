package netGraph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.sql.SQLException;


public class Main {
	public static void main(String[] args) {
		
		try {
			
			loadPages_toDB();
			
			
			
			
			
		} catch (IOException e) {
			System.out.println("ioException: "+e.getMessage());
		}
		
	}//end of main
	/****************************************************************/
	static void loadPages_toDB() throws IOException{
		File dir = new File(".//.//data");
		  File[] directoryListing = dir.listFiles();
		  
		    for (File child : directoryListing) {
		    	FileReader fr = new FileReader(child.getAbsolutePath());
				BufferedReader bf = new BufferedReader(fr);
				String line,total=null;
				String [] fileData;
				for(int lineCounter = 0; lineCounter<5; lineCounter++){
					line=bf.readLine();
					total+=line;
					total+="$";
				}
				fileData= total.split("$");
				Entity_Manager em = new Entity_Manager();
				try {
					
					em.loadPages_toDB(fileData);
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fr.close();
				bf.close();
		    }
	}

}
