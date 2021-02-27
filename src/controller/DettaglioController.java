package controller;

import java.util.ArrayList;
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
import model.Dettaglio;
import model.Studente;
import service.IDettaglioService;

@Controller
@RequestMapping("/dettaglio")
public class DettaglioController extends BaseController {

	private IDettaglioService dettaglioService;

	DettaglioController() {
		this.baseViews = "dettaglio/";
	}

	@Autowired(required = true)
	public void setDettaglioService(IDettaglioService dettaglioService) {
		this.dettaglioService = dettaglioService;
	}

	// Inserimento
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String create(@ModelAttribute Dettaglio dettaglio, Model model) {
		model.addAttribute("model", dettaglio);
		return baseViews + "form";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("model") Dettaglio dettaglio, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return baseViews + "form";
		}

		this.dettaglioService.insert(dettaglio);

		return "redirect:/dettaglio/list";
	}

	// Modifica
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model) {
		Dettaglio dettaglio = this.dettaglioService.find(id);
		model.addAttribute("model", dettaglio);
		return baseViews + "form";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("model") Dettaglio dettaglio, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return baseViews + "form";
		}

		this.dettaglioService.update(dettaglio);

		return "redirect:/dettaglio/list";
	}

	// View
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String view(Model model, @PathVariable int id) {
		Dettaglio dettaglio = this.dettaglioService.find(id);

//		System.out.println(dettaglio.getCitta());
System.out.println("sto dentro al view di Dettaglio");



		model.addAttribute("model", dettaglio);

	
		return baseViews + "view";
	}

	// Cancellazione
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {

		this.dettaglioService.delete(id);
		return "redirect:/dettaglio/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Dettaglio> lista = null;

		lista = this.dettaglioService.findAll();

		model.addAttribute("models", lista);
		return baseViews + "list";
	}

}
