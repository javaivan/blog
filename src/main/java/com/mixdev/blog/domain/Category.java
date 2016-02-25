package com.mixdev.blog.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@Column(name = "title")
	private String title;
/*
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	private Set<Post> posts = new HashSet<Post>(0);
*/
	public Category(){
	}

	public Category(String title){
		this.title = title;
	}

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
	/*
	public Set<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
*/
	@Override
	public String toString() {
		return "Category [id=" + id + ", title=" + title + "]";
	}

}
