package com.sdl.project_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Where(clause ="del_Flag='N'" )
public class Product extends AbstractEntity {
	
	
	private String name;
	private Double price;
	private boolean readonly;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	@Override
	public String toString() {
		return "Product{" +
				"name='" + name + '\'' +
				", price=" + price +
				", readonly=" + readonly +
				'}';
	}
}
