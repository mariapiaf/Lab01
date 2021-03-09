package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class Parole {
		
	private List<String> elenco;
	
	public Parole() {
		//TODO
		this.elenco = new ArrayList<String>();
	//	this.elenco = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		//TODO
		this.elenco.add(p);
		
	}
	
	public class ComparatoreOrdineAlfabetico implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
		
	}
	public List<String> getElenco() {
		//TODO
		List<String> elencoOrdinato = new ArrayList<String>(elenco);
		//List<String> elencoOrdinato = new LinkedList<String>(elenco);
		Collections.sort(elencoOrdinato, new ComparatoreOrdineAlfabetico());
		return elencoOrdinato;
	}
	// LinkedList impiega più tempo
	public void reset() {
		// TODO
		this.elenco.removeAll(elenco);
	}
	
	public void Cancella(String p) {
		elenco.remove(p);
	}
}
