package TestDebugging.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import TestDebugging.Entity.person;

@Repository
public interface ReslationService extends JpaRepository<person, Integer>{

	
	  @Query("from person p inner join p.pot k where p.pname =:pname") 
	  public abstract List<person> getPassportDetails(String pname);
	 
	
	@Query("from person p inner join p.pot k where k.passnum =:passnum")
	public abstract List<person> getPersonDetails(String passnum);
	
	
	 @Query("select p.pname, p.page, k.passnum, k.passloc from person p inner join p.pot k where p.pname =:pname") 
	  public abstract List<Object[]> getPassportDetailssel(String pname);
	 
	  @Query("select p.pname, p.page, m.msim, m.mnum from person p inner join p.mob m where p.pname =:pname") 
	  public abstract List<Object[]> getMobilinfo(String pname);
	  
	  @Query("select p.pname, p.page, c.cname, c.cfee from person p inner join p.cou c where p.pname =:pname") 
	  public abstract List<Object[]> getCourseinfo(String pname);
	  
	  
	  
	  @Query("select p.pname, p.page, t.passnum, t.passloc, m.msim, m.mnum, c.cname, c.cfee from person p inner join p.cou c  inner join p.pot t inner join p.mob m where p.pname =:pname") 
	  public abstract List<Object[]> getallinfo(String pname);
	 
}
