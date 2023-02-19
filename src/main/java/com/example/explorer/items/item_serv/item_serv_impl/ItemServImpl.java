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

    private ExplorerResponse explorerResponse;

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
            throw new InformationExistException(HttpStatus.BAD_REQUEST, "iten with name " + itemDTO.getName() + " already exists", LocalDateTime.now());
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
        return null;
    }

    @Override
    public String deleteItem(String name) {
        return null;
    }
}
