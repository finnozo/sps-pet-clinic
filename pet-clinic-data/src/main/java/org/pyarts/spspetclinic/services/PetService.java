package org.pyarts.spspetclinic.services;

import org.pyarts.spspetclinic.model.Pet;
import org.pyarts.spspetclinic.services.util.JpaRepositoryService;

public interface PetService extends JpaRepositoryService<Pet, Long> {

}
