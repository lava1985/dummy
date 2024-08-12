package dataDriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WritingdataIntoFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("./src/test/resources/data.properties");
		Properties property=new Properties();
		property.load(fis);
		property.put("subject","Selenium");
		property.put("url", "http://localhost:8888/");
		property.put("username", "admin");
		property.put("password","admin");
		FileOutputStream fos=new FileOutputStream("./src/test/resources/data.properties");
		property.store(fos,"susesfully updated");
		
	}

}
