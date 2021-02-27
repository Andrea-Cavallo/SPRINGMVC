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

import model.Corsi;
import service.ICorsiService;

@Controller //Da utilizzare a livello di classe per identificarla come controller
@RequestMapping("/corsi") //Da utilizzare per evidenziare il metodo e l’url da mappare
public class CorsiController extends BaseController {
	private ICorsiService corsiService;

	CorsiController() {
		this.baseViews = "corsi/";
	}

	@Autowired(required = true)
	public void setCorsiService(ICorsiService corsiService) {
		this.corsiService = corsiService;
	}

	//aratteristica vincente dei Controller di Spring MVC riguarda la possibilità 
	//di personalizzare a proprio piacimento la signature del metodo
	//(ovvero il numero e il tipo di parametri accettati e il tipo di dato ritornato). 
	
	
	// Inserimento
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String create(@ModelAttribute Corsi corsi, Model model) {
		model.addAttribute("model", corsi);
		return baseViews + "form";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("model") Corsi corsi, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return baseViews + "form";
		}

		this.corsiService.insert(corsi);

		return "redirect:/corsi/list";
	}

	// Modifica
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model) {
		//Parametri annotati con @PathVariable recuperati dal pattern.

		
		Corsi corsi = this.corsiService.find(id);
		model.addAttribute("model", corsi);
		return baseViews + "form";
	}

	// update effettivo
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("model") Corsi corsi, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return baseViews + "form";
		}

		this.corsiService.update(corsi);

		return "redirect:/corsi/list";
	}

	// View
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String view(Model model, @PathVariable int id) {
		Corsi corsi = this.corsiService.find(id);
		model.addAttribute("model", corsi);
		return baseViews + "view";
	}

	// Cancellazione
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {

		this.corsiService.delete(id);
		return "redirect:/corsi/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Corsi> lista = this.corsiService.findAll();
		model.addAttribute("models", lista);
		return baseViews + "list";
	}

}
