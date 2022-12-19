package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.Contact;
import in.ashokit.service.ContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value = "This is contact API")
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	@PostMapping("/contact")
	@ApiOperation(value = "This operation is used to create new contact")
	public String createContact(@RequestBody Contact contact) {
		String status = contactService.saveContact(contact);
		return status;
	}
	
	@GetMapping("/contacts")
	@ApiOperation(value = "This operation is used to get all contacts")
	public List<Contact> getAllContacts(){
		List<Contact> allContacts = contactService.getAllContacts();
		return allContacts;
	}
	
	@GetMapping("/contact/{contactId}")
	public Contact getContactById(@PathVariable("contactId") Integer cid) {
		Contact c = contactService.getContactById(cid);
		return c;
	}
	
	@PutMapping("/contact")
	public String updateContact(@RequestBody Contact contact) {
		String status = contactService.updateContact(contact);
		return status;
	}
	
	@DeleteMapping("/contact/{contactId}")
	public String deleteContact(@PathVariable Integer contactId) {
		return contactService.deleteContactById(contactId);
	}
}
