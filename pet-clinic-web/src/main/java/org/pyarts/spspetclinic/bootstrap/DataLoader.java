package org.pyarts.spspetclinic.bootstrap;

import org.pyarts.spspetclinic.model.*;
import org.pyarts.spspetclinic.services.OwnerService;
import org.pyarts.spspetclinic.services.PetTypeService;
import org.pyarts.spspetclinic.services.SpecialityService;
import org.pyarts.spspetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Sushil");
        owner1.setLastName("Dangi");
        owner1.setAddress("Chouparan Jharkhand");
        owner1.setCity("Hazaribagh");
        owner1.setTelephone("+98-9835957865");

        Pet sushilPet = new Pet();
        sushilPet.setPetType(saveDogPetType);
        sushilPet.setOwner(owner1);
        sushilPet.setBirthDate(LocalDate.now());
        sushilPet.setName("Rosco");
        owner1.getPets().add(sushilPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Sandeep");
        owner2.setLastName("Kumar");
        owner2.setAddress("Chouparan Jharkhand");
        owner2.setCity("Hazaribagh");
        owner2.setTelephone("+98-9835957865");

        Pet sandeepCat = new Pet();
        sandeepCat.setPetType(saveCatPetType);
        sandeepCat.setOwner(owner2);
        sandeepCat.setBirthDate(LocalDate.now());
        sandeepCat.setName("Meow");
        owner2.getPets().add(sandeepCat);
        // test
        ownerService.save(owner2);

        System.out.println("Owner Loaded...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("AXE");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Rahul");
        vet2.setLastName("KRK");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("Vet Loaded...");
    }
}
