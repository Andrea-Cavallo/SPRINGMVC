package controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import model.Docente;
import service.ICorsiService;
import service.IDocenteService;

@Controller
@RequestMapping("/docente")
public class DocenteController  extends BaseController {
	private IDocenteService docenteService;
	private ICorsiService corsiService;


	DocenteController(){
		this.baseViews="docente/";
	}

	@Autowired(required = true)
	public void setDocenteService(IDocenteService docenteService) {
		this.docenteService = docenteService;
	}

	@Autowired(required = true)
	public void setCorsiService(ICorsiService corsiService) {
		this.corsiService = corsiService;
	}

	// Inserimento
	//ecessari due step: visualizzazione del form e raccolta dati, 
	//il miglior modo è quello di mantenere una URL unica per le azioni,
	//differenziandone i metodi HTTP e ovviamente i metodi Java.
	// in questo caso ho utilizzato le hashmap 
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String create(@ModelAttribute Docente docente, Model model) {
		HashMap<Integer, String> ls = new HashMap<Integer, String>();

		List<Corsi> listaCorsi = corsiService.findAll();
		for (Corsi i : listaCorsi) {
			ls.put(i.getIdcorsi(), i.getNomecorso());
		} // ho la lista corsi popolati
		model.addAttribute("listacorsi", ls);

		model.addAttribute("model", docente);
		return baseViews + "form";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("model") Docente docente, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return baseViews + "form";
		}

		this.docenteService.insert(docente);

		return "redirect:/docente/list";
	}

	//metodo POST i parametri verranno iniettati dentro l’oggetto grazie ad 
	//un’operazione di binding.
	//Il termine binding può essere tradotto come legame o attacco e rappresenta 
	//l’operazione, svolta da Spring MVC, di conversione da parametri HTTP (che principalmente sono stringhe) in oggetti composti e definiti dall’utente. Per la maggior parte dei casi le operazioni di binding già presenti in Spring MVC sono più che sufficienti,
	//ma in caso contrario sarà possibile definirne dei propri



	// Modifica
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model) {
		HashMap<Integer, String> ls = new HashMap<Integer, String>();

		List<Corsi> listaCorsi = corsiService.findAll();
		for (Corsi i : listaCorsi) {
			ls.put(i.getIdcorsi(), i.getNomecorso());
		} // ho la lista corsi popolati
		model.addAttribute("listacorsi", ls);
		Docente docente = this.docenteService.find(id);
		model.addAttribute("model", docente);
		return baseViews + "form";
	}

	// update effettivo
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("model") Docente docente, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return baseViews + "form";
		}

		this.docenteService.update(docente);

		return "redirect:/docente/list";
	}

	// View
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String view(Model model, @PathVariable int id) {
		//Model is used to pass data between 
		//controllers and views
		Docente docente = this.docenteService.find(id);
		model.addAttribute("model", docente);//attribute name, value
		return baseViews + "view";
	}

	// Cancellazione
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {

		this.docenteService.delete(id);
		return "redirect:/docente/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Docente> lista = this.docenteService.findAll();
		model.addAttribute("models", lista);
		return baseViews + "list";
	}



	@RequestMapping(value = "/prova")
	public String prova() {
		Corsi c = new Corsi();

		c.setNomecorso("Exoprova");
		Docente docente = this.docenteService.find(65);
		List<Corsi> lc = new ArrayList<>();
		docente.setCorsi(c);
		this.docenteService.update(docente);
		return baseViews + "form";

	}


}
