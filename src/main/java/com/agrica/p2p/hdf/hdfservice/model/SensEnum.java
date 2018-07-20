package com.agrica.p2p.hdf.hdfservice.model;

public enum SensEnum {
    IN("IN"), OUT("OUT");

    private final String code;

    SensEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
