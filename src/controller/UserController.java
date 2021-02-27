package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.User;
import service.IUserService;

@Controller
@RequestMapping("/user")

public class UserController extends BaseController
{

	private IUserService userService;

	UserController() {
		this.baseViews = "user/";
	}

	@Autowired(required = true)
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	// Inserimento
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String create(@ModelAttribute User user, Model model) {
		model.addAttribute("model", user);
		return baseViews + "form";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("model") User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return baseViews + "form";
		}

		this.userService.insert(user);

		return "redirect:/user/list";
	}

	// Modifica
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model) {

		User user = this.userService.find(id);

		model.addAttribute("model", user);
		return baseViews + "form";
	}

	// update effettivo
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("model") User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return baseViews + "form";
		}

		this.userService.update(user);

		return "redirect:/user/list";
	}

	// View
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String view(Model model, @PathVariable int id) {
		User user = this.userService.find(id);
		model.addAttribute("model", user);
		return baseViews + "view";
	}

	// Cancellazione
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {

		this.userService.delete(id);
		return "redirect:/user/list";
	}

}
