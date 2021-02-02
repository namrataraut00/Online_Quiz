package quiz.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //cls level annotations : Mandatory
@Table(name = "Reports")

public class Reports {
//sid eid marks
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment constraint	
	Integer rid;
	Integer sid;
	String sname;
	String ename;
	String language;
	Integer eid;
	String marks;
	LocalDate testdate;
	char flag;
	
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public char getFlag() {
		return flag;
	}

	public void setFlag(char flag) {
		this.flag = flag;
	}

	
	
	public Reports()
	{
		
	}
	
	
	public Reports(int sid2, int eid2, String marks2, LocalDate date, char flag2,String name,String ename,String lang) {
		this.sid = sid2;
		this.eid = eid2;
		this.marks = marks2;
		testdate=date;
		flag=flag2;
		sname=name;
		this.ename=ename;
		this.language=lang;
	}

	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "Reports [rid=" + rid + ", sid=" + sid + "sname="+sname+", eid=" + eid + ", marks=" + marks + "testDate"+testdate+" falg"+flag;
	}

	public LocalDate getTestdate() {
		return testdate;
	}

	public void setTestdate(LocalDate testdate) {
		this.testdate = testdate;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}
	
	
	
	
	
	
}
