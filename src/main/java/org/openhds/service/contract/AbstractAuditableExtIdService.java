package org.openhds.service.contract;

import org.openhds.domain.contract.AuditableExtIdEntity;
import org.openhds.repository.contract.AuditableExtIdRepository;
import org.openhds.repository.results.EntityIterator;
import org.springframework.data.domain.Sort;

/**
 * Created by wolfe on 6/11/15.
 */
public abstract class AbstractAuditableExtIdService<T extends AuditableExtIdEntity, V extends AuditableExtIdRepository<T>>
        extends AbstractAuditableCollectedService<T, V>{

    public AbstractAuditableExtIdService(V repository) {
        super(repository);
    }

    public EntityIterator<T> findByExtId(Sort sort, String extId) {
        return iteratorFromPageable(pageable -> repository.findByDeletedFalseAndExtId(extId, pageable), sort);
    }

}
