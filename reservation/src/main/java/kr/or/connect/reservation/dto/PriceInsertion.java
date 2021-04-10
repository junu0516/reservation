package kr.or.connect.reservation.dto;

public class PriceInsertion {
	int count;
	int productPriceId;
	
	public PriceInsertion() {
		
	}
	
	public PriceInsertion(int count, int productPriceId) {
		super();
		this.count = count;
		this.productPriceId = productPriceId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getProductPriceId() {
		return productPriceId;
	}

	public void setProductPriceId(int productPriceId) {
		this.productPriceId = productPriceId;
	}

	@Override
	public String toString() {
		return "PriceInsertion [count=" + count + ", productPriceId=" + productPriceId + "]";
	}
	
}
