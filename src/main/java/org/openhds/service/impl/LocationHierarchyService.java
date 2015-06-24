package org.openhds.service.impl;

import org.openhds.domain.model.LocationHierarchy;
import org.openhds.repository.concrete.LocationHierarchyRepository;
import org.openhds.service.contract.AbstractAuditableExtIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wolfe on 6/23/15.
 */
@Service
public class LocationHierarchyService extends AbstractAuditableExtIdService<LocationHierarchy, LocationHierarchyRepository>{

    @Autowired
    FieldWorkerService fieldWorkerService;

    @Autowired
    public LocationHierarchyService(LocationHierarchyRepository repository) {
        super(repository);
    }

    @Override
    protected LocationHierarchy makeUnknownEntity() {
        LocationHierarchy locationHierarchy = new LocationHierarchy();
        locationHierarchy.setName("unknown");
        locationHierarchy.setExtId("unknown");
        locationHierarchy.setCollectedBy(fieldWorkerService.getUnknownEntity());
        return locationHierarchy;
    }
}
