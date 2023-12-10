package com.gestion_biblio.gestion_biblio.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Table(name="Categories")
@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Nom")
    private String nom;

    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private List<Livre> livres;


    public Categories(Integer id, String nom, List<Livre> livres) {
        this.id = id;
        this.nom = nom;
        this.livres = livres;
    }

    public Categories() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }
}
