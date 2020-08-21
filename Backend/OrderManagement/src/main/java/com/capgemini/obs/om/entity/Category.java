package com.capgemini.obs.om.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category 
{
	@Id
	@Column(name="categoryId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_seq")
    @SequenceGenerator(name = "cat_seq", sequenceName = "category_sequence", allocationSize=1)
    int categoryId;
	
	@Column(name="categoryName")
	private String categoryName;
	
	public Category() {}
	public Category(Integer categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
}
