package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.checkerframework.checker.units.qual.cd;
import org.javers.core.Changes;
import org.javers.core.Javers;
import org.javers.core.diff.Change;
import org.javers.core.diff.changetype.PropertyChange;
import org.javers.core.diff.changetype.ReferenceChange;
import org.javers.core.diff.changetype.ValueChange;
import org.javers.core.diff.changetype.container.CollectionChange;
import org.javers.core.diff.changetype.container.ListChange;
import org.javers.core.diff.changetype.map.MapChange;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.repository.jql.JqlQuery;
import org.javers.repository.jql.QueryBuilder;
import org.javers.shadow.Shadow;
import org.javers.spring.annotation.JaversAuditable;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import com.example.model.Car;
import com.example.model.Person;
import com.example.repository.CarRepository;
import com.example.repository.PersonRepository;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableMongoAuditing
@JaversSpringDataAuditable
public class SpringbootJaVersApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJaVersApplication.class, args);
	}

	@Autowired
	private CarRepository carRepository;
	@Autowired
	private PersonRepository personRepository;

	@Override
	public void run(String... args) throws Exception {
		saveJavers();
		
		withJavers();
	}

	@Autowired
	private Javers javers;

	private void withJavers() {
		// With NewObjectChanges
//		List<Change> changes = javers.findChanges(QueryBuilder.byClass(Car.class)
//				.withNewObjectChanges().build());
//
//		System.out.println("Printing the flat list of Changes :");
//		changes.forEach(change -> System.out.println("- " + change));
//		
//		// This will give property changes
//		System.out.println("----------------------------------");
//		QueryBuilder jqlQuery = QueryBuilder.byClass(Car.class);
//        List<Change> changeLst = javers.findChanges(jqlQuery.build());
//        for (Change c : changeLst) {
//        	System.out.println("-----------------------");
//        	if(c instanceof ValueChange) {
//        		System.out.println("Change is an instance of value change...");
//        		ValueChange vc = (ValueChange) c;
//        		System.out.println(vc.getPropertyName());
//        		System.out.println(vc.getAffectedGlobalId());
//        		System.out.println(vc.getLeft()+"  "+vc.getRight());
//        	}
//        	
//        	if(c instanceof PropertyChange) {
//        		System.out.println("Change is an instance of PropertyChange...");
//        		PropertyChange pc = (PropertyChange) c;
//        	}
//        	
//        	if(c instanceof MapChange) {
//        		System.out.println("Change is an instance of PropertyChange...");
//        		MapChange mc = (MapChange) c;
//        	}
//        }
//
//        String l = javers.getJsonConverter().toJson(changeLst);
//        System.out.println(l);
        
        // find snapshot
        /*List<Change> list = javers.findChanges(QueryBuilder.byClass(Car.class).build());
        for (Change change2 : list) {
        	ValueChange vc = (ValueChange) change2;
        	System.out.println(vc.getLeft()+"  "+vc.getRight());
		}*/
        
        
        // find All
        List<Car> cars = carRepository.findAll();
        Car c = cars.get(0);
        
        List<Change> snapshots = javers.findChanges(QueryBuilder.byInstanceId(c.getId(), Car.class).build());
        
        List<PCChange> pcChanges = new ArrayList<>();
        MultiValuedMap<String, String> m = new ArrayListValuedHashMap<>();
        for (Change ch : snapshots) {
        	if(ch instanceof ValueChange) {
        		System.out.println("-------------------");
        		ValueChange vc = (ValueChange) ch;
        		System.out.println("Property Name = [" +vc.getPropertyName()+"], Old Value ="+vc.getLeft()+", Current Value ="+vc.getRight());
        		
        		PCChange pcchange = PCChange.builder().propertyChange(vc.getPropertyName())
        				.currentValue(vc.getRight().toString())
        				.oldValue(vc.getLeft().toString()).build();
        		pcChanges.add(pcchange);
        		
        		//
        		
        		m.put(vc.getPropertyName(), vc.getRight()+":"+vc.getLeft());
        		
        		PropertyChange pc = (PropertyChange) ch;
        		System.out.println(pc.getPropertyName());
        		System.out.println(pc.getAffectedLocalId());
        		System.out.println(pc.getPropertyNameWithPath());
        		System.out.println(pc.getAffectedGlobalId());
        		System.out.println(pc.getCommitMetadata().get());
        	}
		}
        System.out.println(m);
        
        
        // with UPDATE
        List<Shadow<Object>> findSnapshots = javers.findShadows(QueryBuilder.byInstanceId(c.getId(), Car.class).withSnapshotTypeUpdate().build());
        
        
        List<Car> mycars = new ArrayList<Car>();
        for (Shadow<Object> shadow : findSnapshots) {
        	Car myCar = (Car) shadow.get();
        	System.out.println(myCar);
        	mycars.add(myCar);
		}
        
        List<Shadow<Object>> nfindSnapshots = javers.findShadows(QueryBuilder.byInstanceId(c.getId(), Car.class).withChangedProperty("horsePower").build());
        for (Shadow<Object> shadow : nfindSnapshots) {
        	Car myCar = (Car) shadow.get();
        	System.out.println(myCar);
		}
        
        
        Changes mychanges = javers.findChanges( QueryBuilder.anyDomainObject().build() );
                
        
        /////////////////////////
        /*Person robert = Person.builder().login("bob").name("Martine").position("Developer").build();
        personRepository.save(robert);
        
        List<Person> persons = personRepository.findAll();
        
        Person p = persons.get(0);
        p.setName("Ravi");
        personRepository.save(p);
        
        JqlQuery query = QueryBuilder.byInstanceId("5d06856c76e79c550c33d6da", Person.class).build();
        List<CdoSnapshot> shadows = javers.findSnapshots(query);
        for (CdoSnapshot cdoSnapshot : shadows) {
			System.out.println(cdoSnapshot);
		}*/
	}
	
	@JaversAuditable
	private void saveJavers() {
		Car car1 = Car.builder().brand("Ferrari").year("2015").horsePower(670L).model("488").build();
		carRepository.saveAll(Arrays.asList(car1));


		// find a car by model
		Car car488 = carRepository.findByModel("488");
		// modify the car
		car488.setHorsePower(800L);
		car488.setBrand("New Ferrari");
		carRepository.save(car488);
		log.info("Car488: {}", car488);
		
		Car ncar488 = carRepository.findByModel("488");
		ncar488.setHorsePower(100L);
		ncar488.setBrand("New My_Ferrari");
		carRepository.save(ncar488);
		log.info("nCar488: {}", ncar488);
	}
	
}
