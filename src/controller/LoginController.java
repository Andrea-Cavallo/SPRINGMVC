package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import exception.EntityNotFoundException;
import model.User;
import service.IUserService;

@Controller
@RequestMapping("/area-riservata")
public class LoginController extends BaseController {

	
	private IUserService userService;
	
	LoginController(){
		this.baseViews="area_riservata/";
	}

	@Autowired(required=true)
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	//Home
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(Model model,HttpSession session) {
		return baseViews+"home";
	}
	//Logout
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public void logout(HttpSession session,HttpServletResponse response
			,HttpServletRequest request
			) 
	//HttpServletRequest e HttpServletResponse (e anche ServletRequest e ServletResponse)
	//per accedere direttamente agli oggetti nativi J2EE
	//HttpSession per sfruttare la sessione senza doverla recuperare manualmente dalla request.
	{
		String ctx = request.getContextPath();	
		session.invalidate();
		try {
			response.sendRedirect(ctx+"/area-riservata/login");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Login
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(@ModelAttribute User user,Model model) {
		//Map (o Model) per passare alla view valori dinamici.

		model.addAttribute("model",user);
		
		return baseViews+"login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("model") User user,BindingResult result
			,Model model,
			HttpSession session
			)
	//Errors (o BindingResult) per gestire la validazione dei form.
	{
		if(result.hasErrors()) {
			return baseViews+"login";
		}
		
		
		try {
			User userInDB = this.userService.find(user);
			session.setAttribute("user",userInDB );
			return "redirect:/area-riservata/home";
		} catch (EntityNotFoundException e) {
			model.addAttribute("err","Credenziali non valide");
			
			
		}
		
		return baseViews+"login";
		
		
		
	}
	


	
}