package quiz.dao;

import java.util.List;

import quiz.entity.Exam;
import quiz.entity.Questions;

public interface QuestionsDao {

	public List<Questions> getQuestions();
	public Questions getQuestionforUpdate(int theId);
	public void addQuestion(Questions theQuestion);
	public void deleteQuestion(int theId);
	public List<Questions> getQuestions(Exam exam);
	
}
