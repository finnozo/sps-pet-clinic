package org.pyarts.spspetclinic.bootstrap;

import org.pyarts.spspetclinic.model.Owner;
import org.pyarts.spspetclinic.model.Vet;
import org.pyarts.spspetclinic.services.OwnerService;
import org.pyarts.spspetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Sushil");
        owner1.setLastName("Dangi");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Sandeep");
        owner2.setLastName("Kumar");
        ownerService.save(owner2);

        System.out.println("Owner Loaded...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("AXE");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Rahul");
        vet2.setLastName("KRK");
        vetService.save(vet2);
        System.out.println("Vet Loaded...");
    }
}