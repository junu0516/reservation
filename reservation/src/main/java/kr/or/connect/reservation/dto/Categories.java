package kr.or.connect.reservation.dto;

import java.util.List;

public class Categories {
	private int size;
	private List<Category> items;
	
	public Categories() {
		
	}
	
	public Categories(List<Category> items) {
		super();
		this.size = items.size();
		this.items = items;
	}

	@Override
	public String toString() {
		return "Categories [size=" + size + ", items=" + items + "]";
	}
	
}
