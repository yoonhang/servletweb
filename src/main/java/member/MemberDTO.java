package member;

import java.sql.Date;
//member테이블의 레코드를 객체로 정의
public class MemberDTO {
	private String id;
	private String pass;
	private String name;
	private String addr;
	private Date regDate;
	private int point;
	private String info;
	public MemberDTO() {
		
	}
	//select용
	public MemberDTO(String id, String pass, String name, String addr, Date regDate, int point, String info) {
		this(id, pass, name, addr, info);
		this.regDate = regDate;
		this.point = point;
		
	}
	//update용
	public MemberDTO(String id, String addr, String info) {
		super();
		this.id = id;
		this.addr = addr;
		this.info = info;
	}
	//insert용
	public MemberDTO(String id, String pass, String name, String addr, String info) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.info = info;
	}
	
	
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", addr=" + addr + ", regDate=" + regDate
				+ ", point=" + point + ", info=" + info + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
