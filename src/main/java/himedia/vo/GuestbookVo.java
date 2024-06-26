package himedia.vo;

import java.util.Date;

public class GuestbookVo {
	
	private Long no;
	private String name;
	private String password;
	private String content;
	private Date regdate;
	
	public GuestbookVo() {
		
	}

	public GuestbookVo(Long no, String name, String password, String content, Date regdate) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.content = content;
		this.regdate = regdate;
	}

	public GuestbookVo(String name, String password, String content) {
		super();
		this.name = name;
		this.password = password;
		this.content = content;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "GuestbookVo [no=" + no + ", name=" + name + ", password=" + password + ", content=" + content
				+ ", regdate=" + regdate + "]";
	}
	
	

}
