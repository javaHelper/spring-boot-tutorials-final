package com.example.repository;

import java.util.List;

import com.example.model.Contact;

public interface ContactRepository {
	public List<Contact> find(Integer offset, Integer rowCount);
}
