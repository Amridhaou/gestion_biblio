package com.gestion_biblio.gestion_biblio.controllers;

import com.gestion_biblio.gestion_biblio.models.Categories;
import com.gestion_biblio.gestion_biblio.services.CategoriesService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.print.attribute.standard.PresentationDirection;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/Categories")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService ;
    @GetMapping
    public List<Categories> Afficher_Le_Categories()
    {
        return categoriesService.Afficher_Le_Categories();
    }
    @PostMapping()

    public ResponseEntity<?>  Ajout_Categories(@RequestBody Categories categories)
    {
        categories.setLivres(null);
        Categories categoriesAjouter = categoriesService.Ajout_Categories(categories);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoriesAjouter.getId())
                .toUri();
        return ResponseEntity.created(location).body(categoriesAjouter);


    }
    @GetMapping("/{id}")
    public  ResponseEntity<?> Recherche_Categories(Integer id )
    {
        Categories categories = categoriesService.Recherche_Categories(id);
        return categories != null ? ResponseEntity.ok(categories) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("categories n'existe pas");

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> Supprimer_Categories(Integer id )
    {
        if (categoriesService.Recherche_Categories(id) != null) {
            categoriesService.Supprimer_Categories(id);
            return ResponseEntity.ok("les categories est supprimer");
        }
        else { return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("categories n'existe pas");}
        }


    @PutMapping()

    public ResponseEntity<?>  Modifier_Categories(@RequestBody Categories categories , Integer id)
    {

        Categories categoriesRecherche = categoriesService.Recherche_Categories(id);

            if (categoriesRecherche != null) {
                categoriesRecherche.setNom(categories.getNom());
                Categories categoriesModifier = categoriesService.Ajout_Categories(categoriesRecherche);
                return ResponseEntity.ok(categoriesModifier);
            }
            else { return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("categories n'existe pas");}




    }


}
