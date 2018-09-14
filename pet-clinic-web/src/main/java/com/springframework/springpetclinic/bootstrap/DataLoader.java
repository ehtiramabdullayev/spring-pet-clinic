package com.springframework.springpetclinic.bootstrap;

import com.springframework.springpetclinic.model.Owner;
import com.springframework.springpetclinic.model.Pet;
import com.springframework.springpetclinic.model.PetType;
import com.springframework.springpetclinic.model.Vet;
import com.springframework.springpetclinic.services.OwnerService;
import com.springframework.springpetclinic.services.PetTypeService;
import com.springframework.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author Ehtiram_Abdullayev on 8/30/2018
 * @project spring-pet-clinic
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);



        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Johnson");
        owner1.setAddress("123 Brick street");
        owner1.setCity("Miami");
        owner1.setTelephone("+36200000000");
        ownerService.save(owner1);

        Pet michealsPet = new Pet();
        michealsPet.setPetType(savedDogPetType);
        michealsPet.setOwner(owner1);
        michealsPet.setBirthDate(LocalDate.now());
        michealsPet.setName("Pichko");
        owner1.getPets().add(michealsPet);


        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Burger");
        owner2.setAddress("987 Mall street");
        owner2.setCity("Las Vegas");
        owner2.setTelephone("+36200000001");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setOwner(owner2);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Shrek");
        owner2.getPets().add(fionasPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owns....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Adams");

        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Axl");
        vet2.setLastName("Rose");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");







    }
}
