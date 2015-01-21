package di4.gpf.pvcinterface;

import java.util.Iterator;
import java.util.Stack;

public class Solution {
	private Stack<Ville> chemin;
	private double score;
	private long chronoStrt;

	public Solution() {
		super();
		score=0;
		chemin=new Stack<Ville>();
		chronoStrt=System.nanoTime();
		start();
	}

	public double dist(Ville vA, Ville vB){
		return Math.sqrt(Math.pow(vA.getCoordX()-vB.getCoordX(), 2)+Math.pow(vA.getCoordY()-vB.getCoordY(), 2));
	}

	public void addNext(Ville ville) {
		if(!chemin.isEmpty()){
			Ville last = chemin.lastElement();
			score += dist(ville,last);
		}else
			score+=dist(new Ville(0,"tempOrigin",0,0),ville);
		chemin.push(ville);
	}

	public Ville delLast() {
		Ville deleted = chemin.pop();
		if(!chemin.isEmpty()){
			Ville last = chemin.lastElement();
			score -= dist(deleted,last);
		}else
			score = 0;
		return deleted;
	}

	public void start() {
		chronoStrt = System.nanoTime();
	}

	public void opt2() {
		int taille = chemin.size();
		int i = 0, j = 0;
		Boolean mod = true;
		Ville vi1, vj1, vi2, vj2;
		while (mod) {
			mod = false;
			for (i = 0; i < taille-1; i++) {
				for (j = 0; j < taille-1; j++) {
					if (j != i - 1 && j != i && j != i + 1) {
						vi1 = chemin.get(i);
						vi2 = chemin.get(i + 1);
						vj1 = chemin.get(j);
						vj2 = chemin.get(j + 1);
						if ((dist(vi1, vi2) + dist(vj1, vj2)) > (dist(vi1, vj1) + dist(vi2, vj1))) {
							chemin.set(i + 1, vj1);
							chemin.set(j, vi2);
							mod = true;
						}
					}
				}
			}
		}
		reloadScore();
	}

	public double getScore() {
		reloadScore();
		return score;
	}
	
	public void reloadScore(){
		score=0;
		Iterator<Ville> it1=chemin.iterator();
		if(!chemin.isEmpty()){
			Ville v1=it1.next();
			Ville v2;
			while(it1.hasNext()){
				v2=it1.next();
				score+=dist(v1,v2);
				v1=v2;
			}
		}else
			score=0;
		
	}

	public void setScore(double score) {
		this.score = score;
	}

	public long getChronoStrt() {
		return chronoStrt;
	}

	public void setChronoStrt(long chronoStrt) {
		this.chronoStrt = chronoStrt;
	}

	public Stack<Ville> getChemin() {
		return chemin;
	}

}
