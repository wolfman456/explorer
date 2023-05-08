package com.example.explorer.items.model.dto;

public class CreateItemDTO {
    private WeaponDTO weaponDTO;
    private ItemDTO itemDTO;

    public WeaponDTO getWeaponDTO() {
        return weaponDTO;
    }

    public void setWeaponDTO(WeaponDTO weaponDTO) {
        this.weaponDTO = weaponDTO;
    }

    public ItemDTO getItemDTO() {
        return itemDTO;
    }

    public void setItemDTO(ItemDTO itemDTO) {
        this.itemDTO = itemDTO;
    }
}