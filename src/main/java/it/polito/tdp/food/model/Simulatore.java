package it.polito.tdp.food.model;

import java.time.LocalTime;
import java.util.*;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

import it.polito.tdp.food.model.Event.EventType;

public class Simulatore {

	//stato del sistema
	private List<Food> foods;
	private int postazioniLibere;
	
	//parametri in ingresso
	private int k; //numero stazioni di lavoro
	private Graph<Food,DefaultWeightedEdge> grafo;
	private Food iniziale;
	private List<Food> vertici;
	
	//indicatori di uscita
	private int nFoods;
	private int tempo;
	
	//coda degli eventi
	private PriorityQueue<Event> queue;
	
	public Simulatore(int k, Graph<Food,DefaultWeightedEdge> grafo, Food f, List<Food> vertici) {	
		this.foods=new ArrayList<>();
		this.postazioniLibere=k;
		this.k=k;
		this.grafo=grafo;
		this.iniziale=f;
		this.vertici=vertici;
		this.nFoods=0;
		this.tempo=0;
		this.queue= new PriorityQueue<>();
	}
	
	public void initialize() {
		LocalTime ora = LocalTime.of(0, 0);
		while(!vertici.isEmpty()) {
			this.foods.add(iniziale);
			this.queue.add(new Event(ora, EventType.NEW, iniziale));
			
		}
	}
	
}
