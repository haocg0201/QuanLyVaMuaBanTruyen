package assignment.src.model.entity;

import java.math.BigDecimal;

public class Cart {
	private Long comicId;	
	private String comicName;
	private String image;
	private BigDecimal price;
	private Integer quantity = 1;
	
	public Cart() {
		super();
	}
	public Cart(Long comicId, String comicName, String image, BigDecimal price, Integer quantity) {
		super();
		this.comicId = comicId;
		this.comicName = comicName;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
	}
	public Long getComicId() {
		return comicId;
	}
	public void setComicId(Long comicId) {
		this.comicId = comicId;
	}
	public String getComicName() {
		return comicName;
	}
	public void setComicName(String comicName) {
		this.comicName = comicName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
