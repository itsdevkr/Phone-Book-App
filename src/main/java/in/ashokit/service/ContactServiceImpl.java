package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.binding.Contact;
import in.ashokit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public String saveContact(Contact contact) {
		Contact newContact = contactRepository.save(contact);
		if(newContact.getContactId()!=null) {
			return "Contact saved";
		}else {
			return "Contact failed to save";
		}
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		return contacts;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> c = contactRepository.findById(contactId);
		if(c.isPresent()) {
			return c.get();
		}
		return null;
	}

	@Override
	public String updateContact(Contact contact) {
		
		if(contactRepository.existsById(contact.getContactId())) {
			contactRepository.save(contact);
			return "Update success";
		}else {
			return "No record found";
		}
	}

	@Override
	public String deleteContactById(Integer contactId) {
		if(contactRepository.existsById(contactId)) {
			contactRepository.deleteById(contactId);
			return "Record deleted";
		}else {
			return "No Record Found";
		}
	}

}
