package com.mixdev.blog.dao;

import java.util.List;

import com.mixdev.blog.domain.Contact;

public interface ContactDAO {

	public void addContact(Contact contact);

	public List<Contact> listContact();

	public void removeContact(Integer id);
}