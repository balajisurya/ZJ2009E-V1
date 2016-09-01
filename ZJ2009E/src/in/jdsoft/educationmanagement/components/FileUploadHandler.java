package in.jdsoft.educationmanagement.components;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class FileUploadHandler {
	
	
/*
    private static String SAVE_DIR = "images\\logo";
	String appPath = req.getServletContext().getRealPath("/");
    
    String folderPath = appPath + SAVE_DIR;*/
	
	public File createFolderIfNotExist(String folderPath){
			File fileDir=new File(folderPath);
			if(!fileDir.exists()){
				fileDir.mkdirs();
			}
			return fileDir;
	}
	
	public String uploadFile(byte[] bytes,String location,String path, String fileName) throws IOException{
		BufferedOutputStream  stream=null;
		try {
			
			String changedFileName=Long.toString(System.currentTimeMillis()).concat(fileName);
			String savePath=path+changedFileName;
			File f=createFolderIfNotExist(location);
			File file=new File(f, changedFileName);
			stream = new BufferedOutputStream(new FileOutputStream(file));
			stream.write(bytes);
			return savePath;
		} catch (Exception e) {
			throw e;
		}finally {
			if(stream!=null){
				stream.close();
			}
		}
		
	}
	
	
}
