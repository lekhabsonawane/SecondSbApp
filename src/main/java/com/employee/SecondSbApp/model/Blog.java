package com.employee.SecondSbApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Long blogid;
	@Column(name = "blog_title")
    private String blogtitle;
	@Column(name = "blog_date")
    private Date blogdate;
	@Column(name = "blog_content")
    private String blogcontent;
	@Override
	public String toString() {
		return "Blog [id=" + blogid + ", title=" + blogtitle + ", date=" + blogdate + ", content=" + blogcontent + ", getId()="
				+ getId() + ", getTitle()=" + getTitle() + ", getDate()=" + getDate() + ", getContent()=" + getContent()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public Long getId() {
		return blogid;
	}
	public void setId(Long id) {
		this.blogid
		= id;
	}
	public String getTitle() {
		return blogtitle;
	}
	public void setTitle(String title) {
		this.blogtitle = title;
	}
	public Date getDate() {
		return blogdate;
	}
	public void setDate(Date date) {
		this.blogdate = date;
	}
	public String getContent() {
		return blogcontent;
	}
	public void setContent(String content) {
		this.blogcontent = content;
	}

}