package org.openhds.service.impl;

import org.openhds.domain.model.Location;
import org.openhds.repository.concrete.LocationRepository;
import org.openhds.service.contract.AbstractAuditableExtIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wolfe on 6/9/15.
 */

@Service
public class LocationService extends AbstractAuditableExtIdService<Location, LocationRepository> {

    @Autowired
    FieldWorkerService fieldWorkerService;

    @Autowired
    LocationHierarchyService locationHierarchyService;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        super(locationRepository);
    }

    @Override
    protected Location makeUnknownEntity() {
        Location location = new Location();
        location.setName("unknown");
        location.setExtId("unknown");
        location.setCollectedBy(fieldWorkerService.getUnknownEntity());
        location.setLocationHierarchy(locationHierarchyService.getUnknownEntity());
        return location;
    }
}
