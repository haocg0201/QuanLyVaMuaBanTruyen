package assignment.src.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import assignment.src.model.entity.type.ComicType;

@Table
@Entity
public class Comic implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long comicId;
	
	@Column(nullable = false)
	private String comicName;
	
	@Column(nullable = false)
	private Integer currentQuantity;
	
	@Column(nullable = false)
	private BigDecimal currentPrice;
	
	@Column(nullable = false)
	private Integer chapter;
	
	@Column(nullable = false)
	private String author;
	
	@Column(nullable = false)
	private ComicType type;
	
	@Column(nullable = true)
	private Date enteredDate = new Date();
	
	@Column(nullable = true)
	private String image;
	
	@Column(nullable = true)
	private String status;
	
	@OneToMany(mappedBy = "comic",cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetails;
	
	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public Date getEnteredDate() {
		return enteredDate;
	}
	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public ComicType getType() {
		return type;
	}
	public void setType(ComicType type) {
		this.type = type;
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
	public Integer getCurrentQuantity() {
		return currentQuantity;
	}
	public void setCurrentQuantity(Integer currentQuantity) {
		this.currentQuantity = currentQuantity;
	}
	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}
	public Integer getChapter() {
		return chapter;
	}
	public void setChapter(Integer chapter) {
		this.chapter = chapter;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Comic [comicId=" + comicId + ", comicName=" + comicName + ", currentQuantity=" + currentQuantity
				+ ", currentPrice=" + currentPrice + ", chapter=" + chapter + ", author=" + author + ", type=" + type
				+ ", enteredDate=" + enteredDate + ", image=" + image + ", status=" + status + "]";
	}		
}
