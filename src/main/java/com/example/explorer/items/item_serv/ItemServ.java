package com.example.explorer.items.item_serv;

import com.example.explorer.items.model.Item;
import com.example.explorer.items.model.dto.ItemDTO;

import java.util.List;

public interface ItemServ {
    List<Item> getAllItems();
    String getItemByName(String name);
    String createItem(ItemDTO itemDTO);
    String updateItem(ItemDTO itemDTO, String name);
    String deleteItem(String name);
}
