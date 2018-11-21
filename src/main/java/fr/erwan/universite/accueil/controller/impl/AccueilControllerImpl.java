package fr.erwan.universite.accueil.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.erwan.universite.accueil.controller.IAccueilController;

@Controller
public class AccueilControllerImpl implements IAccueilController{
	@Override
	@RequestMapping("/")
	public String accueil(Model model) {
		return "accueil";
	}
}
