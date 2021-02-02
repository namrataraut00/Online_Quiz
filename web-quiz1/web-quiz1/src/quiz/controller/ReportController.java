package quiz.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import quiz.dao.UserDao;
import quiz.dao.reportDao;
import quiz.entity.Reports;
import quiz.entity.User;

@Controller
@RequestMapping("/report")

public class ReportController {
	@Autowired
	private reportDao reportdao;
	@Autowired
	private UserDao userdao;

	@GetMapping("/displayPreviosReportForEid")
	public String listReport(Model theModel, int eid, HttpSession hs) {

		List<Reports> listreport = reportdao.getbyExamID(eid);
		String message = "NO Reports IN LIST";

		if (listreport.size() != 0) {

			theModel.addAttribute("Reports", listreport);
			return "report";
		} else {
			theModel.addAttribute("message", message);
			return "blankPageMessage";
		}

	}


	@GetMapping("/clearAll")
	public String clearReportALL(Model theModel, HttpSession hs) {

		reportdao.clearAll();
		return "redirect:/exams/list";
	}

	@GetMapping("/getTopper")
	public String getTopper(Model theModel, int eid, HttpSession hs) {

		List<Reports> gettopper = reportdao.getTopper(eid);
		String message = "NO Toppers IN LIST";

		if (gettopper.size() != 0) {
			theModel.addAttribute("toppers", gettopper);
			return "TopperList";
		} else {
			theModel.addAttribute("message", message);
			return "blankPageMessage";
		}
	}

	@GetMapping("/viewAllPrev")
	public String getAllPreviousExams(Model theModel, HttpSession hs) {
		if (hs.getAttribute("user") != null) {
			User user = (User) hs.getAttribute("user");
			List<Reports> reports = reportdao.getallExamsForId(user.getId());
			String message = "NO reports IN LIST";

			if (reports.size() != 0) {
				theModel.addAttribute("reports", reports);
				return "viewAllPrev";
			} else {
				theModel.addAttribute("message", message);
				return "blankPageMessage";
			}
		}
		return "viewAllPrev";
	}
}
