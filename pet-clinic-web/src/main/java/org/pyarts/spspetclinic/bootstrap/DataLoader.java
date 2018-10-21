package org.pyarts.spspetclinic.bootstrap;

import org.pyarts.spspetclinic.model.Owner;
import org.pyarts.spspetclinic.model.Vet;
import org.pyarts.spspetclinic.services.OwnerService;
import org.pyarts.spspetclinic.services.VetService;
import org.pyarts.spspetclinic.services.map.OwnerServiceMap;
import org.pyarts.spspetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Sushil");
        owner1.setLastName("Dangi");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Sandeep");
        owner2.setLastName("Kumar");
        ownerService.save(owner2);

        System.out.println("Owner Loaded...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("AXE");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Rahul");
        vet2.setLastName("KRK");
        vetService.save(vet2);
        System.out.println("Vet Loaded...");
    }
}
