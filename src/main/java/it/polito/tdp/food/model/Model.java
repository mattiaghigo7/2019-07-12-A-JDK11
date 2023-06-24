package it.polito.tdp.food.model;

import java.util.*;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import it.polito.tdp.food.db.FoodDao;

public class Model {

	private FoodDao dao;
	
	private Graph<Food, DefaultWeightedEdge> grafo;
	private List<Food> vertici;
	private Map<Integer, Food> idMap;
	private List<Coppia> archi;
	private List<Food> vertici2;
	private int porzione;
	
	private Simulatore sim;
	
	public Model() {
		this.dao = new FoodDao();
	}
	
	public void creaGrafo(Integer porzione) {
		this.porzione=porzione;
		this.grafo=new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		this.vertici=new ArrayList<>(dao.getVertici(this.porzione));
		this.vertici2=new ArrayList<>(dao.getVertici(this.porzione));
		this.idMap=new HashMap<>();
		for(Food f : this.vertici) {
			this.idMap.put(f.getFood_code(), f);
		}
		Graphs.addAllVertices(this.grafo, this.vertici);
		
		this.archi=new ArrayList<>();
		this.archi=dao.getArchi(idMap);
		for(Coppia c : archi) {
			if(this.grafo.vertexSet().contains(c.getF1()) && this.grafo.vertexSet().contains(c.getF2())) {
				Graphs.addEdgeWithVertices(this.grafo, c.getF1(), c.getF2(), c.getN());
			}
		}
	}
	
	public List<FoodCalories> getCalorieCongiunte(int n){
		List<FoodCalories> l = new ArrayList<>();
		this.calcola(l, n);
		return l;
	}
	
	private void calcola(List<FoodCalories> l, int n) {
		if(l.size()==n) {
			return;
		}
		int max = 0;
		Food best = null;
		for(Food f : this.vertici2) {
			if(grafo.degreeOf(f)>max) {
				max=grafo.degreeOf(f);
				best=f;
			}
		}
		l.add(new FoodCalories(best,max));
		this.vertici2.remove(best);
		calcola(l, n);
	}

	public List<Food> getVertici() {
		this.vertici.sort(null);
		return this.vertici;
	}
	
	public int getVerticiSize() {
		return this.grafo.vertexSet().size();
	}
	
	public int getArchiSize() {
		return this.grafo.edgeSet().size();
	}
}
