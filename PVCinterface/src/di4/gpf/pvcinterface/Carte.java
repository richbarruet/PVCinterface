package di4.gpf.pvcinterface;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.R.drawable;

public class Carte {


	private String nom;
	private double tailleX;
	private double tailleY;
	private double echelle;
	private LinkedList<Ville> villes;
	private int bgId;
	
	

	public Carte(double echelle) {
		super();
		this.echelle = echelle;
		bgId=R.drawable.france;
		villes = new LinkedList<Ville>();
		villes.add(new Ville(1,"Ville1",50,50));
		villes.add(new Ville(2,"Ville2",50,150));
		villes.add(new Ville(3,"Ville3",150,50));
		villes.add(new Ville(4,"Ville4",150,150));
		//Chargement image
		
	}
	
	public Carte(double echelle, InputStream inXML) {
		super();
		this.echelle = echelle;
		readXML(inXML);
	}

	private void readXML(InputStream inXML){
		XmlPullParserFactory pullParserFactory;
		try {
			pullParserFactory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = pullParserFactory.newPullParser();

			    InputStream in_s = inXML;
		        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
	            parser.setInput(in_s, null);

	            parseXML(parser);

		} catch (XmlPullParserException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
	{
        int eventType = parser.getEventType();
        Ville currentVille = null;
        int i=1;

        while (eventType != XmlPullParser.END_DOCUMENT){
            String name = null;
            switch (eventType){
                case XmlPullParser.START_DOCUMENT:
            		villes = new LinkedList<Ville>();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equals("carteNom")){
                    	nom = parser.nextText();
                    } else if (name.equals("ville")){
                        currentVille = new Ville(i);
                    } else if (currentVille != null){
                        if (name.equals("villeNom")){
                            currentVille.setNom(parser.nextText());
                        } else if (name.equals("coordX")){
                        	currentVille.setCoordX(Double.parseDouble(parser.nextText()));
                        } else if (name.equals("coordY")){
                            currentVille.setCoordY(Double.parseDouble(parser.nextText()));
                        }  
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("ville") && currentVille != null){
                    	villes.add(currentVille);
                    	i++;
                    } 
            }
            eventType = parser.next();
        }
	}
	
	public double dist(Ville vA, Ville vB){
		return Math.sqrt(Math.pow(vA.getCoordX()-vB.getCoordX(), 2)+Math.pow(vA.getCoordY()-vB.getCoordY(), 2));
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getEchelle() {
		return echelle;
	}



	public void setEchelle(double echelle) {
		this.echelle = echelle;
	}



	public LinkedList<Ville> getVilles() {
		return villes;
	}



	public void addVille(Ville ville) {
		this.villes.add(ville);
	}
	
	


}
