package com.revature.demo.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Home {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int home_id;
	private String name_home;
	private int size_home;
	private int cost_home;
	
    /*@JsonIgnore
	@OneToMany(mappedBy = "home", cascade = CascadeType.ALL)
	private Set<Fourniture> fourniture;*/
	
	public Home(int home_id, String name_home, int size_home, int cost_home) {
		super();
		this.home_id = home_id;
		this.name_home = name_home;
		this.size_home = size_home;
		this.cost_home = cost_home;
	}
	
	public Home() {
		super();
	}

	public int getHome_id() {
		return home_id;
	}
	public void setHome_id(int home_id) {
		this.home_id = home_id;
	}
	public String getName_home() {
		return name_home;
	}
	public void setName_home(String name_home) {
		this.name_home = name_home;
	}
	public int getSize_home() {
		return size_home;
	}
	public void setSize_home(int size_home) {
		this.size_home = size_home;
	}
	public int getCost_home() {
		return cost_home;
	}
	public void setCost_home(int cost_home) {
		this.cost_home = cost_home;
	}
	@Override
	public String toString() {
		return "home [home_id=" + home_id + ", name_home=" + name_home + ", size_home=" + size_home + ", cost_home="
				+ cost_home + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cost_home, home_id, name_home, size_home);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Home other = (Home) obj;
		return cost_home == other.cost_home && home_id == other.home_id && Objects.equals(name_home, other.name_home)
				&& size_home == other.size_home;
	}
	

	
	
	

}
