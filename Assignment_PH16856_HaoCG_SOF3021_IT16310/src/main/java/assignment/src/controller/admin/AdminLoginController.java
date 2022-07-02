package assignment.src.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.apache.bcel.classfile.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import assignment.src.model.entity.Account;
import assignment.src.service.impl.AccountService;
import assignment.src.utility.EncryptUtil;

@Controller
public class AdminLoginController {
	@Autowired
	HttpSession session;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	HttpServletRequest req;
	
	@Autowired
	private JavaMailSender emailSender;
	
	@GetMapping("/logout")
	public ModelAndView logout() {
		session.removeAttribute("account");
		return new ModelAndView("redirect:/home/index");
	}
	
	@GetMapping("/signin")
	public String signIn(ModelMap model) {
		model.addAttribute("account",new Account());
		return "/templates/signin";
	}
		
	@PostMapping("/alogin")
	public ModelAndView login(
			ModelMap model,
			@Validated @ModelAttribute("account")Account acc,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return new ModelAndView("/templates/signin",model);
		}
		
		Account account = accountService.getLogin(acc.getUsername());
		if(account == null) {
			return new ModelAndView("/templates/signin",model);
		}
		
		if(!EncryptUtil.check(acc.getPassword(), account.getPassword())) {
			session.setAttribute("error", "Sai mật khẩu !");
			return new ModelAndView("/templates/signin",model);
		}
		session.setAttribute("message", "");
		session.setAttribute("account", account);
		
		Object ruri = session.getAttribute("redirect-uri");
		if(ruri != null) {
			session.removeAttribute("redirect-uri");
			return new ModelAndView("redirect:" + ruri);
		}
		
		return new ModelAndView("redirect:/home/index");
		
	}
	
	@GetMapping("/signup")
	public String signUp(ModelMap model) {
		model.addAttribute("register",new Account());
		return "/templates/signup";
	}
	
	@PostMapping("/register")
	public ModelAndView register(ModelMap model,@ModelAttribute("register")Account register) {
		if(register.getUsername().length() == 0 || register.getPassword().length() == 0) {
			return new ModelAndView("/templates/signup",model);
		}
		Account account = accountService.findByUsername(register.getUsername());
		if(account != null) {
			return new ModelAndView("/templates/signup",model);
		}
		register.setAccountId(null);
		register.setRole(false);
		accountService.insertAAccount(register);
		return new ModelAndView("redirect:/home/index");
	}
	
	@GetMapping("/change-password")
	public String changePassword(ModelMap model) {
		model.addAttribute("account",(Account)session.getAttribute("account"));
		return "/templates/change-password";
	}
	
	@PostMapping("/change")
	public ModelAndView change(ModelMap model) {
		String oldPassword = (String) req.getParameter("oldpassword");
		String newPassword = (String) req.getParameter("newpassword");
		String confirm = (String) req.getParameter("confirm");
		System.out.println(oldPassword + " - " + newPassword + " - " + confirm);
		Account account = (Account)session.getAttribute("account");
		
		if(account == null){
			return new ModelAndView("redirect:/signin");
		}
		
		if(!EncryptUtil.check(oldPassword,account.getPassword())) {
			session.setAttribute("error", "Mật khẩu cũ không chính xác !");
			model.addAttribute("account",(Account)session.getAttribute("account"));
			return new ModelAndView("/templates/change-password",model);
		}
		if(!newPassword.equalsIgnoreCase(confirm) || newPassword.length() == 0 || confirm.length() == 0) {
			session.setAttribute("error", "Xác nhận mật khẩu mới không chính xác hoặc đã bị để trống!");
			model.addAttribute("account",(Account)session.getAttribute("account"));
			return new ModelAndView("/templates/change-password",model);
		}
		
		session.setAttribute("message", "");
		String encryptedPassword = EncryptUtil.encrypt(confirm);
		account.setPassword(encryptedPassword);
		accountService.updateAccount(account);
		session.removeAttribute("account");
		System.out.println(account.toString());
		return new ModelAndView("redirect:/signin");
	}
	
	@GetMapping("/forgot-password")
	public String forgotPassword() {	
		return "/templates/forgot-password";
	}
	
	@PostMapping("/send-password")
	public ModelAndView sendMail() {
	    // Create a Simple MailMessage.
	    SimpleMailMessage message = new SimpleMailMessage();
	    String sendTo = (String) req.getParameter("usernameToSend");
	    if(sendTo.length()==0) {
	    	session.setAttribute("error", "Đã nhập tài khoản chưa mà gửi");
	    	return new ModelAndView("/templates/forgot-password");
	    }
	    
	    Account account = accountService.findByUsername(sendTo);
	    if(account == null) {
	    	session.setAttribute("error", "Không có thông tin về tài khoản này");
	    	return new ModelAndView("/templates/forgot-password");
	    }
	    
	    session.setAttribute("message", "Đã gửi, kiểm tra email");
	    message.setTo(sendTo);
	    message.setSubject("Here! Being carefully - This is your account in4mation");
	    message.setText("Username: " + account.getUsername() + "\n" + "Password: " + account.getPassword() 
	    + "\n Tuy nhiên có một tin buồn dành cho bạn là bạn phải tự mã hóa ngược chỗi mã hóa này và lấy mật khẩu đăng nhâp hohoho :]");
	
	    // Send Message!
	    this.emailSender.send(message);
	
		return new ModelAndView("/templates/forgot-password");
	}
	
}
