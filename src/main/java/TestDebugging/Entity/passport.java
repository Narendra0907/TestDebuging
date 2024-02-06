package TestDebugging.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class passport {

	
	@Id
	@GeneratedValue
	private Integer passpid;
	@Override
	public String toString() {
		return "passport [passpid=" + passpid + ", passnum=" + passnum + ", passloc=" + passloc + ", passdoe=" + passdoe
				+ "]";
	}
	public Integer getPasspid() {
		return passpid;
	}
	public void setPasspid(Integer passpid) {
		this.passpid = passpid;
	}
	public String getPassnum() {
		return passnum;
	}
	public void setPassnum(String passnum) {
		this.passnum = passnum;
	}
	public String getPassloc() {
		return passloc;
	}
	public void setPassloc(String passloc) {
		this.passloc = passloc;
	}
	public String getPassdoe() {
		return passdoe;
	}
	public void setPassdoe(String passdoe) {
		this.passdoe = passdoe;
	}
	private String passnum;
	private String passloc;
	private String passdoe;
}
