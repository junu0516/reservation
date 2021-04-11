package kr.or.connect.reservation.dto;

import java.util.ArrayList;

public class Reservations {
	
	private int size;
	private ArrayList<Reservation> items;
	
	public Reservations() {
		
	}
	
	public Reservations(int size, ArrayList<Reservation> items) {
		super();
		this.size = size;
		this.items = items;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ArrayList<Reservation> getItems() {
		return items;
	}

	public void setItems(ArrayList<Reservation> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Reservations [size=" + size + ", items=" + items + "]";
	}
	
}
