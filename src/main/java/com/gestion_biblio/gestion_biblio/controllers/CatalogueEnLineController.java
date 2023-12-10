package com.gestion_biblio.gestion_biblio.controllers;

import com.gestion_biblio.gestion_biblio.models.CatalogueEnLine;
import com.gestion_biblio.gestion_biblio.models.Categories;
import com.gestion_biblio.gestion_biblio.services.CatalogueEnLineService;
import com.gestion_biblio.gestion_biblio.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/CatalogueEnLine")
public class CatalogueEnLineController {
    @Autowired
    private CatalogueEnLineService catalogueEnLineService ;
    @GetMapping
    public List<CatalogueEnLine> Afficher_Le_CatalogueEnLine()
    {
        return catalogueEnLineService.Afficher_Le_CatalogueEnLine();
    }
    @PostMapping()

    public ResponseEntity<?> Ajout_CatalogueEnLine(@RequestBody CatalogueEnLine catalogueEnLine)
    {
        CatalogueEnLine catalogueEnLineAjouter = catalogueEnLineService.Ajout_CatalogueEnLine(catalogueEnLine);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(catalogueEnLineAjouter.getId())
                .toUri();
        return ResponseEntity.created(location).body(catalogueEnLineAjouter);


    }
    @GetMapping("/{id}")
    public  ResponseEntity<?> Recherche_CatalogueEnLine(Integer id )
    {
        CatalogueEnLine catalogueEnLine = catalogueEnLineService.Recherche_CatalogueEnLine(id);
        return catalogueEnLine != null ? ResponseEntity.ok(catalogueEnLine) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("CatalogueEnLine n'existe pas");

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> Supprimer_CatalogueEnLine(Integer id )
    {
        if (catalogueEnLineService.Recherche_CatalogueEnLine(id) != null) {
            catalogueEnLineService.Supprimer_CatalogueEnLine(id);
            return ResponseEntity.ok("le CatalogueEnLine est supprimer");
        }
        else { return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("CatalogueEnLine n'existe pas");}
    }


    @PutMapping()

    public ResponseEntity<?>  Modifier_CatalogueEnLine(@RequestBody CatalogueEnLine catalogueEnLine , Integer id)
    {

        CatalogueEnLine catalogueEnLineRecherche = catalogueEnLineService.Recherche_CatalogueEnLine(id);

        if (catalogueEnLineRecherche != null) {

            CatalogueEnLine catalogueEnLineModifier = catalogueEnLineService.Ajout_CatalogueEnLine(catalogueEnLineRecherche);
            return ResponseEntity.ok(catalogueEnLineModifier);
        }
        else { return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("CatalogueEnLine n'existe pas");}




    }
}
