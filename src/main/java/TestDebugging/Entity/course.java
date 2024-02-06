package TestDebugging.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class course {

	
	@Id
	@GeneratedValue
	private Integer cid;
	@Override
	public String toString() {
		return "course [cid=" + cid + ", cname=" + cname + ", cduar=" + cduar + ", cfee=" + cfee + "]";
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Integer getCduar() {
		return cduar;
	}
	public void setCduar(Integer cduar) {
		this.cduar = cduar;
	}
	public Double getCfee() {
		return cfee;
	}
	public void setCfee(Double cfee) {
		this.cfee = cfee;
	}
	private String cname;
	private Integer cduar;
	private Double cfee;
}
