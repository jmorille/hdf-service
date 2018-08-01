package com.agrica.p2p.hdf.hdfservice.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class SensSerializer extends StdSerializer<SensEnum> {

    public SensSerializer() {
        super(SensEnum.class);
    }

    @Override
    public void serialize(SensEnum value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeFieldName("code");
        generator.writeString(value.getCode());
        generator.writeFieldName("label");
        generator.writeString(value.getLabel());
        generator.writeEndObject();
    }
}
