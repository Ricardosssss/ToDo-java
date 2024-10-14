package com.xd.todoapp.services;

import com.xd.todoapp.entities.Item;
import com.xd.todoapp.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;

    public Item createItem(Item item) {
        return itemsRepository.save(item);
    }

    public void deleteItem(long id) {
        itemsRepository.deleteById(id);
    }
}
