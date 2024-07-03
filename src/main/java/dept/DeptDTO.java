package dept;

public class DeptDTO {
	private String deptno;
	private String deptname;
	private String tel;
	private String addr;
	public DeptDTO() {
		
	}
	public DeptDTO(String deptno, String deptname, String tel, String addr) {
		super();
		this.deptno = deptno;
		this.deptname = deptname;
		this.tel = tel;
		this.addr = addr;
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "DeptDTO [deptno=" + deptno + ", deptname=" + deptname + ", tel=" + tel + ", addr=" + addr + "]";
	}
	
}
