package com.agrica.p2p.hdf.hdfservice.model;

import com.agrica.p2p.hdf.hdfservice.views.Views;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "referentiel")
public class ReferentielFlux  implements Serializable {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column(unique = true)
    @NotNull
    @JsonView({Views.Light.class, Views.Full.class})
    private String code;

    @JsonView(Views.Full.class)
    private String type;

    @JsonProperty
    @JsonView(Views.Full.class)
    private String libelle;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 3)
    @JsonView({Views.Light.class,Views.Full.class})
    private SensEnum sens;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

     public SensEnum getSens() {
        return sens;
    }

    public void setSens(SensEnum sens) {
        this.sens = sens;
    }

    @Override
    public String toString() {
        return "ReferentielFlux{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                ", libelle='" + libelle + '\'' +
                ", sens=" + sens +
                '}';
    }
}
