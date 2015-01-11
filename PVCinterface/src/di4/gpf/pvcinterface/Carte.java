package di4.gpf.pvcinterface;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import android.R.drawable;

public class Carte {
	private double tailleX;
	private double tailleY;
	private double echelle;
	private List<Ville> villes;
	private int bgId;
	
	

	public Carte(double echelle) {
		super();
		this.echelle = 1/1;
		bgId=R.drawable.france;
		villes.add(new Ville(1,"Ville1",10,10));
		villes.add(new Ville(2,"Ville2",5,15));
		villes.add(new Ville(3,"Ville3",15,15));
		villes.add(new Ville(4,"Ville3",5,5));
		//Chargement image
		
	}

	public double dist(Ville vA, Ville vB){
		return Math.sqrt(Math.hypot(vA.getCoordX(), vB.getCoordY()));
	}

	public double getEchelle() {
		return echelle;
	}



	public void setEchelle(double echelle) {
		this.echelle = echelle;
	}



	public List<Ville> getVilles() {
		return villes;
	}



	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}
	
	


}
