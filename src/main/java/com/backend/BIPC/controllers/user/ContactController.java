package com.backend.BIPC.controllers.user;

import com.backend.BIPC.entities.user.Contact;
import com.backend.BIPC.services.user.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/save-contact")
    public ResponseEntity<String> saveContact(@Valid @RequestBody Contact contact){
        try{
            contactService.save(contact);
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("your is failed to execute");
        }
        return ResponseEntity.ok("Your request is sent successfully to the admin out team will contact you soon");
    }
    @GetMapping("/contact")
    public List<Contact> contact(){
        return contactService.getAll();
    }
}
