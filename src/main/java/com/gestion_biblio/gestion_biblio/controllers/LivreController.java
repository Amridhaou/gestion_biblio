package com.gestion_biblio.gestion_biblio.controllers;

import com.gestion_biblio.gestion_biblio.models.Categories;
import com.gestion_biblio.gestion_biblio.models.Livre;
import com.gestion_biblio.gestion_biblio.services.CategoriesService;
import com.gestion_biblio.gestion_biblio.services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/Livre")
public class LivreController {
    @Autowired
    private LivreService livreService ;
    @GetMapping
    public List<Livre> Afficher_Les_Livre()
    {
        return livreService.Afficher_Les_Livre();
    }
    @PostMapping()

    public ResponseEntity<?> Ajout_Livre(@RequestBody Livre livre)
    {
        Livre livreAjouter = livreService.Ajout_Livre(livre);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(livreAjouter.getId())
                .toUri();
        return ResponseEntity.created(location).body(livreAjouter);


    }
    @GetMapping("/{id}")
    public  ResponseEntity<?> Recherche_Livre(Integer id )
    {
        Livre livre = livreService.Recherche_Livre(id);
        return livre != null ? ResponseEntity.ok(livre) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livre n'existe pas");

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> Supprimer_Livre(Integer id )
    {
        if (livreService.Recherche_Livre(id) != null) {
            livreService.Supprimer_Livre(id);
            return ResponseEntity.ok("les Livres est supprimer");
        }
        else { return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livre n'existe pas");}
    }


    @PutMapping()

    public ResponseEntity<?>  Modifier_Livre(@RequestBody Livre livre , Integer id)
    {

        Livre livreRecherche = livreService.Recherche_Livre(id);

        if (livreRecherche != null) {
            livreRecherche.setTitre(livre.getTitre());
            livreRecherche.setAuteur(livre.getAuteur());
            livreRecherche.setDatePublication(livre.getDatePublication());
            livreRecherche.setIsbn(livre.getIsbn());
            livreRecherche.setCategories(livre.getCategories());
            livreRecherche.setCatalogueEnLine(livre.getCatalogueEnLine());
            livreRecherche.setReservations(livre.getReservations());
            Livre livreModifier = livreService.Ajout_Livre(livreRecherche);
            return ResponseEntity.ok(livreModifier);
        }
        else { return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livre n'existe pas");}




    }
}
