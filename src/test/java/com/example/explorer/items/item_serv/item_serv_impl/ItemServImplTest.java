package com.example.explorer.items.item_serv.item_serv_impl;

import com.example.explorer.items.item_repo.ItemRepo;
import com.example.explorer.items.item_serv.ItemServ;
import com.example.explorer.items.model.Item;
import com.example.explorer.items.model.dto.ItemDTO;
import com.example.explorer.utility.CustomerMapper;
import com.example.explorer.utility.ExplorerResponse;
import com.example.explorer.utility.exception.InformationExistException;
import com.example.explorer.utility.exception.InformationNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemServImplTest {

    @Mock
    private ItemRepo itemRepo;

    @Mock
    private CustomerMapper customerMapper;

    @Mock
    private ExplorerResponse explorerResponse;

    @InjectMocks
    private ItemServ itemServ = new ItemServImpl();

    private ItemDTO itemDTO;

    @Before
    public void setUp() {
        itemDTO = ItemDTO.builder().name("item1").uniqueItem(false).description("desc").effect("effect")
                .magic(true).weight(10.0).maxStackAmount(5).build();
    }

    @Test
    public void testGetAllItems() {
        Item item1 = Item.builder().name("item1").build();
        Item item2 = Item.builder().name("item2").build();
        when(itemRepo.findAll()).thenReturn(Arrays.asList(item1, item2));
        List<Item> items = itemServ.getAllItems();
        assertEquals(2, items.size());
        assertEquals("item1", items.get(0).getName());
        assertEquals("item2", items.get(1).getName());
    }

    @Test
    public void testGetItemByName() {
        Item item = Item.builder().name("item1").build();
        when(itemRepo.findItemByName("item1")).thenReturn(item);
        when(customerMapper.mapper(explorerResponse)).thenReturn("item1");
        String result = itemServ.getItemByName("item1");
        assertEquals("item1", result);
    }

    @Test(expected = InformationNotFoundException.class)
    public void testGetItemByNameNotFound() {
        when(itemRepo.findItemByName("item1")).thenReturn(null);
        itemServ.getItemByName("item1");
    }

    @Test(expected = InformationExistException.class)
    public void testCreateItemAlreadyExists() {
        when(itemRepo.findItemByName("item1")).thenReturn(Item.builder().build());
        itemServ.createItem(itemDTO);
    }

    @Test
    public void testCreateItem() {
        when(itemRepo.findItemByName("item1")).thenReturn(null);
        Item item = Item.builder().name("item1").uniqueItem(false).description("desc").effect("effect")
                .magic(true).weight(10.0).maxStackAmount(5).build();
        when(customerMapper.mapper(explorerResponse)).thenReturn("item1");
        String result = itemServ.createItem(itemDTO);
        assertEquals("item1", result);
    }

    @Test
    public void testCreateItemWhenRepoFails() {
        String name = "New Item";
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setName(name);
        when(itemRepo.findItemByName(name)).thenReturn(null);
        doThrow(new RuntimeException()).when(itemRepo).save(any(Item.class));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            itemServ.createItem(itemDTO);
        });

        assertEquals(RuntimeException.class, exception.getClass());
    }

    @Test
    public void testGetAllItemsWhenEmpty() {
        List<Item> items = new ArrayList<>();
        when(itemRepo.findAll()).thenReturn(items);

        List<Item> actualItems = itemServ.getAllItems();

        assertEquals(items, actualItems);
    }
}


