package kr.or.connect.reservation.dto;

import java.util.List;

public class Reservations {
	
	private int size;
	private List<Reservation> items;
	
	public Reservations() {
		
	}
	
	public Reservations(int size, List<Reservation> items) {
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

	public List<Reservation> getItems() {
		return items;
	}

	public void setItems(List<Reservation> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Reservations [size=" + size + ", items=" + items + "]";
	}
	
}
