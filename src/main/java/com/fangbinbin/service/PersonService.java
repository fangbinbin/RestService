package com.fangbinbin.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.fangbinbin.model.Person;

@Service
public class PersonService implements IPersonService {

	String[] names = {"Nikolaus Otto", "Robert Ford", "Gottlieb Daimler", "Lt. General Masaharu Homma"};

	public Person getRandom() {
		Person person = new Person();
		person.setName(randomName());
		person.setAge(randomAge());
		return person;
	}

	public Person getById(Long id) {
		Person person = new Person();
		person.setName(names[id.intValue()]);
		person.setAge(50);
		return person;
	}
	
	public void save(Person person) {
		// Save person to database ...
	}
	
	private Integer randomAge() {
		Random random = new Random();
		return 10 + random.nextInt(100);
	}

	private String randomName() {
		Random random = new Random();
		return names[random.nextInt(names.length)];
	}

}
