package com.example.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement
public class Cities implements Serializable {

	private static final long serialVersionUID = 22L;

	@JacksonXmlProperty(localName = "City")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<City> cities = new ArrayList<>();

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
}