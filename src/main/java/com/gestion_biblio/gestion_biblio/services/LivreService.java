package com.gestion_biblio.gestion_biblio.services;

import com.gestion_biblio.gestion_biblio.models.Livre;
import com.gestion_biblio.gestion_biblio.repositories.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {
    @Autowired
    private LivreRepository livreRepository ;
    public List<Livre> Afficher_Les_Livre()
    {
        return livreRepository.findAll();
    }

    public Livre Ajout_Livre(Livre livre)
    {
        return livreRepository.save(livre);
    }
    public Livre Recherche_Livre(Integer livre_id )
    {
        return livreRepository.findById(livre_id).orElse(null) ;
    }
    public void Supprimer_Livre(Integer livre_id )
    {
        livreRepository.deleteById(livre_id);
    }





}
