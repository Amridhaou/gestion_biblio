package com.gestion_biblio.gestion_biblio.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Table(name="Emprunt")
@Entity
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "livre_id")
    private Livre livre;

    @Column(name = "DateDebut")
    private Date dateDebut;

    @Column(name = "DateFin")
    private Date dateFin;

    public Emprunt(Integer id, Utilisateur utilisateur, Livre livre, Date dateDebut, Date dateFin) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.livre = livre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Emprunt(Integer id) {
        this.id = id;
    }

    public Emprunt() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
