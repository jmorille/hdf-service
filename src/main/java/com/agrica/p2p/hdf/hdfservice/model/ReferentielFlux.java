package com.agrica.p2p.hdf.hdfservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "referentiel")
public class ReferentielFlux  implements Serializable {


    public interface Light {};

    @Id
    private String id;

    @Column(unique = true)
    @JsonView(Light.class)
    private String code;

    private String type;

    @JsonProperty
    private String libelle;

    @Enumerated(EnumType.STRING)
    @Column(length = 3)
    @JsonView(Light.class)
    private SensEnum sens;

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
