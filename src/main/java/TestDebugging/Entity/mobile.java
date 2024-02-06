package TestDebugging.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class mobile {

	
	
	@Override
	public String toString() {
		return "mobile [mid=" + mid + ", msim=" + msim + ", mnum=" + mnum + "]";
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMsim() {
		return msim;
	}
	public void setMsim(String msim) {
		this.msim = msim;
	}
	public Long getMnum() {
		return mnum;
	}
	public void setMnum(Long mnum) {
		this.mnum = mnum;
	}
	@Id
	@GeneratedValue
	private Integer mid;
	private String msim;
	private Long mnum;

}
