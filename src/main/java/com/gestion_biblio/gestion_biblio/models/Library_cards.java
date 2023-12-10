package com.gestion_biblio.gestion_biblio.models;

import jakarta.persistence.*;

import java.util.Date;
@Table(name="Library_cards")
@Entity
public class Library_cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private Integer id;

}
