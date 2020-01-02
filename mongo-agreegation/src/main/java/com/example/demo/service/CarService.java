package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Car;
import com.example.demo.model.SalesReport;

public interface CarService {
	public List<SalesReport> aggregationByAll();
	public List<SalesReport> aggregationByYear(int year);
	public void create(Car car);
	public void drop();
}
