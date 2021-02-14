package kr.or.connect.reservation.dto;

import java.util.List;

public class Products {
	private int totalCount;
	private final int productCount = 4;
	private List<Product> items;
	
	public Products() {
		
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getProductCount() {
		return productCount;
	}

	public List<Product> getItems() {
		return items;
	}

	public void setItems(List<Product> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Products [totalCount=" + totalCount + ", productCount=" + productCount + ", items=" + items + "]";
	}
	
}
