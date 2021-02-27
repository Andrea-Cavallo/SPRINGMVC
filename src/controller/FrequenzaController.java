package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Frequenza;
import service.IFrequenzaService;

@Controller
@RequestMapping("/frequenza")
public class FrequenzaController extends BaseController
{
	
	private IFrequenzaService frequenzaService;

	FrequenzaController() {
		this.baseViews = "frequenza/";
	}
	@Autowired(required = true)
	public void setFrequenzaService(IFrequenzaService frequenzaService) {
		this.frequenzaService = frequenzaService;
	}

	// Inserimento
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String create(@ModelAttribute Frequenza frequenza, Model model) {
		model.addAttribute("model", frequenza);
		return baseViews + "form";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("model") Frequenza frequenza, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return baseViews + "form";
		}

		this.frequenzaService.insert(frequenza);

		return "redirect:/frequenza/list";
	}

	// Modifica
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model) {
		Frequenza frequenza = this.frequenzaService.find(id);
		model.addAttribute("model", frequenza);
		return baseViews + "form";
	}

	// update effettivo
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("model") Frequenza frequenza, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return baseViews + "form";
		}

		this.frequenzaService.update(frequenza);

		return "redirect:/frequenza/list";
	}

	// View
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String view(Model model, @PathVariable int id) {
		Frequenza frequenza = this.frequenzaService.find(id);
		model.addAttribute("model", frequenza);
		return baseViews + "view";
	}

	// Cancellazione
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {

		this.frequenzaService.delete(id);
		return "redirect:/frequenza/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@PathVariable int id ,Model model) {
		List<Frequenza> lista = this.frequenzaService.findAll();
		model.addAttribute("models", lista);
		return baseViews + "list";
	}

}
