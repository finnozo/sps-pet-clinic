package org.pyarts.spspetclinic.services;

import org.pyarts.spspetclinic.model.Owner;
import org.pyarts.spspetclinic.services.util.JpaRepositoryService;

public interface OwnerService extends JpaRepositoryService<Owner, Long> {

    Owner findByLastName(String lastName);

}
