package quiz.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import quiz.dao.ExamDao;
import quiz.entity.Exam;
import quiz.entity.Language;

@Controller
@RequestMapping("/exams")
public class ExamController {
	@Autowired
	private ExamDao examdao;

	@GetMapping("/list")
	public String listExams(Model theModel, HttpSession hs) {

		List<Exam> examDetails = examdao.getExamList();
		String message = "NO EXAMS IN LIST";

		if (examDetails.size() != 0) {
			theModel.addAttribute("examDetails", examDetails);
			Exam exam = new Exam();
			theModel.addAttribute("exam", exam);
			return "list-exams";
		} else {
			theModel.addAttribute("message", message);
			return "blankPageMessage";
		}

	}

	@PostMapping("/list")
	public String forwardToQuestionPage(@RequestParam("examId") int examId, Model themodel) {
		System.out.println(" forwarding eid to question page");
		themodel.addAttribute("examId", examId);
		return "redirect:/questions/add-question-form";
	}

	@GetMapping("/addExam")
	public String addExam(HttpSession hs) {

		return "/addexam";

	}

	@PostMapping("/addExam")
	public String addExam(HttpSession hs, Model theModel, @RequestParam("examName") String ename,
			@RequestParam("examLanguage") String language, Model themodel) {

		Language lang = Language.valueOf(language.toUpperCase());
		Exam exam = new Exam(ename, lang);

		if (examdao.addExam(exam)) {
			String message = "exam added successfully";
			theModel.addAttribute("message", message);

			return "redirect:/exams/list";
		}
		return "/exams/addexam";

	}

	@PostMapping("/updateExam")
	public String updateExam(HttpSession hs, Model theModel, @RequestParam("examID") Integer examID,
			@RequestParam("examName") String ename, @RequestParam("examLanguage") String language, Model themodel) {

		Language lang = Language.valueOf(language.toUpperCase());

		Exam exam = new Exam(examID, ename, lang);
		System.out.println(exam);
		if (examdao.UpdateExam(exam)) {
			String message = "exam details for selected exam updated";
			theModel.addAttribute("message", message);

			return "redirect:/exams/list";
		}
		return "/exams/addexam";

	}

	// update and delete exam
	@GetMapping("/showformforUpdate")
	public String showformforUpdate(HttpSession hs, @RequestParam("eid") int theId, Model theModel) {

		System.out.println("### " + theId + " ###");
		Exam exam = examdao.getExamforUpdate(theId);
		theModel.addAttribute("exam", exam);
		return "/updateexam";

	}

	@GetMapping("/delete")
	public String deleteQuestion(HttpSession hs, @RequestParam("eid") int theId, Model theModel) {
		if(examdao.deleteExam(theId))
		{
			return "redirect:/exams/list";
	
		}
		else
		{
			theModel.addAttribute("mesg", "there are questions in exam, exam cant be deleted");
			return "blankPageMessage";
		}

		
	}

}
