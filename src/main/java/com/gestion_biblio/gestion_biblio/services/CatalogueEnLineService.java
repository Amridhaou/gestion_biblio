package com.gestion_biblio.gestion_biblio.services;

import com.gestion_biblio.gestion_biblio.models.CatalogueEnLine;
import com.gestion_biblio.gestion_biblio.models.Livre;
import com.gestion_biblio.gestion_biblio.repositories.CatalogueEnLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueEnLineService {
    @Autowired
    private CatalogueEnLineRepository catalogueEnLineRepository ;
    public List<CatalogueEnLine> Afficher_Le_CatalogueEnLine()
    {
        return catalogueEnLineRepository.findAll();
    }

    public CatalogueEnLine Ajout_CatalogueEnLine(CatalogueEnLine catalogueEnLine)
    {
        return catalogueEnLineRepository.save(catalogueEnLine);
    }
    public CatalogueEnLine Recherche_CatalogueEnLine(Integer catalogueEnLine_id )
    {
        return catalogueEnLineRepository.findById(catalogueEnLine_id).orElse(null) ;
    }
    public void Supprimer_CatalogueEnLine(Integer catalogueEnLine_id )
    {
        catalogueEnLineRepository.deleteById(catalogueEnLine_id);
    }
}
