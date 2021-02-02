package quiz.dao;

import java.util.List;

import quiz.entity.Exam;
import quiz.entity.Questions;

public interface ExamDao {

	public List<Exam> getExamList();
	public Exam getExam(int eid);
	public boolean addExam(Exam exam);
	public boolean deleteExam(int eid);
	public Exam getExamforUpdate(int theId);
	public boolean UpdateExam(Exam exam);
}
