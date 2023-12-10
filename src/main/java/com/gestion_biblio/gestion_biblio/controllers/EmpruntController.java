package com.gestion_biblio.gestion_biblio.controllers;

import com.gestion_biblio.gestion_biblio.models.Categories;
import com.gestion_biblio.gestion_biblio.models.Emprunt;
import com.gestion_biblio.gestion_biblio.services.CategoriesService;
import com.gestion_biblio.gestion_biblio.services.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/Emprunt")
public class EmpruntController {
    @Autowired
    private EmpruntService empruntService ;
    @GetMapping
    public List<Emprunt> Afficher_Le_Emprunt()
    {
        return empruntService.Afficher_Le_Emprunt();
    }
    @PostMapping()

    public ResponseEntity<?> Ajout_Emprunt(@RequestBody Emprunt emprunt)
    {
        Emprunt empruntAjouter = empruntService.Ajout_Emprunt(emprunt);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(empruntAjouter.getId())
                .toUri();
        return ResponseEntity.created(location).body(empruntAjouter);


    }
    @GetMapping("/{id}")
    public  ResponseEntity<?> Recherche_Emprunt(Integer id )
    {
        Emprunt emprunt = empruntService.Recherche_Emprunt(id);
        return emprunt != null ? ResponseEntity.ok(emprunt) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emprunt n'existe pas");

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> Supprimer_Emprunt(Integer id )
    {
        if (empruntService.Recherche_Emprunt(id) != null) {
            empruntService.Supprimer_Emprunt(id);
            return ResponseEntity.ok("les emprunt est supprimer");
        }
        else { return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("emprunt n'existe pas");}
    }


    @PutMapping()

    public ResponseEntity<?>  Modifier_Emprunt(@RequestBody Emprunt emprunt , Integer id)
    {

        Emprunt empruntRecherche = empruntService.Recherche_Emprunt(id);

        if (empruntRecherche != null) {
            empruntRecherche.setUtilisateur(emprunt.getUtilisateur());
            empruntRecherche.setLivre(emprunt.getLivre());
            empruntRecherche.setDateDebut(emprunt.getDateDebut());
            empruntRecherche.setDateFin(emprunt.getDateFin());
            Emprunt empruntModifier = empruntService.Ajout_Emprunt(empruntRecherche);
            return ResponseEntity.ok(empruntModifier);
        }
        else { return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("emprunt n'existe pas");}




    }

}
