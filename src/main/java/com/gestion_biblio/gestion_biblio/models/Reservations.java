package com.gestion_biblio.gestion_biblio.models;

import jakarta.persistence.*;

import java.util.Date;
@Table(name="Reservations")//nom de la table
@Entity//obligatoire
public class Reservations {
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

    @Column(name = "DateReservation")
    private Date dateReservation;

    public Reservations(Integer id, Utilisateur utilisateur, Livre livre, Date dateReservation) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.livre = livre;
        this.dateReservation = dateReservation;
    }

    public Reservations() {
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

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }
}
