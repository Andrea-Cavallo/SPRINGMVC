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
import org.springframework.web.bind.annotation.RequestParam;

import exception.EntityNotFoundException;
import model.Studente;
import service.IFrequenzaService;
import service.IStudenteService;

@Controller
@RequestMapping("/studente")
public class StudenteController extends BaseController
{

	private IStudenteService studenteService;

	private IFrequenzaService frequenzaService; //nota questa l avevo messa prima di conoscere Hibernate..

	StudenteController() {
		this.baseViews = "studente/";
	}

	@Autowired(required = true)
	public void setStudenteService(IStudenteService studenteService) {
		this.studenteService = studenteService;
	}

	@Autowired(required = true)
	public void setFrequenzaService(IFrequenzaService frequenzaService) {
		this.frequenzaService = frequenzaService;
	}

	// Inserimento
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String create(@ModelAttribute Studente studente, Model model) {
		model.addAttribute("model", studente);
		return baseViews + "form";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("model") Studente studente, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return baseViews + "form";
		}

		this.studenteService.insert(studente);

		return "redirect:/studente/list";
	}

	// Modifica
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model) {
		Studente studente = this.studenteService.find(id);
		model.addAttribute("model", studente);
		return baseViews + "form";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("model") Studente studente, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return baseViews + "form";
		}

		this.studenteService.update(studente);

		return "redirect:/studente/list";
	}

	// View
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String view(Model model, @PathVariable int id) {
		Studente studente = this.studenteService.find(id);
		model.addAttribute("model", studente);
		return baseViews + "view";
	}

	// Cancellazione
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
//		List<Frequenza> flist = this.frequenzaService.findByIdStudente(id);
//		
//		for (Frequenza f : flist) {
//			this.frequenzaService.delete(f.getIdfrequenza());
//		}

		this.studenteService.delete(id);
		return "redirect:/studente/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Studente> lista = null;
		
			lista = this.studenteService.findAll();
		
		model.addAttribute("models", lista);
		return baseViews + "list";
	}
	


	
	@RequestMapping(value = "/search")
	public String Search(@RequestParam("nomeCercato") String nomeCercato, Model model) {

	    if(nomeCercato != null){
	     List <Studente> lista = null;
			try {
				lista = this.studenteService.findAllByName(nomeCercato);
			} catch (EntityNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        model.addAttribute("model", lista);  
	    }

	    return baseViews + "view";
	}
	
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String list(@RequestParam("cognomeCercato") String cognomeCercato, Model model) {
		
			try {
				List<Studente> lista  = this.studenteService.findAllBySurname(cognomeCercato);
				model.addAttribute("model", lista);
				return baseViews + "view";

			} catch (EntityNotFoundException e) {
				e.printStackTrace();
				return "error/generic_error/";
			}
		
		
	}
	
	

}