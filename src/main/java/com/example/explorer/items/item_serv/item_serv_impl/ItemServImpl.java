package com.example.explorer.items.item_serv.item_serv_impl;

import com.example.explorer.items.item_repo.ItemRepo;
import com.example.explorer.items.item_serv.ItemServ;
import com.example.explorer.items.model.Item;
import com.example.explorer.items.model.dto.ItemDTO;
import com.example.explorer.utility.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServImpl implements ItemServ {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<Item> getAllItems() {

        return itemRepo.findAll();
    }

    @Override
    public String getItemByName(String name) {
        return null;
    }

    @Override
    public String createItem(ItemDTO itemDTO) {
        return null;
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
