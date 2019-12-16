package com.howtodoinjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.howtodoinjava.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long>{

}
