package com.howtodoinjava.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "actor")
public class ActorModel extends RepresentationModel<ActorModel> {
	private Long actorId;
	private String firstName;
	private String lastName;
	private LocalDate lastUpdated;
}
