package com.howtodoinjava.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.howtodoinjava.entity.Actor;

public interface ActorService {
	Page<Actor> findActorsPaginated(Pageable pageable);
}
