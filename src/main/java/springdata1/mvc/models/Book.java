package springdata1.mvc.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Size(min=5, max=200) @NotEmpty
	private String title;
	@Size(min=2, max=200)
	private String description;
	@Size(min=3, max=40)
	private String language;
	@Min(100)
	private Integer numberOfPages;	
	@Column(updatable=false)// Esto impedirá que el campo createdAt sea modificado
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDateTime createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDateTime updatedAt;
	
	//constructor
	public Book() {
	}
	
	public Book(String title, String description, String language, Integer numberOfPages) {
		this.title = title;
		this.description = description;
		this.language = language;
		this.numberOfPages = numberOfPages;
	}

	//getters and setters
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist 
	protected void onCreate() {
		LocalDateTime date = LocalDateTime.now();
		this.createdAt = date;
	}
	@PreUpdate
	protected void onUpdate() {
		LocalDateTime date = LocalDateTime.now();
		this.updatedAt = date;
	}
	
	
}
