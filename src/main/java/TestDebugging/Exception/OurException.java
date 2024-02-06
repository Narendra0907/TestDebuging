package TestDebugging.Exception;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import TestDebugging.Controller.onetoonePersonController;

@ControllerAdvice
public class OurException {

	private static final Logger logger = LoggerFactory.getLogger(OurException.class);

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> comexception(Exception e)
	{
		logger.error(e.getMessage());
		return new ResponseEntity<String>(e.getMessage()+"----custom exception", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<String> reportedSqlException(SQLException ex)
	{
		logger.error("Exception class SqlException Handler method----"+ex);
		
		return new ResponseEntity<String>(ex.getMessage()+"--sql Excpetion",HttpStatus.CONFLICT);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> reportedValidationException(MethodArgumentNotValidException ex)
	{
		logger.error("Exception class reportedValidationException Handler method----"+ex);
			return new ResponseEntity<String>(ex.getMessage()+"--Validation Excpetion",HttpStatus.CONFLICT);
	}
	
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> reportedNullDataException(EmptyResultDataAccessException ex)
	{
		logger.error("Exception class reportedNullDataException Handler method----"+ex);
		
		return new ResponseEntity<String>(ex.getMessage()+"--Null data or No data",HttpStatus.CONFLICT);
	}
}
