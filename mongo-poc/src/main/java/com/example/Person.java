package com.example;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Person {
	@Id
	private String id;
	@Field
	private String firstName;
	@Field
//	@Setter(value = AccessLevel.NONE)
//	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String lastName;
	
	@Field
	private String emailId;
	@Field
	private List<Hobbies> hobbies;
	@Field
	private LocalDate birthDate;
	
	/*public void setLastName(String lastName) {
		if(lastName == null) {
			this.lastName = null;
		}
		else
			this.lastName = lastName;
	}*/
}
