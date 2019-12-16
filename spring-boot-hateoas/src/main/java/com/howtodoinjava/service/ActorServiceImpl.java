package com.howtodoinjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.howtodoinjava.entity.Actor;
import com.howtodoinjava.repository.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService {
	@Autowired
	private ActorRepository actorRepository;

	@Override
	public Page<Actor> findActorsPaginated(Pageable pageable) {
		return actorRepository.findAll(pageable);
	}
}