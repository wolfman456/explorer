package com.example.explorer.items.item_serv.item_serv_impl;

import com.example.explorer.items.item_repo.ItemRepo;
import com.example.explorer.items.item_serv.ItemServ;
import com.example.explorer.items.model.Item;
import com.example.explorer.items.model.dto.ItemDTO;
import com.example.explorer.utility.CustomerMapper;
import com.example.explorer.utility.ExplorerResponse;
import com.example.explorer.utility.exception.InformationExistException;
import com.example.explorer.utility.exception.InformationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ItemServImpl implements ItemServ {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    CustomerMapper customerMapper;

    private ExplorerResponse explorerResponse = new ExplorerResponse();

    @Override
    public List<Item> getAllItems() {

        return itemRepo.findAll();
    }

    @Override
    public String getItemByName(String name) {
        Item item = itemRepo.findItemByName(name);
        if (item==null){
            throw new InformationNotFoundException(HttpStatus.NOT_FOUND, "no item with name " +name + " found", LocalDateTime.now());
        }
        explorerResponse.setItem(item);
        return customerMapper.mapper(explorerResponse);
    }

    @Override
    public String createItem(ItemDTO itemDTO) {
        if (itemRepo.findItemByName(itemDTO.getName()) != null){
            throw new InformationExistException(HttpStatus.BAD_REQUEST, "item with name " + itemDTO.getName() + " already exists", LocalDateTime.now());
        }
        Item item = Item.builder().name(itemDTO.getName())
                .uniqueItem(itemDTO.getUniqueItem())
                .description(itemDTO.getDescription())
                .effect(itemDTO.getEffect())
                .magic(itemDTO.getMagic())
                .weight(itemDTO.getWeight())
                .maxStackAmount(itemDTO.getMaxStackAmount()).build();
        itemRepo.save(item);
        explorerResponse.setItem(item);
        return customerMapper.mapper(explorerResponse);
    }

    @Override
    public String updateItem(ItemDTO itemDTO, String name) {
        Item item = itemRepo.findItemByName(name);
        if (item != null){
            if (itemDTO.getUniqueItem() != null){
                item.setUniqueItem(itemDTO.getUniqueItem());
            }
            if (itemDTO.getMagic() != null){
                item.setMagic(itemDTO.getMagic());
            }
            if (itemDTO.getName() != null){
                item.setName(itemDTO.getName());
            }
            if (itemDTO.getEffect() != null){
                item.setEffect(itemDTO.getEffect());
            }
            if (itemDTO.getWeight() != null){
                item.setWeight(itemDTO.getWeight());
            }
            if (itemDTO.getDescription() != null){
                item.setDescription(itemDTO.getDescription());
            }
            if (itemDTO.getMaxStackAmount() != null){
                item.setMaxStackAmount(itemDTO.getMaxStackAmount());
            }
            itemRepo.save(item);
            explorerResponse.setItem(item);
            return customerMapper.mapper(explorerResponse);

        }else{
            throw new InformationNotFoundException(HttpStatus.NOT_FOUND, "item with name " + itemDTO.getName() + " was not found", LocalDateTime.now());
        }
    }

    @Override
    public String deleteItem(String name) {
        return null;
    }
}
