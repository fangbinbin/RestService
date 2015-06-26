package com.fangbinbin.dao;

import java.util.List;

import com.fangbinbin.model.Contact;

public interface ContactDAO {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}