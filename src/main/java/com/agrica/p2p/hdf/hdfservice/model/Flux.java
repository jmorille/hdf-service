package com.agrica.p2p.hdf.hdfservice.model;

import com.agrica.p2p.hdf.hdfservice.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView(Views.Light.class)
    private Date dateReception;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_debut_delai")
    private Date dateDebutDelai;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_fin_delai")
    private Date dateFinDelai;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_annulation")
    private Date dateAnnulation;


    @Column(columnDefinition = "TEXT")
    @JsonView(Views.Light.class)
    private String commentaire;

    @Column(name = "id_gateway")
    @JsonView(Views.Light.class)
    private Integer idGateway;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "code", referencedColumnName = "code")
    @JsonView(Views.Light.class)
    private ReferentielFlux referentiel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateReception() {
        return dateReception;
    }

    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }

    public Date getDateDebutDelai() {
        return dateDebutDelai;
    }

    public void setDateDebutDelai(Date dateDebutDelai) {
        this.dateDebutDelai = dateDebutDelai;
    }

    public Date getDateFinDelai() {
        return dateFinDelai;
    }

    public void setDateFinDelai(Date dateFinDelai) {
        this.dateFinDelai = dateFinDelai;
    }

    public Date getDateAnnulation() {
        return dateAnnulation;
    }

    public void setDateAnnulation(Date dateAnnulation) {
        this.dateAnnulation = dateAnnulation;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Integer getIdGateway() {
        return idGateway;
    }

    public void setIdGateway(Integer idGateway) {
        this.idGateway = idGateway;
    }

    public ReferentielFlux getReferentiel() {
        return referentiel;
    }

    public void setReferentiel(ReferentielFlux referentiel) {
        this.referentiel = referentiel;
    }

    @Override
    public String toString() {
        return "Date réception : " + dateReception.toString() +
                "Date début délai : " + dateDebutDelai.toString() +
                "Date fin délai : " + dateFinDelai.toString() +
                "Date annulation : " + dateAnnulation.toString() +
                "Commentaire : " + commentaire +
                "Id gateway : " + idGateway +
                "Référentiel : " + referentiel.toString()
                ;
    }
}
