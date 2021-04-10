package kr.or.connect.reservation.dto;

public class Price {
	
	private int id;
	private int rereservationInfoId;
	private int productPriceId;
	private int count;
	
	public Price() {
		
	}

	public Price(int id, int rereservationInfoId, int productPriceId, int count) {
		super();
		this.id = id;
		this.rereservationInfoId = rereservationInfoId;
		this.productPriceId = productPriceId;
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRereservationInfoId() {
		return rereservationInfoId;
	}

	public void setRereservationInfoId(int rereservationInfoId) {
		this.rereservationInfoId = rereservationInfoId;
	}

	public int getProductPriceId() {
		return productPriceId;
	}

	public void setProductPriceId(int productPriceId) {
		this.productPriceId = productPriceId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Price [id=" + id + ", rereservationInfoId=" + rereservationInfoId + ", productPriceId=" + productPriceId
				+ ", count=" + count + "]";
	}
	
}
