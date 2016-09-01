package in.jdsoft.educationmanagement.components;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class BackUpComponent {
	
	static int BUFFER = 10485760;      
	public String getData(String host, String port,    String user, String password, String db) throws Exception {
	Process run = Runtime.getRuntime().exec(
	           "C:\\xampp\\mysql\\bin\\mysqldump --host="  + host + " --port=" + port + 
	           " --user=" + user + " --password=" + password +
	           " --compact --databases --add-drop-table --complete-insert --extended-insert " +
	           "--skip-comments --skip-triggers "+ db);
	InputStream in = run.getInputStream(); 
	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	StringBuffer temp = new StringBuffer();
	int count;
	 char[] cbuf = new char[BUFFER];

	while ((count = br.read(cbuf, 0, BUFFER)) != -1)
	       	 temp.append(cbuf, 0, count);

	 br.close();
	 in.close();

	 return temp.toString();
	}
	public File createFolderIfNotExist(String folderPath){
		File fileDir=new File(folderPath);
		if(!fileDir.exists()){
			fileDir.mkdirs();
		}
		return fileDir;
	}

	public String FileName()
	{
		String filename = "backup.sql";
	    DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    String date = df.format(new Date());
	    date = date.replaceAll("/","");
	    date = date.replaceAll(":","");
	    date = date.replaceAll(" ","");
		return date+filename;
	}
	public String ChangedFileName(String str)
	{
		str = str.replaceAll("[0-9]","");
		return str;
	}
}
