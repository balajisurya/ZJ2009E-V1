package in.jdsoft.educationmanagement.school.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.jdsoft.educationmanagement.components.BackUpComponent;
import in.jdsoft.educationmanagement.school.model.Message;


@Controller
@RequestMapping("/BackupAndRestore")
public class BackupAndRestoreController {

	
	@Autowired
	BackUpComponent backUpComponent;
	@Autowired
	BasicDataSource basicDataSource;
	
	@RequestMapping
	public ModelAndView displayBackupAndRestore(HttpServletRequest request){
		try {
			if(request.getSession().getAttribute("authenticated")!=null && request.getSession().getAttribute("authenticated").equals("true")){
				ModelAndView modelandview=new ModelAndView("backupandrestore");
				return modelandview;
			}
			else{
				return new ModelAndView("redirect:/");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value="backup",method=RequestMethod.POST)
	public String Backup(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception{
		BufferedOutputStream  stream=null;
		try {
			
				byte[] data = backUpComponent.getData("localhost", "3306",basicDataSource.getUsername(), basicDataSource.getPassword(), "edumaat_db").getBytes();
				File f=backUpComponent.createFolderIfNotExist(request.getRealPath("/resources/backup/"));
				File file=new File(f,backUpComponent.FileName());
				stream = new BufferedOutputStream(new FileOutputStream(file));
				stream.write(data);
				stream.close();
				redirectAttributes.addFlashAttribute("errorMessage", new Message("success", "BackUp Done"));
				return "redirect:/BackupAndRestore";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
	@RequestMapping(value="restore",method=RequestMethod.POST)
	public String Restore(HttpServletRequest request,@RequestParam("restorefile") MultipartFile multipartFile) throws Exception{
		
		try {
			
	
			String str=multipartFile.getOriginalFilename();
			str = str.replaceAll("[0-9]","");
			try {
			String[] cmd = new String[]{"C:\\xampp\\mysql\\bin\\mysql",
			"edumaat_db",
			"--user=" + "edumaat",
			"--password=" + "edumaat",
			"-e",
			"\"source " + str+ "\""

			};
			
			Process proc = Runtime.getRuntime().exec(cmd);
			
			if (true) {
			InputStream inputstream = proc.getInputStream();
			InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
			BufferedReader bufferedreader = new BufferedReader(inputstreamreader);

			// read the output
			String line;
			while ((line = bufferedreader.readLine()) != null) {				
			System.out.println(line);
			}

			// check for failure
			try {
			if (proc.waitFor() != 0) {
			System.err.println("exit value = " +	proc.exitValue());
			}
			}
			catch (InterruptedException e) {
			System.err.println(e);
			throw e;
			}
			}
			} catch (Exception e) {
			e.printStackTrace();
			throw e;
			}
		
			 return "redirect:/BackupAndRestore";
	
	} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
}
