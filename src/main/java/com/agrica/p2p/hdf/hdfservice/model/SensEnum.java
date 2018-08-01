package com.agrica.p2p.hdf.hdfservice.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = SensSerializer.class)
public enum SensEnum {
    IN("IN", "Entrant"), OUT("OUT", "Sortant");

    private final String code;
    private final String label;

    SensEnum(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}
