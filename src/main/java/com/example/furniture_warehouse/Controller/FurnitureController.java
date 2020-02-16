package com.example.furniture_warehouse.Controller;


import com.example.furniture_warehouse.Manager.FurnitureService;
import com.example.furniture_warehouse.Repository.FurnitureRepository;
import com.example.furniture_warehouse.dao.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/furniture")
public class FurnitureController {

private FurnitureService furnitureService;

public  FurnitureController(){};

@Autowired
public FurnitureController(FurnitureService furnitureService){
    this.furnitureService=furnitureService;
}
//to potem do wywalenia
   @GetMapping("/next")
   public String index(Model model){
    return "index";
   }

    @GetMapping("/all")
    public Iterable<Furniture>getAll(){
    return furnitureService.findAll();

    }

    @GetMapping
    public Optional<Furniture> getById(@RequestParam Long index) {
        return furnitureService.findById(index);
    }

    @PostMapping
    public Furniture addVideo(@RequestBody Furniture furniture) {
        return furnitureService.save(furniture);

    }

    @PutMapping
    public Furniture updateVideo(@RequestBody Furniture furniture) {

        return furnitureService.save(furniture);
    }

    @DeleteMapping
    public void deleteVideo(Long index) {
        furnitureService.deleteById(index);
    }

}
