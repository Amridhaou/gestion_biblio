package com.gestion_biblio.gestion_biblio.models;

import jakarta.persistence.*;

import java.util.List;

@Table(name="CatalogueEnLine")
@Entity
public class CatalogueEnLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private Integer id;
    @OneToMany(mappedBy = "catalogueEnLine", cascade = CascadeType.ALL)
    private List<Livre> livres;


    public CatalogueEnLine(Integer id, List<Livre> livres) {
        this.id = id;
        this.livres = livres;
    }

    public CatalogueEnLine() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
