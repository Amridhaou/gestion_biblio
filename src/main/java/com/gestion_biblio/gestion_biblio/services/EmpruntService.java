package com.gestion_biblio.gestion_biblio.services;

import com.gestion_biblio.gestion_biblio.models.Emprunt;
import com.gestion_biblio.gestion_biblio.repositories.EmpruntRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpruntService {
    @Autowired
    private EmpruntRepository empruntRepository ;
    public List<Emprunt> Afficher_Le_Emprunt()
    {
        return empruntRepository.findAll();
    }

    public Emprunt Ajout_Emprunt(Emprunt emprunt)
    {
        return empruntRepository.save(emprunt);
    }
    public Emprunt Recherche_Emprunt(Integer emprunt_id )
    {
        return empruntRepository.findById(emprunt_id).orElse(null) ;
    }
    public void Supprimer_Emprunt(Integer emprunt_id )
    {
        empruntRepository.deleteById(emprunt_id);
    }
}
