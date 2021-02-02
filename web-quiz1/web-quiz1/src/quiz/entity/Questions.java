package quiz.entity;

import javax.persistence.*;
@Entity
@Table(name = "Questions")
public class Questions {

	public Questions() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "que_id")
	private int q_id;
	
	@Column(name = "que_text")
	private String q_text;
	
	@Column(name = "que_optA")
	private String q_optA;
	
	@Column(name = "que_optB")
	private String q_optB;
	
	@Column(name = "que_optC")
	private String q_optC;
	
	@Column(name = "que_optD")
	private String q_optD;
	
	@Column(name = "que_anwer")
	private String q_answer;

	@ManyToOne //mandatory : if not supplied hibernate throws MappingExc.
	@JoinColumn(name = "e_id",nullable = false)
	private Exam exam;
	

	public Questions( String q_text, String q_optA, String q_optB, String q_optC, String q_optD,
			String q_answer,Exam exam) {
		super();
		this.q_text = q_text;
		this.q_optA = q_optA;
		this.q_optB = q_optB;
		this.q_optC = q_optC;
		this.q_optD = q_optD;
		this.q_answer = q_answer;
		this.exam=exam;
	}

	public int getQ_id() {
		return q_id;
	}

	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}

	public String getQ_text() {
		return q_text;
	}

	public void setQ_text(String q_text) {
		this.q_text = q_text;
	}

	public String getQ_optA() {
		return q_optA;
	}

	public void setQ_optA(String q_optA) {
		this.q_optA = q_optA;
	}

	public String getQ_optB() {
		return q_optB;
	}

	public void setQ_optB(String q_optB) {
		this.q_optB = q_optB;
	}

	public String getQ_optC() {
		return q_optC;
	}

	public void setQ_optC(String q_optC) {
		this.q_optC = q_optC;
	}

	public String getQ_optD() {
		return q_optD;
	}

	public void setQ_optD(String q_optD) {
		this.q_optD = q_optD;
	}

	public String getQ_answer() {
		return q_answer;
	}

	public void setQ_answer(String q_answer) {
		this.q_answer = q_answer;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	@Override
	public String toString() {
		return "Questions [q_id=" + q_id + ", q_text=" + q_text + ", q_optA=" + q_optA + ", q_optB=" + q_optB
				+ ", q_optC=" + q_optC + ", q_optD=" + q_optD + ", q_answer=" + q_answer + "Exam=" + exam +"]";
	}
		
}
