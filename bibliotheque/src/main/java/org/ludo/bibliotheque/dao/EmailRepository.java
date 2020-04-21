package org.ludo.bibliotheque.dao;

import org.ludo.bibliotheque.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {

    Email findByNom(String relance);
}
