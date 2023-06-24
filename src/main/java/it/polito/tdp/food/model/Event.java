package it.polito.tdp.food.model;

import java.time.LocalTime;

public class Event implements Comparable<Event>{

	public enum EventType{
		NEW,
		FREE
	}
	
	private LocalTime time;
	private EventType type;
	private Food food;
	
	public Event(LocalTime time, EventType type, Food food) {
		super();
		this.time = time;
		this.type = type;
		this.food = food;
	}

	public LocalTime getTime() {
		return time;
	}

	public EventType getType() {
		return type;
	}

	public Food getFood() {
		return food;
	}

	@Override
	public String toString() {
		return "Event [time=" + time + ", type=" + type + ", food=" + food + "]";
	}

	@Override
	public int compareTo(Event o) {
		return this.time.compareTo(o.time);
	}

}
