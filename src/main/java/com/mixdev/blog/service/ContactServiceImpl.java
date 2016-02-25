package com.mixdev.blog.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mixdev.blog.dao.ContactDAO;
import com.mixdev.blog.domain.Contact;
 
@Service
public class ContactServiceImpl implements ContactService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    private ContactDAO contactDAO;
 
    @Transactional
    public void addContact(Contact contact) {
        LOGGER.debug("Adding a new contact entry with information: {}", contact);
        contactDAO.addContact(contact);
    }
 
    @Transactional
    public List<Contact> listContact() {
        LOGGER.debug("Finding all Contact entries");

        return contactDAO.listContact();
    }
 
    @Transactional
    public void removeContact(Integer id) {
        contactDAO.removeContact(id);
    }
}
