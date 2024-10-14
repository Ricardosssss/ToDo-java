package com.xd.todoapp.controllers;

import com.xd.todoapp.DTOs.ItemRequestDTO;
import com.xd.todoapp.entities.Item;
import com.xd.todoapp.entities.Lista;
import com.xd.todoapp.repositories.ListsRepository;
import com.xd.todoapp.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;
    @Autowired
    private ListsRepository listsRepository;

    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody ItemRequestDTO itemReq) {
        Item item = new Item();
        item.setContent(itemReq.getContent());

        Optional<Lista> list = listsRepository.findById(itemReq.getListId());
        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        item.setList(list.get());

        return ResponseEntity.ok(itemsService.createItem(item));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<HttpStatus> deleteItem(@PathVariable long id) {
        itemsService.deleteItem(id);
        return new HttpEntity<>(HttpStatus.OK);
    }
}
