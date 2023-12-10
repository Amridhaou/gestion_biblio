package com.gestion_biblio.gestion_biblio.services;

import com.gestion_biblio.gestion_biblio.models.Emprunt;
import com.gestion_biblio.gestion_biblio.models.Reservations;
import com.gestion_biblio.gestion_biblio.repositories.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationsService {
    @Autowired
    private ReservationsRepository reservationsRepository ;
    public List<Reservations> Afficher_Le_Reservations()
    {
        return reservationsRepository.findAll();
    }

    public Reservations Ajout_Reservations(Reservations reservations)
    {
        return reservationsRepository.save(reservations);
    }
    public Reservations Recherche_Reservations(Integer reservations_id )
    {
        return reservationsRepository.findById(reservations_id).orElse(null) ;
    }
    public void Supprimer_Reservations(Integer reservations_id )
    {
        reservationsRepository.deleteById(reservations_id);
    }
}
