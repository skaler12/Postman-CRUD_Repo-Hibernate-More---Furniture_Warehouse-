package com.example.furniture_warehouse.Manager;

import com.example.furniture_warehouse.Repository.FurnitureRepository;
import com.example.furniture_warehouse.Repository.OwnerRepository;
import com.example.furniture_warehouse.Repository.TypeRepository;
import com.example.furniture_warehouse.Repository.UserRepository;
import com.example.furniture_warehouse.dao.Furniture;
import com.example.furniture_warehouse.dao.Owner;
import com.example.furniture_warehouse.dao.Type;
import com.example.furniture_warehouse.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FurnitureService {
    private FurnitureRepository furnitureRepository;

    private TypeRepository typeRepository;

    private OwnerRepository ownerRepository;

     FurnitureService (){};


     //tutaj testuje funkcjonalnosc apki
@Autowired
    public FurnitureService(FurnitureRepository furnitureRepository, TypeRepository typeRepository,OwnerRepository ownerRepository){
        this.furnitureRepository=furnitureRepository;
        this.typeRepository=typeRepository;
        this.ownerRepository=ownerRepository;

        //sprawdzam  jakd dziala relacja jeden do wiele i dodaje typ sofa do obiektu mebel



       Type type = new Type();
       type.setType("sofa");
       typeRepository.save(type);

        Furniture mebel =new Furniture();
        mebel.setType(type);
        furnitureRepository.save(mebel);
     //////////////////////////////
      Owner wlasciciel = new Owner();
      wlasciciel.setOwner_name("Grzegorz");
      ownerRepository.save(wlasciciel);

      mebel.setOwner(wlasciciel);
      furnitureRepository.save(mebel);





      /////////////////////////////
    /*
    User uzytkownik = new User();
    uzytkownik.setName("Weronika");
    uzytkownik.setSurname("Teterycz");
    UserRepository.save(uzytkownik);

    mebel.setUsers(uzytkownik);
    furnitureRepository.save(mebel);
*/


    }


    //pobieranie
    public Optional<Furniture> findById(Long id){
        return furnitureRepository.findById(id);
    }

    //pobierania
    public Iterable<Furniture> findAll() {
        return furnitureRepository.findAll();
    }

    //zapisywanie
    public Furniture save(Furniture furniture) {
        return furnitureRepository.save(furniture);
    }

    //usuwanie
    public void deleteById(Long id) {
        furnitureRepository.deleteById(id);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Furniture( "Oland", 90));
        save(new Furniture("Kali",65));
    }
}
