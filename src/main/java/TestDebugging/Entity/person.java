package TestDebugging.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class person {

	@Id
	@GeneratedValue
	private Integer pid;
	private String pname;
	private Integer page;
	private String pqual;
	private Double pmarks;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fkpasspid")
	private passport pot;
	
	@Override
	public String toString() {
		return "person [pid=" + pid + ", pname=" + pname + ", page=" + page + ", pqual=" + pqual + ", pmarks=" + pmarks
				+ ", pot=" + pot + ", mob=" + mob + ", cou=" + cou + "]";
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getPqual() {
		return pqual;
	}

	public void setPqual(String pqual) {
		this.pqual = pqual;
	}

	public Double getPmarks() {
		return pmarks;
	}

	public void setPmarks(Double pmarks) {
		this.pmarks = pmarks;
	}

	public passport getPot() {
		return pot;
	}

	public void setPot(passport pot) {
		this.pot = pot;
	}

	public List<mobile> getMob() {
		return mob;
	}

	public void setMob(List<mobile> mob) {
		this.mob = mob;
	}

	public List<course> getCou() {
		return cou;
	}

	public void setCou(List<course> cou) {
		this.cou = cou;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fkperid")
	private List<mobile> mob;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "joinpercou",
			joinColumns = { @JoinColumn(name = "fkpesid") }, 
			inverseJoinColumns = { @JoinColumn(name = "fkcid") }
			)
	private List<course> cou;
	
}
