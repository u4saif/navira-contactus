package com.navira.contactus.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.navira.contactus.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
