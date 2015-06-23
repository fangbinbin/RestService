package com.fangbinbin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fangbinbin.model.Person;
import com.fangbinbin.model.SerializablePerson;
import com.fangbinbin.service.IPersonService;
import com.fangbinbin.util.RestURIConstants;

@Controller
@RequestMapping(RestURIConstants.API)
public class PersonController {

	private final static Logger logger = LoggerFactory.getLogger(PersonController.class);
	private IPersonService personService;
	
	@Autowired
	public PersonController(IPersonService personService) {
		this.personService = personService;
	}

	@RequestMapping(RestURIConstants.RANDOM_PEOPLE)
	@ResponseBody
	public Person randomPerson() {
		return personService.getRandom();
	}
	
	@RequestMapping(RestURIConstants.GET_PEOPLE)
	@ResponseBody
	public Person getById(@PathVariable Long id) {
		return personService.getById(id);
	}
	
	/* same as above method, but is mapped to
	 * /api/person?id= rather than /api/person/{id}
	 */
	@RequestMapping(value=RestURIConstants.PEOPLE, params="id")
	@ResponseBody
	public Person getByIdFromParam(@RequestParam("id") Long id) {
		return personService.getById(id);
	}
	
	/**
	 * Saves new person. Spring automatically binds the name
	 * and age parameters in the request to the person argument
	 * @param person
	 * @return String indicating success or failure of save
	 */
	@RequestMapping(value=RestURIConstants.SAVE_PEOPLE, method=RequestMethod.POST)
	@ResponseBody
	public String savePerson(Person person) {
		logger.info("fangbinbin /api/person");
		personService.save(person);
		return "Saved person: " + person.toString();
	}
	
	//curl -i -H "Content-Type: application/json" -X POST -d '{"name": "fangbinbin", "age": 16}' 'http://192.168.7.177:8080/RestService/api/sperson'
	@RequestMapping(value=RestURIConstants.SAVE_PEOPLE_V2, method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String saveSPerson(@RequestBody Person person) {
		logger.info("fangbinbin /api/sperson");
		return "Saved person: " + person.toString();
	}
	
}
