package com.example.explorer.items.item_controller;

import com.example.explorer.items.item_serv.ItemServ;
import com.example.explorer.items.item_serv.WeaponServ;
import com.example.explorer.items.model.Item;
import com.example.explorer.items.model.Weapon;
import com.example.explorer.items.model.dto.ItemDTO;
import com.example.explorer.items.model.dto.WeaponDTO;
import com.example.explorer.utility.exception.InformationExistException;
import com.example.explorer.utility.exception.InformationNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/item")
public class ItemWeaponController {
    @Autowired
    private WeaponServ weaponServ;

    @Autowired
    private ItemServ itemServ;

    private final Logger logger = LoggerFactory.getLogger(ItemWeaponController.class);

    @PostMapping("create-item")
    public ResponseEntity<?> createItem(@RequestBody WeaponDTO weaponDTO, @RequestBody ItemDTO itemDTO){
        logger.info("Calling create item");
        try {
            String returnItem = null;
            if (weaponDTO != null){
                returnItem = weaponServ.createWeapon(weaponDTO);
            }else {
                returnItem = itemServ.createItem(itemDTO);
            }
            return ResponseEntity.ok(returnItem);

        }catch (InformationExistException informationExistException){
            logger.debug("Information already exits");
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            logger.debug("an Error occurred well calling createItem with message : " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{type}")
    public ResponseEntity<?> getAllItems(@PathVariable(value = "type") String type){
        try {
            String returnItem = null;
            if (type.equalsIgnoreCase("item")){
                List<Item> item = itemServ.getAllItems();
                return ResponseEntity.ok(item);
            }else {
                List<Weapon> weapons = weaponServ.getAllWeapons();
                return ResponseEntity.ok(weapons);
            }


        }catch (InformationNotFoundException informationNotFoundException){
            logger.debug("Information already exits");
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            logger.debug("an Error occurred well calling getAllItems with message : " + e.getMessage());
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

        }catch (InformationNotFoundException informationNotFoundException){
            logger.debug("No item found with item name : " + name);
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            logger.debug("an Error occurred well calling getItemByName with message : " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/update/{type}/{name}")
    public ResponseEntity<?> updateItemByName(@PathVariable(value = "type") String type, @PathVariable(value = "name") String name, @RequestBody WeaponDTO weaponDTO,
                                              @RequestBody ItemDTO itemDTO){
        try {
            String returnObject = null;
            if (type.equalsIgnoreCase("weapon")){
                returnObject = weaponServ.updateWeapon(weaponDTO, name);
            }else {
                returnObject = itemServ.updateItem(itemDTO, name);
            }
            return ResponseEntity.ok(returnObject);

        }catch (InformationNotFoundException informationNotFoundException){
            logger.debug("No item found with item name : " + name);
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            logger.debug("an Error occurred well calling updateItemByName with message : " + e.getMessage());
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

        }catch (InformationNotFoundException informationNotFoundException){
            logger.debug("No item found with item name : " + name);
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            logger.debug("an Error occurred well calling deleteItemByName with message : " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

}
