package com.example.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CITIES")
@JacksonXmlRootElement(localName = "City")
public class City implements Serializable {

	private static final long serialVersionUID = 21L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JacksonXmlProperty(isAttribute = true)
	private Long id;

	@JacksonXmlProperty
	private String name;

	@JacksonXmlProperty
	private int population;

	public City() {
	}

	public City(Long id, String name, int population) {
		this.id = id;
		this.name = name;
		this.population = population;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "City{" + "id=" + id + ", name=" + name + ", population=" + population + '}';
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 37 * hash + Objects.hashCode(this.id);
		hash = 37 * hash + Objects.hashCode(this.name);
		hash = 37 * hash + this.population;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final City other = (City) obj;
		if (this.population != other.population) {
			return false;
		}
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}

		return Objects.equals(this.id, other.id);
	}
}