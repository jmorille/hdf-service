package com.agrica.p2p.hdf.hdfservice.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "flux")
public class Flux implements Serializable  {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_reception")
    private Date dateReception;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_fin_delai")
    private Date dateFinDelai;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_annulation")
    private Date dateAnnulation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_debut_delai")
    private Date dateDebutDelai;

    @Column(columnDefinition = "TEXT")
    private String commentaire;

    @Column(name = "id_gateway")
    private Integer idGateway;



}
