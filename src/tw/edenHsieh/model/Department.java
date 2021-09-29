package tw.edenHsieh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@Column(name = "DEPTID")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int deptid;
	
	@Column(name = "DEPTNAME") //資料表欄位與屬性名稱相同可省略
	private String deptname;
	
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	
	
}
