package com.example.explorer.items.item_repo;

import com.example.explorer.items.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
    Item findItemByName(String name);
}
