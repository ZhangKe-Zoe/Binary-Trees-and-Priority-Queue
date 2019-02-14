package lab4;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TextReader {
	
	public static String[] readFromFile(String path, String delimiter) {
		String text = "";
		
		Reader reader = null;
		try{
			reader = new FileReader(path);
			for ( int c; ( c = reader.read() ) != -1; ) {
				text += (char) c;
			}
		}
		catch ( IOException e ) {
			System.err.println( "Error reading the file!" );
		}
		finally {
			try { reader.close(); } catch ( Exception e ) { }
		}
		
		return text.split(delimiter);
	}
	
}
