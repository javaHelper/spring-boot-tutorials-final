package com.howtodoinjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.assembler.ActorModelAssembler;
import com.howtodoinjava.entity.Actor;
import com.howtodoinjava.model.ActorModel;
import com.howtodoinjava.service.ActorService;

@RestController
public class ActorController {
	@Autowired
	private ActorService actorService;

	@Autowired
	private PagedResourcesAssembler<Actor> pagedAssembler;

	@Autowired
	private ActorModelAssembler actorModelAssembler;

	@GetMapping("/api/actor/actors")
	public ResponseEntity<PagedModel<ActorModel>> getAllActors(Pageable pageable) {
		Page<Actor> actorPages = actorService.findActorsPaginated(pageable);
		PagedModel<ActorModel> pagedModel = pagedAssembler.toModel(actorPages, actorModelAssembler);
		return new ResponseEntity<>(pagedModel, HttpStatus.OK);
	}
}
