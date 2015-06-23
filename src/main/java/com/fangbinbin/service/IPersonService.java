package com.fangbinbin.service;

import com.fangbinbin.model.Person;

public interface IPersonService {
	public Person getRandom();
	public Person getById(Long id);
	public void save(Person person);
}
