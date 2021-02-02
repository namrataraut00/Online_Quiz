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
import quiz.dao.UserDao;
import quiz.entity.Exam;
import quiz.entity.Questions;
import quiz.entity.User;
import static testdb.AESAlgorithm.dt;

import static testdb.AESAlgorithm.en;

import java.io.IOException;
import java.security.GeneralSecurityException;
import static testdb.AESAlgorithm.dt;

import static testdb.AESAlgorithm.en;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Controller
@RequestMapping("/user")
public class UserContoller {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ExamDao examdao;

	@GetMapping("/login")
	public String login(Model theModel) {

		User theUser = new User();
		theModel.addAttribute("login", theUser);
		return "user-login";

	}

	@PostMapping("/login")
	public String loginCheck(@RequestParam("email") String email, @RequestParam("password") String password,
			Model theModel, HttpSession hs) throws GeneralSecurityException, IOException {
		System.out.println(en(password));
		User userFound = userDao.validateLogin(email, en(password));
		theModel.addAttribute("login", userFound);

		if (userFound != null) {
			if (userFound.getRole().equalsIgnoreCase("admin")) {
				hs.setAttribute("admin", userFound);

				return "redirect:/exams/list";

			} else {
				hs.setAttribute("user", userFound);
				return "redirect:/user/selectExamlist";
			}

		} else {
			return "user-login";
		}

	}

	@GetMapping("/profileUser")
	public String getProfile(Model theModel, HttpSession hs) {
		if (hs.getAttribute("admin") != null) {
			User admin = (User) hs.getAttribute("admin");
			admin = userDao.getUserByid(admin.getId());
			hs.setAttribute("admin", admin);
			theModel.addAttribute("adminProfile", admin);
			return "adminProfile";
		} else if (hs.getAttribute("user") != null) {
			User user = (User) hs.getAttribute("user");
			user = userDao.getUserByid(user.getId());
			hs.setAttribute("user", user);
			theModel.addAttribute("userProfile", user);
			return "userProfile";
		}
		return "redirect:/user/login";
	}

	@GetMapping("/checkPassword")
	public String checkPassword(Model theModel, HttpSession hs) {
	return "checkPassword";	

	}

	@PostMapping("/checkPassword")
	public String checkPassword(Model theModel, HttpSession hs, String password, String cpassword)
			throws GeneralSecurityException, IOException {
		if (password.equals(cpassword)) {
			if (hs.getAttribute("admin") != null) {

				User admin = (User) hs.getAttribute("admin");
				if (password.equals(admin.getPassword())) {
					return "redirect:/user/changeMail";
				}
				return "redirect:/user/profileUser";
			} else if (hs.getAttribute("user") != null) {
				User user = (User) hs.getAttribute("user");
				if (password.equals(user.getPassword())) {
					return "redirect:/user/changeMail";
				}
				return "redirect:/user/profileUser";
			}
			return "redirect:/user/login";
		}
		return "redirect:/user/login";
	}

	@GetMapping("/checkPassword1")
	public String checkPassword1(Model theModel, HttpSession hs) {
			return "checkPassword1";
	}

	@PostMapping("/checkPassword1")
	public String checkPassword1(Model theModel, HttpSession hs, String password)
			throws GeneralSecurityException, IOException {
			if (hs.getAttribute("admin") != null) {

				User admin = (User) hs.getAttribute("admin");
				if (password.equals(admin.getPassword())) {
					return "redirect:/user/changePassword";
				}
				return "redirect:/user/profileUser";
			} else if (hs.getAttribute("user") != null) {
				User user = (User) hs.getAttribute("user");
				if (password.equals(user.getPassword())) {
					return "redirect:/user/changePassword";
				}
				return "redirect:/user/profileUser";
			}
			
		return "redirect:/user/login";
	}

	@GetMapping("/changeMail")
	public String changeMail() {
		return "changeMail";
	}

	@PostMapping("/changeMail")
	public String changeMail(Model theModel, HttpSession hs, String email) {
		System.out.println(email);
		if (hs.getAttribute("admin") != null) {

			User admin = (User) hs.getAttribute("admin");
			userDao.updateMail(admin.getId(), email);
			return "redirect:/user/profileUser";
		} else if (hs.getAttribute("user") != null) {
			User user = (User) hs.getAttribute("user");
			userDao.updateMail(user.getId(), email);
			return "redirect:/user/profileUser";
		}
		return "redirect:/user/login";
	}

	@GetMapping("/changePassword")
	public String changePassword() {
		return "/changePassword";
	}

	@PostMapping("/changePassword")
	public String changePassword(Model theModel, HttpSession hs, String password, String cpassword)
			throws GeneralSecurityException, IOException {
		// add method to update password
		System.out.println(password);
		if (password.equals(cpassword)) {
			if (hs.getAttribute("admin") != null) {
				User admin = (User) hs.getAttribute("admin");
				System.out.println(en(password));
				userDao.updatePassword(admin.getId(), en(password));
				return "redirect:/user/profileUser";
			} else if (hs.getAttribute("user") != null) {
				User user = (User) hs.getAttribute("user");
				userDao.updatePassword(user.getId(), en(password));
				System.out.println(en(password));
				return "redirect:/user/profileUser";
			}
			return "redirect:/user/login";
		}
		return "redirect:/user/login";

	}

	@GetMapping("/home")
	public String gotoHome(HttpSession hs) {
		if (hs.getAttribute("admin") != null) {
			return "redirect:/exams/list";
		} 
		if(hs.getAttribute("user") != null) {

			return "redirect:/user/selectExamlist";
		}
		return "redirect:/user/login";

	}

	@GetMapping("/selectExamlist")
	public String showuserExamList(Model theModel, HttpSession hs) {
		String message = "NO EXAMS IN LIST";
		List<Exam> examDetails = examdao.getExamList();

		if (examDetails.size() != 0) {
			message = "";
			theModel.addAttribute("examDetails", examDetails);
			Exam exam = new Exam();
			theModel.addAttribute("exam", exam);
			return "exam-to-select";
		} else {
			theModel.addAttribute("message", message);
			return "blankPageMessage";
		}
	}

	@GetMapping("/register")
	public String getregistered() {
		return "registerUser";
	}

	@PostMapping("/register")
	public String getregistered(@RequestParam("email") String email, @RequestParam("name") String name,
			@RequestParam("password") String password, @RequestParam("cpassword") String cpassword, Model theModel)
			throws GeneralSecurityException, IOException {

		if (password.equals(cpassword)) {
			System.out.println(en(password));
			String role = "USER";
			User user = new User(name, email, en(password), role);
			boolean flag = userDao.register(user);
			if (flag) {
				User theUser = new User();
				theModel.addAttribute("login", theUser);
				return "redirect:/user/login";
			} else
				return "/registerUser";

		} else
			return "/registerUser";
	}

	@GetMapping("/logout")
	public String getLoggedOut(HttpSession hs, Model theModel) {

		hs.invalidate();
		User theUser = new User();
		theModel.addAttribute("login", theUser);

		return "redirect:/user/login";
	}

}
