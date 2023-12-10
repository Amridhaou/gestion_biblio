package com.gestion_biblio.gestion_biblio.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Table(name="Utilisateur")
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Adresse")
    private String adresse;

    @Column(name = "numéro_tel")
    private String numéroTel;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;

    @Column(name = "Role")
    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "library_card_id", referencedColumnName = "id")
    private Library_cards Library_cards;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Emprunt> emprunts;


}
