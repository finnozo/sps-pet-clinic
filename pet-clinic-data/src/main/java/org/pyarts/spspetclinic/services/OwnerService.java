package org.pyarts.spspetclinic.services;

import org.pyarts.spspetclinic.model.Owner;
import org.pyarts.spspetclinic.services.util.CrudRepositoryService;

public interface OwnerService extends CrudRepositoryService<Owner, Long> {

    Owner findByLastName(String lastName);

    Owner findByFirstName(String firstName);

}
