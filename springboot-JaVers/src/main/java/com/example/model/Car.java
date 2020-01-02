package com.example.model;

import java.time.LocalDateTime;

import org.javers.core.metamodel.annotation.DiffIgnore;
import org.javers.core.metamodel.annotation.PropertyName;
import org.javers.core.metamodel.annotation.TypeName;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TypeAlias("Car")
@TypeName("Car")
@Document
public class Car {
	@Id
	private String id;
	private String brand;
	private String year;
	private String model;
	//@PropertyName(value="HORSE_POWER")
	private Long horsePower;
	@DiffIgnore
	@Version
	private String version;
	
	@CreatedDate
	private LocalDateTime createdDate;
}
