package fr.erwan.universite.enseignant.utils;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import fr.erwan.universite.enseignant.domain.Enseignant;

@Component
public class UtilsEnseignant {
	private static HashMap<String ,String>erreurs=new HashMap<>();
	public static HashMap<String ,String> getErreurs() {
		return erreurs;
	}
	public static boolean checkValidite(Enseignant enseignant) {
		boolean valide=true;
		try {
			verifNom(enseignant.getNom());
		}catch (Exception e) {
			valide=false;
			erreurs.put("nom",e.getMessage());
		}
		try {
			verifPrenom(enseignant.getPrenom());
		}catch (Exception e) {
			valide=false;
			erreurs.put("prenom",e.getMessage());
		}
		try {
			verifNumEnseignant(enseignant.getEnseignantNum());
		}catch (Exception e) {
			valide=false;
			erreurs.put("numEnseignant",e.getMessage());
		}
		return valide;
	}
	private static boolean verifNom(String nom) throws Exception{
		if(nom==null) {
			throw new Exception("le nom est null");
		}else if(nom.trim().equals("")) {
			throw new Exception("le nom est vide");
		}else if(nom.trim().length()<2) {
			throw new Exception("le nom est trop court");
		}
		return true;
	}
	private static boolean verifPrenom(String prenom)  throws Exception{
		if (prenom==null) {
			throw new Exception("le prenom est null");
		}else if (prenom.trim().equals("")) {
			throw new Exception("le prenom est vide");
		}else if (prenom.trim().length()<2) {
			throw new Exception("le prenom est trop court");
		}
		return true;
	}
	private static boolean verifNumEnseignant(Long num) throws Exception{
		if (num==null) {
			throw new Exception("le numero est null");
		}else if (num.toString().trim().equals("")) {
			throw new Exception("le numero est vide");
		}else if (num<0) {
			throw new Exception("le numero doit etre positif");
		}
		return true;
	}

}
