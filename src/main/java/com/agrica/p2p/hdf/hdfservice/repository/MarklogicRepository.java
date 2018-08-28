package com.agrica.p2p.hdf.hdfservice.repository;

import com.agrica.p2p.hdf.hdfservice.RepositoryConfiguration;
import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.BinaryDocumentManager;
import com.marklogic.client.document.DocumentRecord;
import com.marklogic.client.io.BytesHandle;
import com.marklogic.client.query.StructuredQueryBuilder;
import io.github.malteseduck.springframework.data.marklogic.core.MarkLogicOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.marklogic.client.DatabaseClientFactory.newClient;

@Repository
public class MarklogicRepository {

    @Autowired
    private MarkLogicOperations ops;

    private DatabaseClient client;

    public MarklogicRepository() {
        this.client = newClient("qualif-marklogic-vip.agrica.loc", 8000, "HOR-FINAL", new DatabaseClientFactory.BasicAuthContext("yk3764", "Byyfaozc833"));
    }

    public List<DocumentRecord> queryML(String property, String value) {
        StructuredQueryBuilder sqb = new StructuredQueryBuilder();
        
        return ops.search(sqb.value(sqb.jsonProperty(property), value));
    }

    public byte[] getBinary(String docID) {
        BinaryDocumentManager docMgr = client.newBinaryDocumentManager();
        docMgr.setMetadataExtraction(BinaryDocumentManager.MetadataExtraction.PROPERTIES);

        return docMgr.read(docID, new BytesHandle()).get();
    }
}
