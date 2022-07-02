package assignment.src.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import assignment.src.model.entity.Account;
import assignment.src.service.IAccountService;

@Controller
@RequestMapping("admin")
public class AccountController {
	@Autowired
	private IAccountService accountService;
	
	@GetMapping("account")
	public String allAccount(Model model) {
		model.addAttribute("lstAccount",accountService.getAllAccount());
		return "/templates/admin/account";
	}
	
	@GetMapping("account-creator")
	public String createForm(ModelMap model) {
		model.addAttribute("account",new Account());
		return "/templates/admin/account-creator";
	}
	
	@PostMapping("account/store")
	public ModelAndView storeAccount(ModelMap model,
			@ModelAttribute("account")Account account) {
		if(account.getUsername().length() == 0 || account.getPassword().length() == 0) {
			return new ModelAndView("/templates/admin/account-creator",model);
		}
		Account acc = accountService.findByUsername(account.getUsername());
		if(acc != null) {
			return new ModelAndView("/templates/admin/account-creator",model);
		}
		account.setAccountId(null);
		System.out.println(account.toString());
		accountService.insertAAccount(account);
		
		return new ModelAndView("redirect:/admin/account");
	}
	
	@GetMapping("account/delete/{id}")
	public String deleteById(@PathVariable("id")Long id) {
		accountService.deleteAAccountById(id);
		return "redirect:/admin/account";
	}
	
	@GetMapping("account/{role}/{id}")
	public String updateRoleById(
			@PathVariable("role")boolean role,
			@PathVariable("id")Long id) {
		accountService.updateRoleById(role,id);
		return "redirect:/admin/account";
	}
}
