package com.gestion_biblio.gestion_biblio.services;
import com.gestion_biblio.gestion_biblio.models.Categories;
import com.gestion_biblio.gestion_biblio.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository ;
    public List<Categories> Afficher_Le_Categories()
    {
        return categoriesRepository.findAll();
    }

    public Categories Ajout_Categories(Categories categories)
    {
        return categoriesRepository.save(categories);
    }
    public Categories Recherche_Categories(Integer categories_id )
    {
        return categoriesRepository.findById(categories_id).orElse(null) ;
    }
    public void Supprimer_Categories(Integer categories_id )
    {
        categoriesRepository.deleteById(categories_id);
    }
}
