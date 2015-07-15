package org.openhds.service.impl.update;

import org.openhds.domain.model.update.InMigration;
import org.openhds.domain.model.update.OutMigration;
import org.openhds.service.AuditableCollectedServiceTest;
import org.openhds.service.impl.FieldWorkerService;
import org.openhds.service.impl.census.IndividualService;
import org.openhds.service.impl.census.ResidencyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZonedDateTime;

/**
 * Created by bsh on 7/13/15.
 */
public class OutMigrationServiceTest extends AuditableCollectedServiceTest<OutMigration, OutMigrationService> {

    @Autowired
    FieldWorkerService fieldWorkerService;

    @Autowired
    VisitService visitService;

    @Autowired
    IndividualService individualService;

    @Autowired
    ResidencyService residencyService;

    @Autowired
    @Override
    protected void initialize(OutMigrationService service) {
        this.service = service;
    }

    @Override
    protected OutMigration makeInvalidEntity() {
        return new OutMigration();
    }

    @Override
    protected OutMigration makeValidEntity(String name, String id) {
        OutMigration outMigration = new OutMigration();
        outMigration.setUuid(id);

        outMigration.setCollectedBy(fieldWorkerService.findAll(UUID_SORT).toList().get(0));
        outMigration.setCollectionDateTime(ZonedDateTime.now());

        outMigration.setVisit(visitService.findAll(UUID_SORT).toList().get(0));
        outMigration.setIndividual(individualService.findAll(UUID_SORT).toList().get(0));
        outMigration.setResidency(residencyService.findAll(UUID_SORT).toList().get(0));
        outMigration.setMigrationDate(ZonedDateTime.now().minusYears(1));

        return outMigration;
    }
}