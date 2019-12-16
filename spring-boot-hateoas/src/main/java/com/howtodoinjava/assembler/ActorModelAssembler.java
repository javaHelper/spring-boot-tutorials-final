package com.howtodoinjava.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Service;

import com.howtodoinjava.controller.ActorController;
import com.howtodoinjava.entity.Actor;
import com.howtodoinjava.model.ActorModel;


@Service
public class ActorModelAssembler extends RepresentationModelAssemblerSupport<Actor, ActorModel>{

	public ActorModelAssembler() {
		super(ActorController.class, ActorModel.class);
	}

	@Override
	public ActorModel toModel(Actor entity) {
		ActorModel actorModel = createModelWithId(entity.getActorId(), entity);
		
		actorModel.setActorId(entity.getActorId());
		actorModel.setFirstName(entity.getFirstName());
		actorModel.setLastName(entity.getLastName());
		actorModel.setLastUpdated(entity.getLastUpdated());
		return actorModel;
	}
}
