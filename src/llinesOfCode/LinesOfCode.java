package llinesOfCode;

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class LinesOfCode {
	public static void main(String[] args) throws FileNotFoundException {
		
		File selectedFile = null;
		int countOfStatements = 0;
		int countOfLines= 0;
		
		//https://www.mkyong.com/swing/java-swing-jfilechooser-example/ 
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			selectedFile = jfc.getSelectedFile();
		}
		//https://www.mkyong.com/swing/java-swing-jfilechooser-example/
		
		BufferedReader br = new BufferedReader(new FileReader(selectedFile));  
		String line = null;  
		
		try {
			while ((line = br.readLine()) != null)  
			{  
				countOfLines++;
			   if(line.endsWith(";"))
				   countOfStatements++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error with reading file.");
		}
		
		System.out.println("You have " + countOfStatements + " lines of statements.\nYou have " + countOfLines + " lines of code.");
	}
	
}

