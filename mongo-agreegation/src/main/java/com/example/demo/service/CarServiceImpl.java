package com.example.demo.service;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.example.demo.model.Car;
import com.example.demo.model.SalesReport;


@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<SalesReport> aggregationByAll() {
		Aggregation aggregation = newAggregation(
				group("brand", "salesyear").sum("numberOfCars").as("total"),
				sort(Sort.Direction.ASC, previousOperation(), "brand"));

		AggregationResults<SalesReport> groupResults = mongoTemplate.aggregate(aggregation, Car.class, SalesReport.class);

		return groupResults.getMappedResults();
	}

	@Override
	public List<SalesReport> aggregationByYear(int year) {
		Aggregation aggregation = newAggregation(
				match(Criteria.where("salesyear").is(year)),
				group("brand","salesyear").sum("numberOfCars").as("total"),
				sort(Sort.Direction.ASC, previousOperation(), "brand")    
				);
		AggregationResults<SalesReport> groupResults = mongoTemplate.aggregate(
				aggregation, Car.class, SalesReport.class);

		return groupResults.getMappedResults();
	}

	@Override
	public void create(Car car) {
		if (car != null) {
			this.mongoTemplate.insert(car, "cars");
		}
	}

	@Override
	public void drop() {
		this.mongoTemplate.dropCollection("cars");
	}
}
