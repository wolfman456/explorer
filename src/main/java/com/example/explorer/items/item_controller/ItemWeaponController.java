package com.example.explorer.items.item_controller;

import com.example.explorer.items.item_serv.ItemServ;
import com.example.explorer.items.item_serv.WeaponServ;
import com.example.explorer.items.model.Item;
import com.example.explorer.items.model.Weapon;
<<<<<<< HEAD
import com.example.explorer.items.model.dto.CreateItemDTO;
=======
>>>>>>> fdfcb05288bd7dd02b25283a1fa8a3bb22ece579
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
@RequestMapping("/api/v1/admin/item")
public class ItemWeaponController {
    @Autowired
    private WeaponServ weaponServ;

    @Autowired
    private ItemServ itemServ;

    private final Logger logger = LoggerFactory.getLogger(ItemWeaponController.class);

    @PostMapping("create-item")
<<<<<<< HEAD
    public ResponseEntity<?> createItem(@RequestBody CreateItemDTO createItemDTO) {
        logger.info("Calling create item");
        try {
            String returnItem = null;
            if (createItemDTO.getWeaponDTO() != null) {
                returnItem = weaponServ.createWeapon(createItemDTO.getWeaponDTO());
            } else {
                returnItem = itemServ.createItem(createItemDTO.getItemDTO());
            }
            return ResponseEntity.ok(returnItem);

        } catch (InformationExistException informationExistException) {
            logger.debug("Information already exits");
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
=======
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
>>>>>>> fdfcb05288bd7dd02b25283a1fa8a3bb22ece579
            logger.debug("an Error occurred well calling createItem with message : " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{type}")
<<<<<<< HEAD
    public ResponseEntity<?> getAllItems(@PathVariable(value = "type") String type) {
        try {
            String returnItem = null;
            if (type.equalsIgnoreCase("item")) {
                List<Item> item = itemServ.getAllItems();
                return ResponseEntity.ok(item);
            } else {
=======
    public ResponseEntity<?> getAllItems(@PathVariable(value = "type") String type){
        try {
            String returnItem = null;
            if (type.equalsIgnoreCase("item")){
                List<Item> item = itemServ.getAllItems();
                return ResponseEntity.ok(item);
            }else {
>>>>>>> fdfcb05288bd7dd02b25283a1fa8a3bb22ece579
                List<Weapon> weapons = weaponServ.getAllWeapons();
                return ResponseEntity.ok(weapons);
            }

<<<<<<< HEAD
        } catch (InformationNotFoundException informationNotFoundException) {
            logger.debug("Information already exits");
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
=======

        }catch (InformationNotFoundException informationNotFoundException){
            logger.debug("Information already exits");
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
>>>>>>> fdfcb05288bd7dd02b25283a1fa8a3bb22ece579
            logger.debug("an Error occurred well calling getAllItems with message : " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
<<<<<<< HEAD

    @GetMapping("/{type}/{name}")
    public ResponseEntity<?> getItemByName(@PathVariable(value = "type") String type, @PathVariable(value = "name") String name) {
        try {
            String returnItems = null;
            if (type.equalsIgnoreCase("weapon")) {
                returnItems = weaponServ.getWeaponByName(name);
            } else {
=======
    @GetMapping("/{type}/{name}")
    public ResponseEntity<?> getItemByName(@PathVariable(value = "type") String type, @PathVariable(value = "name") String name){
        try {
            String returnItems = null;
            if(type.equalsIgnoreCase("weapon")){
                returnItems = weaponServ.getWeaponByName(name);
            }else {
>>>>>>> fdfcb05288bd7dd02b25283a1fa8a3bb22ece579
                returnItems = itemServ.getItemByName(name);
            }
            return ResponseEntity.ok(returnItems);

<<<<<<< HEAD
        } catch (InformationNotFoundException informationNotFoundException) {
            logger.debug("No item found with item name : " + name);
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
=======
        }catch (InformationNotFoundException informationNotFoundException){
            logger.debug("No item found with item name : " + name);
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
>>>>>>> fdfcb05288bd7dd02b25283a1fa8a3bb22ece579
            logger.debug("an Error occurred well calling getItemByName with message : " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/update/{type}/{name}")
<<<<<<< HEAD
    public ResponseEntity<?> updateItemByName(@PathVariable(value = "type") String type, @PathVariable(value = "name") String name, @RequestBody CreateItemDTO createItemDTO) {
        try {
            String returnObject = null;
            if (type.equalsIgnoreCase("weapon")) {
                returnObject = weaponServ.updateWeapon(createItemDTO.getWeaponDTO(), name);
            } else {
                returnObject = itemServ.updateItem(createItemDTO.getItemDTO(), name);
            }
            return ResponseEntity.ok(returnObject);

        } catch (InformationNotFoundException informationNotFoundException) {
            logger.debug("No item found with item name : " + name);
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
=======
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
>>>>>>> fdfcb05288bd7dd02b25283a1fa8a3bb22ece579
            logger.debug("an Error occurred well calling updateItemByName with message : " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/delete/{type}/{name}")
<<<<<<< HEAD
    public ResponseEntity<?> deleteItemByName(@PathVariable(value = "type") String type, @PathVariable(value = "name") String name) {
        try {
            if (type.equalsIgnoreCase("weapon")) {
                weaponServ.deleteWeapon(name);
            } else {
=======
    public ResponseEntity<?> deleteItemByName(@PathVariable(value = "type") String type, @PathVariable(value = "name") String name){
        try {
            if (type.equalsIgnoreCase("weapon")){
                weaponServ.deleteWeapon(name);
            }else {
>>>>>>> fdfcb05288bd7dd02b25283a1fa8a3bb22ece579
                itemServ.deleteItem(name);
            }
            return ResponseEntity.ok("item with name : " + name + " deleted");

<<<<<<< HEAD
        } catch (InformationNotFoundException informationNotFoundException) {
            logger.debug("No item found with item name : " + name);
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
=======
        }catch (InformationNotFoundException informationNotFoundException){
            logger.debug("No item found with item name : " + name);
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
>>>>>>> fdfcb05288bd7dd02b25283a1fa8a3bb22ece579
            logger.debug("an Error occurred well calling deleteItemByName with message : " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

}
