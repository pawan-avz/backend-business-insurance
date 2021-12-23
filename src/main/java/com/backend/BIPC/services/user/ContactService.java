package com.backend.BIPC.services.user;

import com.backend.BIPC.entities.user.Contact;
import com.backend.BIPC.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact save(Contact contact){
        return contactRepository.save(contact);
    }

    public List<Contact> getAll(){
        return  contactRepository.findAll();
    }
}
