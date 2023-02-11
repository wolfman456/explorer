package com.example.explorer.items.item_controller;


import com.example.explorer.items.item_serv.ItemServ;
import com.example.explorer.items.item_serv.WeaponServ;
import com.example.explorer.items.model.dto.ItemDTO;
import com.example.explorer.items.model.dto.WeaponDTO;
import com.example.explorer.utility.exception.InformationExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/item")
public class ItemWeaponController {
    @Autowired
    private WeaponServ weaponServ;

    @Autowired
    private ItemServ itemServ;

    @PostMapping("create-item")
    public ResponseEntity<?> createItem(@RequestBody WeaponDTO weaponDTO, @RequestBody ItemDTO itemDTO){
        try {
            String returnItem = null;
            if (weaponDTO != null){
                returnItem = weaponServ.createWeapon(weaponDTO);
            }else {
                returnItem = itemServ.createItem(itemDTO);
            }
            return ResponseEntity.ok(returnItem);

        }catch (InformationExistException informationExistException){

            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{type}")
    public ResponseEntity<?> getAllItems(@PathVariable(value = "type") String type){
        try {
            String returnItem = null;
            if (type.equalsIgnoreCase("item")){
                returnItem = itemServ.getAllItems();
            }else {
                returnItem = weaponServ.getAllWeapons();
            }
            return ResponseEntity.ok(returnItem);

        }catch (InformationExistException informationExistException){

            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/{type}/{name}")
    public ResponseEntity<?> getItemByName(@PathVariable(value = "type") String type, @PathVariable(value = "name") String name){
        try {
            String returnItems = null;
            if(type.equalsIgnoreCase("weapon")){
                returnItems = weaponServ.getWeaponByName(name);
            }else {
                returnItems = itemServ.getItemByName(name);
            }
            return ResponseEntity.ok(returnItems);

        }catch (InformationExistException informationExistException){

            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/update/{type}/{name}")
    public ResponseEntity<?> updateItemByName(@PathVariable(value = "type") String type, @PathVariable(value = "name") String name){
        try {

        }catch (InformationExistException informationExistException){

            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/delete/{type}/{name}")
    public ResponseEntity<?> deleteItemByName(@PathVariable(value = "type") String type, @PathVariable(value = "name") String name){
        try {
            if (type.equalsIgnoreCase("weapon")){
                weaponServ.deleteWeapon(name);
            }else {
                itemServ.deleteItem(name);
            }
            return ResponseEntity.ok("item with name : " + name + " deleted");

        }catch (InformationExistException informationExistException){

            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

}
