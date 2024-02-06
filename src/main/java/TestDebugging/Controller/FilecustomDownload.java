package TestDebugging.Controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fdow")
public class FilecustomDownload {
	
	
	@GetMapping("download/{filename}")
	public ResponseEntity<Resource> downloadthedata(@PathVariable ("filename") String filename)
	{
		System.out.println("download Operation started");
		String folder = "C:\\Users\\Public\\";
		String fpath  = folder+filename;
		FileSystemResource s = new FileSystemResource(fpath);
		
		HttpHeaders n = new HttpHeaders();
	    n.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		n.setContentDispositionFormData("attachment", filename);
	
		
		System.out.println("download Operation completed");
		return new ResponseEntity<Resource>(s, n, HttpStatus.OK);
	}

}
