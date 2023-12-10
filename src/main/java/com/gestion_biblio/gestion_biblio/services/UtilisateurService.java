package com.gestion_biblio.gestion_biblio.services;

import com.gestion_biblio.gestion_biblio.models.Reservations;
import com.gestion_biblio.gestion_biblio.models.Utilisateur;
import com.gestion_biblio.gestion_biblio.repositories.ReservationsRepository;
import com.gestion_biblio.gestion_biblio.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository ;
    public List<Utilisateur> Afficher_Le_Utilisateur()
    {
        return utilisateurRepository.findAll();
    }

    public Utilisateur Ajout_Utilisateur(Utilisateur utilisateur)
    {
        return utilisateurRepository.save(utilisateur);
    }
    public Utilisateur Recherche_Utilisateur(Integer utilisateur_id )
    {
        return utilisateurRepository.findById(utilisateur_id).orElse(null) ;
    }
    public void Supprimer_Utilisateur(Integer utilisateur_id )
    {
        utilisateurRepository.deleteById(utilisateur_id);
    }
}
