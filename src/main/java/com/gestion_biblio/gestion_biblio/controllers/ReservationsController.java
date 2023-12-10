package com.gestion_biblio.gestion_biblio.controllers;

import com.gestion_biblio.gestion_biblio.models.Categories;
import com.gestion_biblio.gestion_biblio.models.Livre;
import com.gestion_biblio.gestion_biblio.models.Reservations;
import com.gestion_biblio.gestion_biblio.services.CategoriesService;
import com.gestion_biblio.gestion_biblio.services.LivreService;
import com.gestion_biblio.gestion_biblio.services.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/Reservations")
public class ReservationsController {
    @Autowired
    private ReservationsService reservationsService ;
    @GetMapping
    public List<Reservations> Afficher_Le_Reservations()
    {
        return reservationsService.Afficher_Le_Reservations();
    }
    @PostMapping()

    public ResponseEntity<?>  Ajout_Reservations(@RequestBody Reservations reservations)
    {
        Reservations reservationsAjouter = reservationsService.Ajout_Reservations(reservations);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(reservationsAjouter.getId())
                .toUri();
        return ResponseEntity.created(location).body(reservationsAjouter);


    }
    @GetMapping("/{id}")
    public  ResponseEntity<?> Recherche_Reservations(Integer id )
    {
        Reservations reservations = reservationsService.Recherche_Reservations(id);
        return reservations != null ? ResponseEntity.ok(reservations) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reservations n'existe pas");

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> Supprimer_Reservations(Integer id )
    {
        if (reservationsService.Recherche_Reservations(id) != null) {
            reservationsService.Supprimer_Reservations(id);
            return ResponseEntity.ok("les Reservations est supprimer");
        }
        else { return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reservations n'existe pas");}
    }


    @PutMapping()

    public ResponseEntity<?>  Modifier_Reservations(@RequestBody Reservations reservations , Integer id)
    {

        Reservations reservationsRecherche = reservationsService.Recherche_Reservations(id);

        if (reservationsRecherche != null) {
            reservationsRecherche.setUtilisateur(reservations.getUtilisateur());
            reservationsRecherche.setLivre(reservations.getLivre());
            reservationsRecherche.setDateReservation(reservations.getDateReservation());
            Reservations categoriesModifier = reservationsService.Ajout_Reservations(reservationsRecherche);
            return ResponseEntity.ok(categoriesModifier);
        }
        else { return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("reservations n'existe pas");}




    }
}
