package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.binding.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{
	
}
