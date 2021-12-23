package com.backend.BIPC.repositories;

import com.backend.BIPC.entities.user.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
