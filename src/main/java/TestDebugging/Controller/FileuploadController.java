package TestDebugging.Controller;

import java.io.File;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("fileupload")
public class FileuploadController {

	@PostMapping("savefile")
	public void Fileupload(@RequestParam("mpf")  MultipartFile mpf) throws Exception
	{
	
		System.out.println("File uploaded done----");
		System.out.println(mpf.getContentType());
		System.out.println(mpf.getName());
		System.out.println(mpf.getSize());
		System.out.println(mpf.getOriginalFilename());
		
		
		  String path = "C:\\Users\\Public\\"+mpf.getOriginalFilename(); 
		  File f = new File(path); 
		  mpf.transferTo(f);
		 
		
	}
	
}
