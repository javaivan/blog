package com.mixdev.blog.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post {


	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "text")
	private String text;

	public Post() {
	}

	public Post(String title) {
		this.title = title;
	}

	public Post(String title, Set<Category> categories) {
		this.title = title;
		this.categories = categories;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "post_category", joinColumns = {
			@JoinColumn(name = "post_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "category_id",
					nullable = false, updatable = false) })

	private Set<Category> categories = new HashSet<Category>(0);


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", text=" + text + ", categorie= " + categories.size() + "]";
	}
}
