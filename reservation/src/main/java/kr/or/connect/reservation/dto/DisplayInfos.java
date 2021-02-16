package kr.or.connect.reservation.dto;

import java.util.List;

public class DisplayInfos {
	private List<Product> products;
	private List<ProductImage> productImages;
	private List<DisplayInfoImage> displayInfoImages;
	private int avgScore;
	private List<ProductPrice> productPrices;
	
	public DisplayInfos() {
		
	}

	
	public DisplayInfos(List<Product> products, List<ProductImage> productImages,
			List<DisplayInfoImage> displayInfoImages, int avgScore, List<ProductPrice> productPrices) {
		super();
		this.products = products;
		this.productImages = productImages;
		this.displayInfoImages = displayInfoImages;
		this.avgScore = avgScore;
		this.productPrices = productPrices;
	}

	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public List<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public List<DisplayInfoImage> getDisplayInfoImages() {
		return displayInfoImages;
	}

	public void setDisplayInfoImages(List<DisplayInfoImage> displayInfoImages) {
		this.displayInfoImages = displayInfoImages;
	}

	public int getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(int avgScore) {
		this.avgScore = avgScore;
	}

	public List<ProductPrice> getProductPrices() {
		return productPrices;
	}

	public void setProductPrices(List<ProductPrice> productPrices) {
		this.productPrices = productPrices;
	}

	@Override
	public String toString() {
		return "DisplayInfos [products=" + products + ", productImages=" + productImages + ", displayInfoImages="
				+ displayInfoImages + ", avgScore=" + avgScore + ", productPrices=" + productPrices + "]";
	}

}
