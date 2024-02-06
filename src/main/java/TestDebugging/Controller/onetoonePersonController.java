package TestDebugging.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TestDebugging.Entity.person;
import TestDebugging.Service.ReslationService;



@RestController
@RequestMapping("onetoone")
public class onetoonePersonController {

	@Autowired
	private ReslationService jpa;
	
	private static final Logger logger = LoggerFactory.getLogger(onetoonePersonController.class);
	
	@PostMapping("save")
	public ResponseEntity<person> savedata(@RequestBody person per)
	{
		logger.trace("data received to save data method");
		logger.debug("data received to save data method"+per.toString());
		if(per!=null)
		{
			logger.info("person data not null either we save or update ");
			
		jpa.save(per);
		logger.info("data after the dao operation either we saved or updated succefully ");
		System.out.println("saving the data completed---");
		}else
		{
			logger.warn("submitted does not contain any value ");
			
		}
		
	return new ResponseEntity<person>(per, HttpStatus.CREATED);	
	}
	
	
	@PutMapping("updateperson")
	public ResponseEntity<person> updatedata(@RequestBody person per)
	{
		System.out.println("update the data---"+per);
		jpa.save(per);
		System.out.println("update the data completed---");
		
	return new ResponseEntity<person>(per, HttpStatus.CREATED);	
	}
	
	@GetMapping(value ="getbyid/{pid}", 
			     produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE,
					}
	               		       )
   public ResponseEntity<person> GetById(@PathVariable ("pid") Integer pid)
	{
		System.out.println("getting the data---"+pid);
	Optional<person>  data = 	jpa.findById(pid);
		System.out.println("received the data completed---");
		
	return new ResponseEntity<person>(data.get(), HttpStatus.CREATED);	
	}
	
	
	@DeleteMapping("delebyid/{pid}")
	public ResponseEntity<String> DelById(@PathVariable ("pid") Integer pid)
	{
		System.out.println("deleting the data---"+pid);
		jpa.deleteById(pid);
		System.out.println("received the data completed---");
		
	return new ResponseEntity<String>("data deleted succ", HttpStatus.CREATED);	
	}
	
	
	@GetMapping("getall")
	public ResponseEntity<List<person>> GetAll()
	{
		System.out.println("getting the data---");
	             List<person>  data =       jpa.findAll();
		System.out.println("received the data completed---");
		
	return new ResponseEntity<List<person>>(data, HttpStatus.CREATED);	
	}
	
	@GetMapping("getpdetails/{passnum}")
	public ResponseEntity<List<person>> getpersoninfo(@PathVariable ("passnum") String passnum)
	{
		System.out.println("fetching the query info");
		  List<person> data =   jpa.getPersonDetails(passnum);
		  System.out.println("fetching the query info completed");
		return new ResponseEntity<List<person>>(data, HttpStatus.OK);
	}
	
	
	@GetMapping("getpdepass/{pname}")
	public ResponseEntity<List<person>> getpasportinfo(@PathVariable ("pname") String pname)
	{
		System.out.println("fetching the query info");
		  List<person> data =   jpa.getPassportDetails(pname);
		  System.out.println("fetching the query info completed");
		return new ResponseEntity<List<person>>(data, HttpStatus.OK);
	}
	
	
	@GetMapping("getpdepasssel/{pname}")
	public ResponseEntity<List<Object[]>> getPassportDetailssel(@PathVariable ("pname") String pname)
	{
		System.out.println("fetching the query info");
		  List<Object[]> data =   jpa.getPassportDetailssel(pname);
		  System.out.println("fetching the query info completed");
		  for(Object[]  b : data)
		  {
			  System.out.println(b[0]+"--"+b[1]+"--"+b[2]+"--"+b[3]);
		  }
		  
		return new ResponseEntity<List<Object[]>>(data, HttpStatus.OK);
	}
	
	
	@GetMapping("getMobilinfo/{pname}")
	public ResponseEntity<List<Object[]>> getMobilinfo(@PathVariable ("pname") String pname)
	{
		System.out.println("fetching the query info");
		  List<Object[]> data =   jpa.getMobilinfo(pname);
		  System.out.println("fetching the query info completed");
		  for(Object[]  b : data)
		  {
			  System.out.println(b[0]+"--"+b[1]+"--"+b[2]+"--"+b[3]);
		  }
		  
		return new ResponseEntity<List<Object[]>>(data, HttpStatus.OK);
	}
	
	
	@GetMapping("getallinfo/{pname}")
	public ResponseEntity<List<Object[]>> getallinfo(@PathVariable ("pname") String pname)
	{
		System.out.println("fetching the query info");
		  List<Object[]> data =   jpa.getallinfo(pname);
		  System.out.println("fetching the query info completed");
		  for(Object[]  b : data)
		  {
			  System.out.println(b[0]+"--"+b[1]+"--"+b[2]+"--"+b[3]+"--"+b[4]+"--"+b[5]);
		  }
		  
		return new ResponseEntity<List<Object[]>>(data, HttpStatus.OK);
	}
	
	
	@GetMapping("get/{page}/{size}")
	public ResponseEntity<List<person>> getddata(@PathVariable("page") Integer page,
			                                     @PathVariable("size") Integer size)
	{
		System.out.println("value ---"+page);
		System.out.println("value ---"+size);
		 Pageable pageable = PageRequest.of(page, size);
	      Page<person>  pdata =   jpa.findAll(pageable);
	    List<person> data =	 pdata.toList();
	System.out.println("-----------------------");
	System.out.println(data);
		return new ResponseEntity<List<person>>(data, HttpStatus.ACCEPTED);
		
	}
	
}
