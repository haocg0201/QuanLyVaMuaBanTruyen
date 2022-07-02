package assignment.src.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import assignment.src.model.entity.key.OrderDetailId;

@Table
@Entity
public class OrderDetail implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderdetailId;

	@ManyToOne()
	@JoinColumn(name = "orderId")	
	private Order order;
	
	@ManyToOne()
	@JoinColumn(name ="comicId")
	private Comic comic;
	
	@Column(nullable = false)
	private Integer purchasedQuantity;
	
	@Column(nullable = false)
	private BigDecimal purchasedPrice;
	
	public Long getOrderdetailId() {
		return orderdetailId;
	}

	public void setOrderdetailId(Long orderdetailId) {
		this.orderdetailId = orderdetailId;
	}

	public Integer getPurchasedQuantity() {
		return purchasedQuantity;
	}

	public void setPurchasedQuantity(Integer purchasedQuantity) {
		this.purchasedQuantity = purchasedQuantity;
	}

	public BigDecimal getPurchasedPrice() {
		return purchasedPrice;
	}

	public void setPurchasedPrice(BigDecimal purchasedPrice) {
		this.purchasedPrice = purchasedPrice;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Comic getComic() {
		return comic;
	}

	public void setComic(Comic comic) {
		this.comic = comic;
	}
}
