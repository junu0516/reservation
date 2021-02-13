package kr.or.connect.reservation.dto;

import java.util.List;

public class Categories {
	private int size;
	private List<Category> items;
	
	public Categories() {
		
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Category> getItems() {
		return items;
	}

	public void setItems(List<Category> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Categories [size=" + size + ", items=" + items + "]";
	}
	
}
