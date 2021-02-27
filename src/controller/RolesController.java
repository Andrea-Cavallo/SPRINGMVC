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

import model.Roles;
import service.IRolesService;


@Controller
@RequestMapping("/roles")
public class RolesController  extends BaseController
{

	private IRolesService rolesService;

	RolesController() {
		this.baseViews = "roles/";
	}

	@Autowired(required = true)
	public void setRolesService(IRolesService rolesService) {
		this.rolesService = rolesService;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String create(@ModelAttribute Roles roles, Model model) {
		model.addAttribute("model", roles);
		return baseViews + "form";
	}
	// Inserimento

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("model") Roles roles, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return baseViews + "form";
		}

		this.rolesService.insert(roles);

		return "redirect:/roles/list";
	}

	// Modifica
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model) {
		Roles roles = this.rolesService.find(id);
		model.addAttribute("model", roles);
		return baseViews + "form";
	}

	// update effettivo
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("model") Roles roles, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return baseViews + "form";
		}

		this.rolesService.update(roles);

		return "redirect:/roles/list";
	}

	// View
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String view(Model model, @PathVariable int id) {
		Roles roles = this.rolesService.find(id);
		model.addAttribute("model", roles);
		return baseViews + "view";
	}

	// Cancellazione
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {

		this.rolesService.delete(id);
		return "redirect:/roles/list";
	}

}
