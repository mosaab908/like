package com.revature.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Fourniture {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fourniture_id;
	private String name_fourniture;
	private int size_fourniture;
	private String color_fourniture;
	private int home_id;
	
	/*@ManyToOne
	@JoinColumn(name="home_id", referencedColumnName="id")
	private Home home;*/
	
	public Fourniture(int fourniture_id, String name_fourniture, int size_fourniture, String color_fourniture,
			int home_id) {
		super();
		this.fourniture_id = fourniture_id;
		this.name_fourniture = name_fourniture;
		this.size_fourniture = size_fourniture;
		this.color_fourniture = color_fourniture;
		this.home_id = home_id;
	}

	public int getFourniture_id() {
		return fourniture_id;
	}

	public void setFourniture_id(int fourniture_id) {
		this.fourniture_id = fourniture_id;
	}

	public String getName_fourniture() {
		return name_fourniture;
	}

	public void setName_fourniture(String name_fourniture) {
		this.name_fourniture = name_fourniture;
	}

	public int getSize_fourniture() {
		return size_fourniture;
	}

	public void setSize_fourniture(int size_fourniture) {
		this.size_fourniture = size_fourniture;
	}

	public String getColor_fourniture() {
		return color_fourniture;
	}

	public void setColor_fourniture(String color_fourniture) {
		this.color_fourniture = color_fourniture;
	}

	public int getHome_id() {
		return home_id;
	}

	public void setHome_id(int home_id) {
		this.home_id = home_id;
	}

	@Override
	public String toString() {
		return "Fourniture [fourniture_id=" + fourniture_id + ", name_fourniture=" + name_fourniture
				+ ", size_fourniture=" + size_fourniture + ", color_fourniture=" + color_fourniture + ", home_id="
				+ home_id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(color_fourniture, fourniture_id, home_id, name_fourniture, size_fourniture);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fourniture other = (Fourniture) obj;
		return Objects.equals(color_fourniture, other.color_fourniture) && fourniture_id == other.fourniture_id
				&& home_id == other.home_id && Objects.equals(name_fourniture, other.name_fourniture)
				&& size_fourniture == other.size_fourniture;
	}
	
	

}
