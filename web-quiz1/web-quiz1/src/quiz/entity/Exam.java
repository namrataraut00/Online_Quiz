package quiz.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //cls level annotations : Mandatory
@Table(name = "Exam")

public class Exam {
	
	private Integer examID;
	private String examName;
	private Language language;
	
	private List<Questions> questions=new ArrayList<>();
	public Exam() {
		System.out.println("in Exam constr");
	}

	
	public Exam(String examName, Language language) {
		super();
		this.examName = examName;
		this.language = language;
	}
	public Exam(Integer examID,String examName, Language language) {
		super();
		this.examID=examID;
		this.examName = examName;
		this.language = language;
	}


	@Id //Mandatory : field level OR getter (property level) : PK constraint
	//for automatic ID generation
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment constraint
	@Column(name = "ExamID")
	public Integer getExamID() {
		return examID;
	}
	public void setExamID(Integer ExamID) {
		this.examID = ExamID;
	}
	
	
	@Column(length = 20)
	public String getExamName() {
		return examName;
	}
	public void setExamName(String ExamName) {
		this.examName = ExamName;
	}
	
	@Enumerated(EnumType.STRING)
	public Language getLanguage() {
		return language;
	}


	public void setLanguage(Language language) {
		this.language = language;
	}


	@OneToMany(mappedBy = "exam", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public List<Questions> getQuestions() {
		return questions;
	}


	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}
	
	@Override
	public String toString() {
		return "ExamID:"+examID+" Language:=" + language + ", ExamName=" + examName ;
	}
	
}
