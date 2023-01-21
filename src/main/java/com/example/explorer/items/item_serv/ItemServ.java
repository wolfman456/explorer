package com.example.explorer.items.item_serv;

import com.example.explorer.items.model.dto.ItemDTO;
import com.example.explorer.items.model.dto.WeaponDTO;

public interface ItemServ {
    String getAllItems();
    String getItemByName(String name);
    String createItem(ItemDTO itemDTO);
    String updateItem(ItemDTO itemDTO, String name);
    String deleteItem(String name);
}
