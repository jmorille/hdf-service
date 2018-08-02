package com.agrica.p2p.hdf.hdfservice.repository;

import com.marklogic.client.document.DocumentRecord;
import com.marklogic.client.query.StructuredQueryBuilder;
import io.github.malteseduck.springframework.data.marklogic.core.MarkLogicOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MarklogicRepository {

    @Autowired
    private MarkLogicOperations ops;

    public List<DocumentRecord> queryML(String property, String value) {
        StructuredQueryBuilder sqb = new StructuredQueryBuilder();

        return ops.search(sqb.value(sqb.jsonProperty(property), value));
    }
}
