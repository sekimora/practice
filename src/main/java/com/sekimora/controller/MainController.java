package com.sekimora.controller;

import com.sekimora.models.Animal;
import com.sekimora.models.Cage;
import com.sekimora.models.Owner;
import com.sekimora.services.AnimalService;
import com.sekimora.services.CageService;
import com.sekimora.services.OwnerService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/demo")
public class MainController {
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private CageService cageService;
    @Autowired
    private AnimalService animalService;


    @PostMapping(value = "/add_owner")
    public //@ResponseBody
    String addNewOwner(@RequestParam String firstname, @RequestParam String secondname, @RequestParam String adr_owner) {
        Owner w = new Owner();
        w.setFirstname(firstname);
        w.setSecondname(secondname);
        w.setAdr_owner(adr_owner);
        ownerService.save(w);
        return "Владелец " + firstname + " " + secondname + " сохранён";
    }

    @GetMapping(path = "/get_owners")
    public @ResponseBody
    Iterable<Owner> getAllOwners() {
        return ownerService.getAll();
    }

    @GetMapping(path = "/count_owners")
    public String countOwners() {
        return "Найдено владельцев: " + ownerService.countAll();
    }

    @GetMapping(value = "/del_owner")
    public String delOwner(@RequestParam(value = "id_owner") Integer id_owner) throws ResourceNotFoundException {
//        Owner ow=ownerService.findById(id_owner).orElseThrow(()->
//                new ResourceNotFoundException("Нет владельца с ID = "+id_owner));

        for (Animal a : animalService.findByOwnerId(id_owner)) {
            animalService.delOne(a.getId_animal());
        }

        ownerService.delOne(id_owner);


        return "Владелец №" + id_owner + " удалён";
    }


    @PostMapping(value = "/add_cage")
    public //@ResponseBody
    String addNewCage(@RequestParam Integer width_cage, @RequestParam Integer lenght_cage, @RequestParam Integer height_cage) {
        Cage c = new Cage();
        c.setWidth_cage(width_cage);
        c.setLenght_cage(lenght_cage);
        c.setHeight_cage(height_cage);
        cageService.save(c);
        return "Клетка " + width_cage + "x" + lenght_cage + "x" + height_cage + " сохранена";
    }

    @GetMapping(path = "/get_cages")
    public @ResponseBody
    Iterable<Cage> getAllCages() {
        return cageService.getAll();
    }

    @GetMapping(path = "/count_cages")
    public String countCages() {
        return "Найдено клеток: " + cageService.countAll();
    }

    @GetMapping(value = "/del_cage")
    public String delCage(@RequestParam(value = "id_cage") Integer id_cage) {
        for (Animal a : animalService.findByCageId(id_cage)) {
            animalService.delOne(a.getId_animal());
        }
        cageService.delOne(id_cage);
        return "Клетка №" + id_cage + " удалена";
    }


    @PostMapping(value = "/add_animal")
    public //@ResponseBody
    String addNewAnimal(@Valid @RequestParam String kind_animal, @Valid @RequestParam String name_animal, @Valid @RequestParam String sex_animal, @Valid @RequestParam Integer weight_animal, @Valid @RequestParam Integer id_owner, @Valid @RequestParam Integer id_cage) throws ResourceNotFoundException {
        Animal a = new Animal();
        a.setKind_animal(kind_animal);
        a.setName_animal(name_animal);
        a.setSex_animal(sex_animal);
        a.setWeight_animal(weight_animal);
        Owner ow = ownerService.findById(id_owner).orElseThrow(() ->
                new ResourceNotFoundException("Нет владельца с ID = " + id_owner));
        a.setOwner_animal(ow);
        Cage cc = cageService.findById(id_cage).orElseThrow(() ->
                new ResourceNotFoundException("Нет владельца с ID = " + id_cage));
        a.setCage_animal(cc);
        animalService.save(a);
        return kind_animal + " по кличке " + name_animal + " в сохрненных";
    }

    @GetMapping(path = "/get_animals")
    public @ResponseBody
    Iterable<Animal> getAllAnimals() {
        return animalService.getAll();
    }


    public Owner getOwnerWithId(Integer id) {
        Owner own = null;
        for (Owner o : ownerService.getAll()) {
            if (o.getId_owner() == id)
                own = o;

        }
        return own;
    }

    public Cage getCageWithId(Integer id) {
        Cage cc = null;
        for (Cage c : cageService.getAll()) {
            if (c.getId_cage() == id)
                cc = c;

        }
        return cc;
    }


    @GetMapping(path = "/count_animals")
    public String countAnimals() {
        return "Найдено животных: " + animalService.countAll();
    }

    @GetMapping(value = "/del_animal")
    public String delAnimal(@RequestParam(value = "id_animal") Integer id_animal) {
        animalService.delOne(id_animal);
        return "Животное №" + id_animal + " удалено";
    }


}
