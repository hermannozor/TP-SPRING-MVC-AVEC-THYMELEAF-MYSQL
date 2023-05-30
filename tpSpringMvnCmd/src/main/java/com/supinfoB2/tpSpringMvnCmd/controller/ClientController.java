package com.supinfoB2.tpSpringMvnCmd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.supinfoB2.tpSpringMvnCmd.dao.ClientRepository;
import com.supinfoB2.tpSpringMvnCmd.entities.Client;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value="/client")
public class ClientController implements ErrorController {
	
	@Autowired
	ClientRepository clientRepo;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String listerClients(Model model, 
    		@RequestParam(name="page",defaultValue="0")int p,
    		@RequestParam(name="motCle",defaultValue="")String mc) {
    	Page<Client> pageClients = clientRepo.chercherClients("%"+mc+"%",PageRequest.of(p,5));
    	int pagesCount=pageClients.getTotalPages();
    	int[] pages=new int[pagesCount];
    	for(int i=0; i<pagesCount; i++) pages[i]=i;
    	
    	//model permet de stocker tous les résultats que je voudrais afficher
    	model.addAttribute("pages", pages);
    	model.addAttribute("pageCourante", p);
        model.addAttribute("motCle", mc);
        model.addAttribute("pageClients", pageClients);
        //retourne la vue
        return "clients";
    }
    
    //Méthode qui permet d'afficher le formulaire de saisie du client
    @RequestMapping(value="/formClient",method=RequestMethod.GET)
    public String formClient(Model model) {
    	
    	model.addAttribute("client", new Client());
    	//retourne la vue
    	return "formClient";
    }
    
    //Méthode qui créé un client
    @RequestMapping(value="/SaveClient",method=RequestMethod.POST)
    public String save(@Valid Client client, BindingResult bindingResult) {
    	//On teste pour voir s'il y a des erreurs dans notre formulaire avant de sauvegarder en base
    	if(bindingResult.hasErrors()) {
    		return "formClient";
    	}
    	clientRepo.save(client);
    
    	//retourne la vue
    	return "redirect:index";
    }

}
