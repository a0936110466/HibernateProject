package tw.edenHsieh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity @Table(name = "bookdetail")
public class BookDetail {
	@GenericGenerator(name = "generator",strategy = "foreign",parameters=@Parameter(name = "property", value = "book"))
	@Id @Column(name = "ID")
	@GeneratedValue(generator = "generator")
	private int id;
	
	@Column(name = "PUBLISHER")
	private String publisher;
	@Column(name = "PUBLISHERADDRESS")
	private String publisheraddress;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Book book;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublisheraddress() {
		return publisheraddress;
	}
	public void setPublisheraddress(String publisheraddress) {
		this.publisheraddress = publisheraddress;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
}
