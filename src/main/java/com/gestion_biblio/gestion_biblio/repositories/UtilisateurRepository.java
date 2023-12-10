package com.gestion_biblio.gestion_biblio.repositories;

import com.gestion_biblio.gestion_biblio.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
}
