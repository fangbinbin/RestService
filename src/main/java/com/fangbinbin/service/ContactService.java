package com.fangbinbin.service;

import java.util.List;

import com.fangbinbin.model.Contact;

public interface ContactService {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}