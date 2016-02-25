package com.mixdev.blog.service;

import java.util.List;

import com.mixdev.blog.domain.Contact;

public interface ContactService {

	public void addContact(Contact contact);

	public List<Contact> listContact();

	public void removeContact(Integer id);
}
