package com.agrica.p2p.hdf.hdfservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "referentiel")
public class ReferentielFlux  implements Serializable {

    @Id
    private String id;

    @Column(unique = true)
    private String code;

    private String type;

    private String libelle;

    @Enumerated(EnumType.STRING)
    @Column(length = 3)
    private SensEnum Sens;

}
