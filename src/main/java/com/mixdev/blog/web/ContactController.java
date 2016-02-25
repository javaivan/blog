package com.mixdev.blog.web;

import java.util.Map;

import com.mixdev.blog.domain.Contact;
import com.mixdev.blog.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ContactController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

	@Autowired
	private ContactService contactService;

	@RequestMapping("/index")
	public String listContacts(Map<String, Object> map) {
		LOGGER.debug("Rendering Home page.");

		map.put("contact", new Contact());
		map.put("contactList", contactService.listContact());

		return "contact";
	}
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact,
			BindingResult result) {
		LOGGER.debug("Added a Contact entry with information: {}", contact);

		contactService.addContact(contact);

		return "redirect:/index";
	}

	@RequestMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer contactId) {
		LOGGER.debug("Controller Delete Contact");

		contactService.removeContact(contactId);

		return "redirect:/index";
	}
}
