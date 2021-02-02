package quiz.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import quiz.dao.ExamDao;
import quiz.dao.QuestionsDao;
import quiz.dao.reportDao;
import quiz.entity.Exam;
import quiz.entity.Questions;
import quiz.entity.Reports;
import quiz.entity.User;

@Controller
@RequestMapping("/questions")
public class QuestionsController {

	@Autowired
	private QuestionsDao questionDao;

	@Autowired
	private ExamDao examdao;
	@Autowired
	private reportDao reportdao;

	@RequestMapping("/list")
	public String listQuestions(Model theModel,int eid) {
		Exam exam=examdao.getExam(eid);
		List<Questions> questions = questionDao.getQuestions(exam);
		String message = "NO Questions IN LIST";

		if (questions.size() != 0) {
			theModel.addAttribute("questions", questions);

			return "list-questions";
		} else {
			theModel.addAttribute("message", message);
			return "blankPageMessage";
		}
	}

	@GetMapping("/add-question-form")
	public String showAddForm(Model theModel, @RequestParam("eid") int examId, HttpSession hs) {

		System.out.println(examId);
		Exam exam=examdao.getExam(examId);
		Questions theQuestion = new Questions();
		theModel.addAttribute("question", theQuestion);
		theModel.addAttribute("exam", exam);
		hs.setAttribute("exam", exam);
		return "add-question-form";

	}

	@PostMapping("/addQuestion")
	public String addQuestion(@ModelAttribute("question") Questions theQuestion,HttpSession hs) {

		System.out.println(theQuestion.toString());
		Exam exam=(Exam)hs.getAttribute("exam");
		theQuestion.setExam(exam);
		System.out.println(theQuestion);
		questionDao.addQuestion(theQuestion);
		return "redirect:/questions/list?eid="+exam.getExamID();

	}

	@GetMapping("/showformforUpdate")
	public String showformforUpdate(@RequestParam("q_id") int theId, Model theModel, HttpSession hs) {

		System.out.println("### " + theId + " ###");
		Questions theQuestion = questionDao.getQuestionforUpdate(theId);
		System.out.println(theQuestion.getExam());
		theModel.addAttribute("question", theQuestion);
		theModel.addAttribute("exam", theQuestion.getExam());

		return "add-question-form";
	}

	@GetMapping("/delete")
	public String deleteQuestion(@RequestParam("q_id") int theId, Model theModel, HttpSession hs) {

		System.out.println(theId);
		questionDao.deleteQuestion(theId);

		return "redirect:/exams/list";

	}

	@GetMapping("/takeQuiz")
	public String TakeQuiz(@RequestParam("eid") int theId, Model theModel, HttpSession hs) {

		System.out.println(theId);
		Exam exam = examdao.getExam(theId);
		hs.setAttribute("exam", exam);
		User u = (User) hs.getAttribute("user");
		List<Reports> listreport = reportdao.getbyExamID(theId);
		for (Reports reports : listreport) {
			if (reports.getEid() == theId && reports.getSid() == u.getId()) {
				String message = "You are no eligibele to give test again,and you scored: " + reports.getMarks();
				theModel.addAttribute("message", message);
				return "result";
			}
		}
		String message = "NO Questions IN LIST";

		List<Questions> questionList = questionDao.getQuestions(exam);
		if (questionList.size() != 0) {
			theModel.addAttribute("exam", exam);

			theModel.addAttribute("qlist", questionList);
			return "display-quiz";
		} else {
			theModel.addAttribute("message", message);
			return "blankPageMessage";
		}

	}

	@GetMapping("/listQuestionsAsExam")
	public String listQuestionsAsExam(@RequestParam("eid") int theId, Model theModel) {

		Exam exam = examdao.getExam(theId);
		List<Questions> questionList = questionDao.getQuestions(exam);
		String message = "NO Questions IN LIST";

		if (questionList.size() != 0) {
			theModel.addAttribute("qlist", questionList);
			return "listQuestionsAsExam";
		} else {
			theModel.addAttribute("message", message);
			return "blankPageMessage";
		}

	}

	@PostMapping("/goBackTolistExam")
	public String goBackTolistExam(Model theModel, @RequestParam("result") String marks, HttpSession hs) {

		System.out.println(marks);
		User u1 = (User) hs.getAttribute("user");
		int sid = u1.getId();
		Exam e1 = (Exam) hs.getAttribute("exam");
		int eid = e1.getExamID();
		char flag = 'T';
		LocalDate date = LocalDate.now();
		reportdao.addEntry(sid, eid, u1.getName(), e1.getExamName(), e1.getLanguage().toString(), marks, date, flag);
		System.out.println("in goBackTolistExam post method");
		return "redirect:/user/selectExamlist";

	}

	@PostMapping("/logout")
	public String logout(Model theModel, @RequestParam("result") String marks, HttpSession hs) {

		System.out.println(marks);
		User u1 = (User) hs.getAttribute("user");
		int sid = u1.getId();
		System.out.println(sid);
		Exam e1 = (Exam) hs.getAttribute("exam");
		int eid = e1.getExamID();
		System.out.println(eid);
		char flag = 'T';
		System.out.println(flag);
		LocalDate date = LocalDate.now();
		System.out.println(date);
		reportdao.addEntry(sid, eid, u1.getName(), e1.getExamName(), e1.getLanguage().toString(), marks, date, flag);
		System.out.println("in logout post method");
		return "redirect:/user/login";

	}

	@GetMapping("/listQuestionsAndAnswerforu")
	public String listQuestionsAndAnswerforu(Model theModel, HttpSession hs, int eid) {
		Exam exam = examdao.getExam(eid);
		List<Questions> listq = questionDao.getQuestions(exam);
		theModel.addAttribute("listq", listq);
		return "listQuestionAnswer";
	}
}
