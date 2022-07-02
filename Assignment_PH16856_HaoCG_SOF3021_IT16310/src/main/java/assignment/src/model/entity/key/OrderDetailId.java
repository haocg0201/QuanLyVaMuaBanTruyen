package assignment.src.model.entity.key;

import java.io.Serializable;

import javax.persistence.JoinColumn;

import org.hibernate.annotations.ForeignKey;

import assignment.src.model.entity.Comic;
import assignment.src.model.entity.Order;

public class OrderDetailId implements Serializable{

	private Order order;
	private Comic comic;
	
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
